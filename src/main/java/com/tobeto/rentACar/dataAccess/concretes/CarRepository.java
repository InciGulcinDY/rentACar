package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.abstracts.Vehicle;
import com.tobeto.rentACar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
