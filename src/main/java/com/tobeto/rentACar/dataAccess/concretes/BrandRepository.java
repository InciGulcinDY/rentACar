package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    List<Brand> findByBrandNameStartingWith(String brandName); // Derived Query Methods
}
