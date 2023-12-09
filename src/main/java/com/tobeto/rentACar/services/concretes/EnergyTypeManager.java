package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.EnergyTypeRepository;
import com.tobeto.rentACar.entities.concretes.EnergyType;
import com.tobeto.rentACar.services.abstracts.EnergyTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnergyTypeManager implements EnergyTypeService {
    private EnergyTypeRepository energyTypeRepository;
    @Override
    public EnergyType getById(int id) {
        return energyTypeRepository.findById(id).orElseThrow();
    }
}
