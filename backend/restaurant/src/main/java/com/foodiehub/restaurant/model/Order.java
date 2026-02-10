package com.foodiehub.restaurant.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private double totalAmount;

    // 🔥 ORDER STATUS
    @Column(nullable = false)
    private String status = "PLACED";

    // 🔥 DELIVERY INFO
    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false, length = 15)
    private String mobileNo;

    @Column(nullable = false, length = 500)
    private String deliveryAddress;

    // 🔥 PAYMENT INFO
    @Column(nullable = false)
    private String paymentMethod = "COD";   // COD / CARD / NET_BANKING / UPI

    @Column(nullable = false)
    private String paymentStatus = "PENDING"; // PENDING / PAID

    private String transactionId; // null for COD

    // 🔥 PAYMENT TIME
    private LocalDateTime paymentTime;

    // 🔥 ORDER CREATED TIME
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // 🔥 ORDER ITEMS
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItem> items;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // ===== ORDER STATUS =====

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ===== DELIVERY =====

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    // ===== PAYMENT =====

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    // ===== CREATED TIME =====

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // ===== ITEMS =====

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
