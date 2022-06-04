package com.sparta.delivery.repository;

import com.sparta.delivery.mapping.MenuMapping;
import com.sparta.delivery.domain.Food;
import com.sparta.delivery.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Food, Long> {


    List<MenuMapping> findMenusByRestaurant(Restaurant restaurant);

}
