package com.sparta.delivery.repository;

import com.sparta.delivery.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
