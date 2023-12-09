package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.EnergyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyTypeRepository extends JpaRepository<EnergyType, Integer> {
}
