package com.sparta.delivery.domain;

import com.sparta.delivery.Dto.OrderFoodsResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity(name ="oder_table") // DB 테이블 역할을 합니다.
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID", nullable = false)
    private Restaurant restaurant;


    @Column(nullable = false)
    private int totalPrice;

    public Order(Restaurant restaurant, int totalPrice) {
        this.restaurant = restaurant;
        this.totalPrice = totalPrice;
    }


//    public Order(Restaurant restaurant, String foods, String deliveryFee, int totalPrice) {
//        this.restaurant = restaurant;
//        this.foods = foods;
//        this.deliveryFee = deliveryFee;
//        this.totalPrice = totalPrice;
//    }
}
