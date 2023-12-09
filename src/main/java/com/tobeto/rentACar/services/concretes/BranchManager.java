package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.BranchRepository;
import com.tobeto.rentACar.dataAccess.concretes.CityRepository;
import com.tobeto.rentACar.entities.concretes.Branch;
import com.tobeto.rentACar.entities.concretes.City;
import com.tobeto.rentACar.services.abstracts.BranchService;
import com.tobeto.rentACar.services.abstracts.CityService;
import com.tobeto.rentACar.services.dtos.branches.request.AddBranchRequest;
import com.tobeto.rentACar.services.dtos.branches.request.UpdateBranchRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchManager implements BranchService {
    private BranchRepository branchRepository;
    private CityService cityService;

    @Override
    public Branch getById(int id) {
        return branchRepository.findById(id).orElseThrow();
    }

    @Override
    public void addBranch(AddBranchRequest request) {

        //Mapping:
        Branch branch = new Branch();
        branch.setBranchName(request.getBranchName());
        City city = cityService.getById(request.getCityId());
        branch.setCity(city);
        branchRepository.save(branch);

    }

    @Override
    public void updateBranch(String branchName, UpdateBranchRequest request) {
        List<Branch> branches = branchRepository.findAll();
        for (Branch branch:branches) {
            branch.setBranchName(request.getBranchName());
            City city = cityService.getById(request.getCityId());
            branch.setCity(city);
            branchRepository.save(branch);
        }

    }
}
