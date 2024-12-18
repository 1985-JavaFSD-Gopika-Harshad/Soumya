package com.online.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.store.model.Cart;
import com.online.store.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart findByUser(User user);
}
