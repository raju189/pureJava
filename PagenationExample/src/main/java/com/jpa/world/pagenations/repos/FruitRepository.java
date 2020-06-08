package com.jpa.world.pagenations.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.world.pagenations.entities.Fruit;
@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

	
	public List<Fruit> findByPrice(double price, Pageable p);
}
