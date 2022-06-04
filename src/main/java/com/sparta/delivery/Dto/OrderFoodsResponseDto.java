package com.sparta.delivery.Dto;

import com.sparta.delivery.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderFoodsResponseDto {
    String name;
    int quantity;
    int price;
}
