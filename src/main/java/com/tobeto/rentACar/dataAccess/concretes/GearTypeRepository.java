package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.GearType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearTypeRepository extends JpaRepository<GearType, Integer> {
}
