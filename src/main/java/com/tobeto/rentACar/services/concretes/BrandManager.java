package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.BrandRepository;
import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brands.request.AddBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.request.DeleteBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.request.UpdateBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse;
import com.tobeto.rentACar.services.dtos.brands.response.GetBrandByBrandNameStartingWithResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsByCustomerResponse> getAllBrandsByCustomerResponse() {
        List<Brand>  brands = brandRepository.findAll();
        List<GetAllBrandsByCustomerResponse> responses = brands.stream()
                .map(brand -> new GetAllBrandsByCustomerResponse(brand.getId(), brand.getBrandName())).toList();
        return responses;
    }

    @Override
    public List<GetBrandByBrandNameStartingWithResponse> getByName(String brandName) {
        List<Brand> brands = brandRepository.findByBrandNameStartingWith(brandName);
        List<GetBrandByBrandNameStartingWithResponse> responses = brands.stream()
                .map(brand -> new GetBrandByBrandNameStartingWithResponse(brand.getId(),brand.getBrandName())).toList();
        return responses;
    }

    @Override
    public void addBrandByEmployee(AddBrandByEmployeeRequest request) {
        //Business Rule-1:
        if(brandRepository.existsBrandByBrandName(request.getBrandName())){
            throw new RuntimeException("The same brand cannot be added twice");
        }

        // Mapping:
        Brand brand = new Brand();
        brand.setBrandName(request.getBrandName());
        brandRepository.save(brand);
    }
    @Override
    public void deleteBrandByEmployee(DeleteBrandByEmployeeRequest request) throws Exception {
       List<Brand> brands = brandRepository.findAll();
        for (Brand brand: brands) {
            if (brand.getBrandName().equals(request.getBrandName())){
                request.setId(brand.getId());
            }
        }
        //Checking the existance of the brand
        brandRepository.findById(request.getId()).orElseThrow();
        //Delete the brand:,
        brandRepository.deleteById(request.getId());
    }
    @Override
    public void updateBrandByEmployee(UpdateBrandByEmployeeRequest request, String brandName) {
        List<Brand> brands = brandRepository.findAll();

        //Business Rule-1:
        if(brandRepository.existsBrandByBrandName(request.getBrandName())){
            throw new RuntimeException("The same brand cannot be added twice");
        }
        // Mapping:
        for (Brand brand:brands) {
            if (brand.getBrandName().equals(brandName)){
                brand.setBrandName(request.getBrandName());
                brandRepository.save(brand);
            }
        }
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.findById(id).orElseThrow();
    }
}
