package com.dragondesarrollo.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dragondesarrollo.restservices.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
