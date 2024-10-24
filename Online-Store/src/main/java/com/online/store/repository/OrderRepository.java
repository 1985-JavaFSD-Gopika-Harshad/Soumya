package com.online.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.store.model.Order;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long>{
 // List<Order> findByUserId(Long user_id);
}
