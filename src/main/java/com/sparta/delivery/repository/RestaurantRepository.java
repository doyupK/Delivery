package com.sparta.delivery.repository;

import com.sparta.delivery.model.Menu;
import com.sparta.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findAll();
//    List<Menu> findbyId
}
