package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.dataAccess.concretes.BrandRepository;
import com.tobeto.rentACar.entities.concretes.Brand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandControllers {
    private final BrandRepository brandRepository;

    public BrandControllers(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    @GetMapping
    public List<Brand> getAll(){
        return brandRepository.findAll();
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){
        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Brand brandToBeDeleted = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToBeDeleted);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Brand brand){
        Brand brandToBeUpdated = brandRepository.findById(id).orElseThrow();
        brandToBeUpdated.setBrand_Name(brand.getBrand_Name());
        brandRepository.save(brandToBeUpdated);
    }
}
