package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.ModelRepository;
import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.entities.concretes.Model;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.abstracts.ModelService;
import com.tobeto.rentACar.services.dtos.models.request.AddModelRequest;
import com.tobeto.rentACar.services.dtos.models.request.UpdateModelRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private final BrandService brandService;
    @Override
    public Model getById(int id) {
        return modelRepository.findById(id).orElseThrow();
    }

    @Override
    public void addModel(AddModelRequest request) {
        //Business Rule-1:
        if (modelRepository.existsModelByModelName(request.getModelName())){
            throw new RuntimeException("A second model with the same name!");
        }

        // Mapping:
        Model model = new Model();
        model.setModelName(request.getModelName());
        Brand brand = brandService.getById(request.getBrandId());
        model.setBrand(brand);
        modelRepository.save(model);
    }

    @Override
    public void updateModel(String modelName, UpdateModelRequest request) {
        List<Model> models = modelRepository.findAll();
        //Business Rule-1:
        if(modelRepository.existsModelByModelName(request.getModelName())){
            throw new RuntimeException("A second model with the same name!");
        }

        for (Model model:models) {
            if (model.getModelName().equals(modelName)){
                model.setModelName(request.getModelName());
                Brand brand = brandService.getById(request.getBrandId());
                model.setBrand(brand);
                modelRepository.save(model);
            }
        }
    }
}
