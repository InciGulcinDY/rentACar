package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CityRepository;
import com.tobeto.rentACar.entities.concretes.City;
import com.tobeto.rentACar.services.abstracts.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityManager implements CityService{
    private final CityRepository cityRepository;
    @Override
    public City getById(int id) {
        return cityRepository.findById(id).orElseThrow();
    }
}
