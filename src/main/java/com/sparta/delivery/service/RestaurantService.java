package com.sparta.delivery.service;

import com.sparta.delivery.Dto.OrderRequestDto;
import com.sparta.delivery.Dto.RestaurantDto;
import com.sparta.delivery.domain.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getList() {
        return restaurantRepository.findAll();
    }

    public Restaurant registryRestaurant(RestaurantDto restaurantDto) {

        if(restaurantDto.getDeliveryFee() <0||
                restaurantDto.getDeliveryFee() > 10000||
                restaurantDto.getDeliveryFee() % 500 != 0||
                restaurantDto.getMinOrderPrice()<1000||
                restaurantDto.getMinOrderPrice()>100000||
                restaurantDto.getMinOrderPrice()%100!=0){
            throw new RuntimeException("");
        }

        Restaurant restaurant = new Restaurant(
                restaurantDto.getName(),
                restaurantDto.getMinOrderPrice(),
                restaurantDto.getDeliveryFee()
        );

        restaurantRepository.save(restaurant);
        return restaurantRepository.findRestaurantByName(restaurant.getName());
    }


    public Restaurant getRestaurant(OrderRequestDto orderRequestDto) {
        return restaurantRepository.findById(orderRequestDto.getRestaurantId())
                .orElseThrow(
                        () -> new NullPointerException("음식점 ID 정보 없음")
                );

    }
}
