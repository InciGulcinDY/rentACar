package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.BrandRepository;
import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brands.request.AddBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.request.DeleteBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.request.UpdateBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse;
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
        List<GetAllBrandsByCustomerResponse> customerResponses = new ArrayList<GetAllBrandsByCustomerResponse>();

        for (Brand brand: brands) {
            GetAllBrandsByCustomerResponse responseItem =new GetAllBrandsByCustomerResponse();
            responseItem.setBrandName(brand.getBrandName());
            customerResponses.add(responseItem);
        }
        return customerResponses;
    }
    @Override
    public void addBrandByEmployee(AddBrandByEmployeeRequest request) {
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
        for (Brand brand:brands) {
            if (brand.getBrandName().equals(brandName)){
                request.setId(brand.getId());
                brand.setBrandName(request.getBrandName());
                brandRepository.save(brand);
            }
        }
        //Checking the existance of the brand
        brandRepository.findById(request.getId()).orElseThrow();
    }
}
