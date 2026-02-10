package com.foodiehub.restaurant.controller;

import com.foodiehub.restaurant.dto.CartItemDTO;
import com.foodiehub.restaurant.dto.OrderRequest;
import com.foodiehub.restaurant.model.Order;
import com.foodiehub.restaurant.model.OrderItem;
import com.foodiehub.restaurant.repository.OrderRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // ================= PLACE ORDER =================
    @PostMapping("/place")
    public ResponseEntity<?> placeOrder(@Valid @RequestBody OrderRequest request) {

        // 🔐 BASIC VALIDATION
        if (request.getCustomerName() == null || request.getCustomerName().isBlank()
                || request.getMobileNo() == null || request.getMobileNo().isBlank()
                || request.getDeliveryAddress() == null || request.getDeliveryAddress().isBlank()) {

            return ResponseEntity.badRequest().body("Delivery details are required");
        }

        if (request.getItems() == null || request.getItems().isEmpty()) {
            return ResponseEntity.badRequest().body("Order items cannot be empty");
        }

        // ================= ORDER =================
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setTotalAmount(request.getTotalAmount());

        // DELIVERY INFO
        order.setCustomerName(request.getCustomerName());
        order.setMobileNo(request.getMobileNo());
        order.setDeliveryAddress(request.getDeliveryAddress());

        // ORDER STATUS
        order.setStatus("PLACED");

        // ================= PAYMENT LOGIC =================
        String method = request.getPaymentMethod() != null
                ? request.getPaymentMethod().toUpperCase()
                : "COD";

        order.setPaymentMethod(method);

        if ("COD".equals(method)) {
            order.setPaymentStatus("PENDING");
            order.setPaymentTime(null);
            order.setTransactionId(null);
        } else {
            order.setPaymentStatus("PAID");
            order.setPaymentTime(LocalDateTime.now());
            order.setTransactionId(
                    request.getTransactionId() != null
                            ? request.getTransactionId()
                            : "TXN-" + System.currentTimeMillis()
            );
        }

        // CREATED TIME
        order.setCreatedAt(LocalDateTime.now());

        // ================= ITEMS =================
        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItemDTO c : request.getItems()) {
            OrderItem item = new OrderItem();
            item.setFoodId(c.getFoodId());
            item.setFoodName(c.getName());
            item.setPrice(c.getPrice());
            item.setQuantity(c.getQty());
            item.setOrder(order);
            orderItems.add(item);
        }

        order.setItems(orderItems);

        // SAVE ORDER
        orderRepository.save(order);

        return ResponseEntity.ok("Order placed successfully");
    }

    // ================= USER ORDERS =================
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(
                orderRepository.findByUserIdOrderByIdDesc(userId)
        );
    }

    // ================= ADMIN ORDERS =================
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    // ================= UPDATE STATUS (ADMIN) =================
    @PutMapping("/{orderId}/status")
    public ResponseEntity<?> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam String status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (!status.equals("PLACED")
                && !status.equals("ACCEPTED")
                && !status.equals("DELIVERED")
                && !status.equals("CANCELLED")) {

            return ResponseEntity.badRequest().body("Invalid status");
        }

        order.setStatus(status);

        // 🔥 AUTO COMPLETE COD PAYMENT WHEN DELIVERED
        if ("DELIVERED".equals(status)
                && "COD".equalsIgnoreCase(order.getPaymentMethod())
                && !"PAID".equals(order.getPaymentStatus())) {

            order.setPaymentStatus("PAID");
            order.setPaymentTime(LocalDateTime.now());
        }

        orderRepository.save(order);
        return ResponseEntity.ok("Order status updated");
    }

    // ================= CANCEL ORDER (USER) =================
    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (!order.getStatus().equals("PLACED")) {
            return ResponseEntity.badRequest()
                    .body("Order cannot be cancelled now");
        }

        order.setStatus("CANCELLED");
        orderRepository.save(order);

        return ResponseEntity.ok("Order cancelled successfully");
    }
}
