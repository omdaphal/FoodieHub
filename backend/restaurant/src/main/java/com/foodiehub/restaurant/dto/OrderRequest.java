package com.foodiehub.restaurant.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public class OrderRequest {

    // ================= BASIC =================

    @NotNull(message = "UserId is required")
    private Long userId;

    @Positive(message = "Total amount must be greater than 0")
    private double totalAmount;

    @NotEmpty(message = "Order items cannot be empty")
    private List<CartItemDTO> items;

    // ================= DELIVERY =================

    @NotEmpty(message = "Customer name is required")
    @Size(min = 2, max = 100, message = "Customer name must be between 2 and 100 characters")
    private String customerName;

    @NotEmpty(message = "Mobile number is required")
    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Mobile number must be a valid 10-digit Indian number"
    )
    private String mobileNo;

    @NotEmpty(message = "Delivery address is required")
    @Size(min = 5, max = 500, message = "Delivery address must be between 5 and 500 characters")
    private String deliveryAddress;

    // ================= PAYMENT =================

    // COD | UPI | CARD | NET_BANKING
    private String paymentMethod;

    // PENDING | PAID
    private String paymentStatus;

    // Optional (null for COD)
    private String transactionId;

    // ================= GETTERS & SETTERS =================

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

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }

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

    // ================= PAYMENT =================

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
}
