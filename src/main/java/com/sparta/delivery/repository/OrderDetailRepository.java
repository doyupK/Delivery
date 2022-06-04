package com.sparta.delivery.repository;

import com.sparta.delivery.domain.Order;
import com.sparta.delivery.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findAllById(Long id);

    List<OrderDetail> findAllByOrder(Order order);
}
