package com.sparta.delivery.Dto;

import com.sparta.delivery.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class OrderDetailDto {
    String foodName;
    int quantity;
    int price;
    Order order;
}
