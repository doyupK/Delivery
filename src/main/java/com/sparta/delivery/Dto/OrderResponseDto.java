package com.sparta.delivery.Dto;

import com.sparta.delivery.domain.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private String restaurantName;
    private List<OrderFoodsResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderResponseDto(String restaurantName, List<OrderFoodsResponseDto> foods, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.foods = foods;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}
