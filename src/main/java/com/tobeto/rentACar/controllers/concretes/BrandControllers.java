package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brands.request.AddBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.request.DeleteBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.request.UpdateBrandByEmployeeRequest;
import com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse;
import com.tobeto.rentACar.services.dtos.brands.response.GetBrandByBrandNameStartingWithResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandControllers {
    private BrandService brandService;
    public BrandControllers(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("getall")
    public List<GetAllBrandsByCustomerResponse> getAllBrandsCustomerResponse(){
        return brandService.getAllBrandsByCustomerResponse();
    }
    @GetMapping()
    public List<GetBrandByBrandNameStartingWithResponse> getByName(@RequestParam String brandName){
        return brandService.getByName(brandName);
    }
    @PostMapping
    public void add(@RequestBody @Valid AddBrandByEmployeeRequest request){
        brandService.addBrandByEmployee(request);
    }
    @DeleteMapping
    public void delete(@RequestBody DeleteBrandByEmployeeRequest request) throws Exception {
        brandService.deleteBrandByEmployee(request);
    }
    @PutMapping("{brandName}")
    public void update(@RequestBody @Valid UpdateBrandByEmployeeRequest request, @RequestParam String brandName){
        brandService.updateBrandByEmployee(request, brandName);
    }
}
