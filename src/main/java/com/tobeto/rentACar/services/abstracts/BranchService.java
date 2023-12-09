package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Branch;
import com.tobeto.rentACar.services.dtos.branches.request.AddBranchRequest;
import com.tobeto.rentACar.services.dtos.branches.request.UpdateBranchRequest;

public interface BranchService {
    Branch getById(int id);
    public  void addBranch(AddBranchRequest request);
    public void updateBranch(String branchName, UpdateBranchRequest request);

}
