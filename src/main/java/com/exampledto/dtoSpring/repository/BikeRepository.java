package com.exampledto.dtoSpring.repository;

import com.exampledto.dtoSpring.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<Bike,Integer> {
}
