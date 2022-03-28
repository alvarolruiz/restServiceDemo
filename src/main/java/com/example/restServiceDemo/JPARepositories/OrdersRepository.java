package com.example.restServiceDemo.JPARepositories;

import com.example.restServiceDemo.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Long> {
}
