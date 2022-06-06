package com.sparta.delivery.controller;

import com.sparta.delivery.Dto.RestaurantDto;
import com.sparta.delivery.domain.Restaurant;
import com.sparta.delivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //    음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant registryRestaurant(@RequestBody RestaurantDto restaurantDto){
        return restaurantService.registryRestaurant(restaurantDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurantList(){
        return restaurantService.getList();
    }
}
