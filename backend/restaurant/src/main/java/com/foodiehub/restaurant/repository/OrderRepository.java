package com.foodiehub.restaurant.repository;

import com.foodiehub.restaurant.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Fetch orders of a specific user (latest first)
    List<Order> findByUserIdOrderByIdDesc(Long userId);
}
