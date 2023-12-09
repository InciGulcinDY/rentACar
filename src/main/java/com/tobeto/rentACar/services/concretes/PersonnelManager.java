package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.PersonnelRepository;
import com.tobeto.rentACar.entities.concretes.Branch;
import com.tobeto.rentACar.entities.concretes.Personnel;
import com.tobeto.rentACar.services.abstracts.BranchService;
import com.tobeto.rentACar.services.abstracts.PersonnelService;
import com.tobeto.rentACar.services.dtos.personnel.request.AddPersonnelRequest;
import com.tobeto.rentACar.services.dtos.personnel.request.UpdatePersonnelRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonnelManager implements PersonnelService {
    private final PersonnelRepository personnelRepository;
    private final BranchService branchService;
    @Override
    public void addPersonnel(AddPersonnelRequest request) {
        //Business Rule-1:
        if(personnelRepository.existsPersonnelByCompanyId(request.getCompanyId())){
            throw new RuntimeException("The same company ID cannot be registered twice!");
        }
        //Business Rule-2:
        if((Year.now().getValue() - request.getBirthday().getYear()) < 18){
            throw new RuntimeException("There can be no employees under the age of 18!");
        }
        //Business Rule-3:
        if(personnelRepository.existsPersonnelByInternationalId(request.getInternationalId())){
            throw new RuntimeException("The same International ID cannot be added twice!");
        }

        // Mapping:
        Personnel personnel = new Personnel();
        personnel.setFirstName(request.getFirstName());
        personnel.setLastName(request.getLastName());
        personnel.setBirthday(request.getBirthday());
        personnel.setInternationalId(request.getInternationalId());
        personnel.setCompanyId(request.getCompanyId());
        Branch branch = branchService.getById(request.getBranchId());
        personnel.setBranch(branch);
        personnelRepository.save(personnel);
    }

    @Override
    public void updatePersonnel(int companyId, UpdatePersonnelRequest request) {
        List<Personnel> personnels = personnelRepository.findAll();
        //Business Rule-1:
        if(personnelRepository.existsPersonnelByCompanyId(request.getCompanyId())){
            throw new RuntimeException("The same company ID cannot be registered twice!");
        }
        //Business Rule-2:
        if((Year.now().getValue() - request.getBirthday().getYear()) < 18){
            throw new RuntimeException("There can be no employees under the age of 18!");
        }
        //Business Rule-3:
        if(personnelRepository.existsPersonnelByInternationalId(request.getInternationalId())){
            throw new RuntimeException("The same International ID cannot be added twice!");
        }
        for (Personnel personnel:personnels) {
            if(personnel.getCompanyId() == companyId){
                personnel.setFirstName(request.getFirstName());
                personnel.setLastName(request.getLastName());
                personnel.setBirthday(request.getBirthday());
                personnel.setInternationalId(request.getInternationalId());
                Branch branch = branchService.getById(request.getBranchId());
                personnel.setBranch(branch);
                personnelRepository.save(personnel);
            }
        }

    }

    @Override
    public Personnel getById(int id) {
        return personnelRepository.findById(id).orElseThrow();
    }
}
