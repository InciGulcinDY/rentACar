package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.entities.concretes.Motorcycle;
import com.tobeto.rentACar.services.abstracts.MotorcycleService;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsWithGearTypesResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.request.AddMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.request.DeleteMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.request.UpdateMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleWithGearTypesResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetMotorcycleByPlateNumberStartingWithResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/motorcycles")
public class MotorcycleControllers {
    private MotorcycleService motorcycleService;

    public MotorcycleControllers(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @GetMapping
    public List<GetAllMotorcycleResponse> getAll(){
        return motorcycleService.getAllMotorcycles();
    }

    @GetMapping("plateNumber")
    public List<GetMotorcycleByPlateNumberStartingWithResponse> getMotorcycleByPlateNumber(@RequestParam String plateNumber){
        return motorcycleService.findByPlateNumberStartingWith(plateNumber);
    }

    @GetMapping("getallwithgeartypes")
    public List<GetAllMotorcycleWithGearTypesResponse> getAllCarsWithGearTypesResponses(){
        return motorcycleService.getAllMotorcycleWithGearTypes();
    }

    @PostMapping
    public void add(@RequestBody @Valid AddMotorcycleRequest request){
        motorcycleService.addMotorcycle(request);
    }

    @DeleteMapping("{plateNumber}")
    public void delete(@RequestBody DeleteMotorcycleRequest request){
       motorcycleService.deleteMotorcycle(request);
    }

    @PutMapping("{plateNumber}")
    public void update(@PathVariable String plateNumber, @RequestBody @Valid UpdateMotorcycleRequest request){
       motorcycleService.updateMotocycle(plateNumber, request);
    }


}
