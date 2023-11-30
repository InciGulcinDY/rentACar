package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.services.dtos.brands.request.AddBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.request.DeleteBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.request.UpdateBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse;

import java.util.List;

public interface BrandService {
    public List<GetAllBrandsByCustomerResponse> getAllBrandsByCustomerResponse();
    public List<Brand> getByName(String brandName);
    public void addBrandByEmployee(AddBrandByEmployeeRequest request);
    public void deleteBrandByEmployee(DeleteBrandByEmployeeRequest request) throws Exception;
    public void updateBrandByEmployee(UpdateBrandByEmployeeRequest request, String brandName);


}
