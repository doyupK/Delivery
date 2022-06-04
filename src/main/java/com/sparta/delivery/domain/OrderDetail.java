package com.sparta.delivery.domain;

import com.sparta.delivery.Dto.OrderDetailDto;
import com.sparta.delivery.Dto.OrderFoodsResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity(name ="oder_detail_table") // DB 테이블 역할을 합니다.
public class OrderDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String foodName;

    @Column
    private int quantity;

    @Column
    private int price;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    public OrderDetail(String foodName, int quantity, int price, Order order) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }



    //    @Column(nullable = false)
//    private String deliveryFee;
//
//    @Column(nullable = false)
//    private int totalPrice;

//    public Order(Restaurant restaurant, String foods, String deliveryFee, int totalPrice) {
//        this.restaurant = restaurant;
//        this.foods = foods;
//        this.deliveryFee = deliveryFee;
//        this.totalPrice = totalPrice;
//    }

}
