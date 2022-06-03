package com.sparta.delivery.controller;

import com.sparta.delivery.Dto.FoodDto;
import com.sparta.delivery.mapping.MenuMapping;
import com.sparta.delivery.model.Menu;
import com.sparta.delivery.service.MenuService;
import com.sparta.delivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
public class MenuController {
    private final MenuService menuService;
    private final RestaurantService restaurantService;

    @Autowired
    public MenuController(MenuService menuService, RestaurantService restaurantService) {
        this.menuService = menuService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<MenuMapping> getFoods(@PathVariable Long restaurantId){
        return menuService.getFoodsList(restaurantId);
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registryFoods(@PathVariable Long restaurantId, @RequestBody List<FoodDto> requestFoodsDtoList){
        menuService.registryFoods(restaurantId, requestFoodsDtoList);
    }
}