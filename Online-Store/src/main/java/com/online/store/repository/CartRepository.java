package com.online.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.store.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
