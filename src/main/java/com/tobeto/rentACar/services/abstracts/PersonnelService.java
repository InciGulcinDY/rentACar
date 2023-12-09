package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Personnel;
import com.tobeto.rentACar.services.dtos.personnel.request.AddPersonnelRequest;
import com.tobeto.rentACar.services.dtos.personnel.request.UpdatePersonnelRequest;

public interface PersonnelService {
    public void addPersonnel(AddPersonnelRequest request);
    public void updatePersonnel(int companyId, UpdatePersonnelRequest request);
    public Personnel getById(int id);
}
