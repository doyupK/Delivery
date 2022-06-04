package com.sparta.delivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderFoodsRequestDto {
    Long id;
    int quantity;
}
