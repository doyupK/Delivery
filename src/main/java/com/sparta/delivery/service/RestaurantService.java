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

    public void registryRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant(
                restaurantDto.getDeliveryFee(),
                restaurantDto.getMinOrderPrice(),
                restaurantDto.getName()

        );
        restaurantRepository.save(restaurant);
    }


    public Restaurant getRestaurant(OrderRequestDto orderRequestDto) {
        return restaurantRepository.findById(orderRequestDto.getRestaurantId())
                .orElseThrow(
                        () -> new NullPointerException("음식점 ID 정보 없음")
                );

    }
}
