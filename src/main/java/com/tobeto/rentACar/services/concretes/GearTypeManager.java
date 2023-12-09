package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.GearTypeRepository;
import com.tobeto.rentACar.entities.concretes.GearType;
import com.tobeto.rentACar.services.abstracts.GearTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GearTypeManager implements GearTypeService {
    private GearTypeRepository gearTypeRepository;

    @Override
    public GearType getById(int id) {
        return gearTypeRepository.findById(id).orElseThrow();
    }
}
