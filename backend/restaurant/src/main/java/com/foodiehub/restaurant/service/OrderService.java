package com.foodiehub.restaurant.service;

import com.foodiehub.restaurant.model.Order;
import com.foodiehub.restaurant.model.OrderItem;
import com.foodiehub.restaurant.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(Order order) {

        // 🔗 Link order to items
        for (OrderItem item : order.getItems()) {
            item.setOrder(order);
        }

        return orderRepository.save(order);
    }
}
