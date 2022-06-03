package com.sparta.delivery.repository;

import com.sparta.delivery.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface menuRepository extends JpaRepository<Menu, Long> {
}
