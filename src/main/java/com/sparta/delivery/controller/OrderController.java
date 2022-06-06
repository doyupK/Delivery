package com.sparta.delivery.controller;

import com.sparta.delivery.Dto.OrderRequestDto;
import com.sparta.delivery.Dto.OrderResponseDto;
import com.sparta.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/request")
    public OrderResponseDto Order(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.getOrderResponse(orderRequestDto);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrder(){
        return orderService.getAllOrder();
    }
}