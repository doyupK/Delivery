package com.sparta.delivery.repository;

import com.sparta.delivery.mapping.MenuMapping;
import com.sparta.delivery.model.Menu;
import com.sparta.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {


    List<MenuMapping> findMenusByRestaurant(Restaurant restaurant);
}
