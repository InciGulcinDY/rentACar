package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.ColorRepository;
import com.tobeto.rentACar.entities.concretes.Color;
import com.tobeto.rentACar.services.abstracts.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private ColorRepository colorRepository;

    @Override
    public Color getById(int id) {
        return colorRepository.findById(id).orElseThrow();
    }
}
