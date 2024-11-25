package com.fruit.seller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fruit.seller.model.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {

}
