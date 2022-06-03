package com.sparta.delivery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity(name ="oder_table") // DB 테이블 역할을 합니다.
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String restaurantId;

    @Column(nullable = false)
    private String minOrderPrice;

    @Column(nullable = false)
    private String deliveryFee;

    public Order(String restaurantId, String minOrderPrice, String deliveryFee) {
        this.restaurantId = restaurantId;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
}
