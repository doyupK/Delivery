package com.sparta.delivery.service;

import com.sparta.delivery.Dto.FoodDto;
import com.sparta.delivery.mapping.MenuMapping;
import com.sparta.delivery.domain.Food;
import com.sparta.delivery.domain.Restaurant;
import com.sparta.delivery.repository.MenuRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public void registryFoods(Long restaurantId, List<FoodDto> requestFoodsDtoList) {
        Optional<Restaurant> findRestaurant = restaurantRepository.findById(restaurantId);
        if(!findRestaurant.isPresent()) {
            throw new NullPointerException("음식점 없음");
        }
        Restaurant restaurant = findRestaurant.get();

        for(FoodDto food : requestFoodsDtoList){
            if (    food.getPrice() <100        ||
                    food.getPrice() >1000000    ||
                    food.getPrice()  % 100 != 0 ){
                throw new IllegalArgumentException("음식 가격이 안맞음");
            }

            Food menu = new Food(food.getName(), food.getPrice(), restaurant);

            menuRepository.save(menu);
        }
    }

    public List<MenuMapping> getFoodsList(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("식당없음"));
        return menuRepository.findMenusByRestaurant(restaurant);
    }


}
