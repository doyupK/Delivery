package com.sparta.delivery.service;

import com.sparta.delivery.Dto.RestaurantDto;
import com.sparta.delivery.model.Menu;
import com.sparta.delivery.model.Restaurant;
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
                restaurantDto.getName(),
                restaurantDto.getMinOrderPrice(),
                restaurantDto.getDeliveryFee()

        );
        restaurantRepository.save(restaurant);
    }






}
