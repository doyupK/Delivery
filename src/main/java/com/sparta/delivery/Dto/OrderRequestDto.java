package com.sparta.delivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderRequestDto {
    private Long restaurantId;
    private List<OrderFoodsRequestDto> foods;
}
