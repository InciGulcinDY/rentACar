package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.Van;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VanRepository  extends JpaRepository<Van, Integer> {

}
