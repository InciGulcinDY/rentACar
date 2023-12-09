package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Model;
import com.tobeto.rentACar.services.dtos.models.request.AddModelRequest;
import com.tobeto.rentACar.services.dtos.models.request.UpdateModelRequest;

public interface ModelService {
    public Model getById(int id);
    public void addModel(AddModelRequest request);
    public void updateModel(String modelName, UpdateModelRequest request);
}
