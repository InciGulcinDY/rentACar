package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.dataAccess.concretes.VanRepository;
import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.entities.concretes.Van;
import com.tobeto.rentACar.services.abstracts.VanService;
import com.tobeto.rentACar.services.dtos.customers.response.GetAllCustomerResponse;
import com.tobeto.rentACar.services.dtos.vans.requests.AddVanRequest;
import com.tobeto.rentACar.services.dtos.vans.requests.DeleteVanRequest;
import com.tobeto.rentACar.services.dtos.vans.requests.UpdateVanRequest;
import com.tobeto.rentACar.services.dtos.vans.responses.GetAllVanResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vans")
public class VanControllers {
    private VanService vanService;

    public VanControllers(VanService vanService) {
        this.vanService = vanService;
    }

    @GetMapping("/getall")
    public List<GetAllVanResponse> getAll(){
        return vanService.getAllVans();
    }

    @GetMapping("getbyplatenumber")
    public List<Van> getCarByPlateNumber(@RequestParam String plateNumber){
        return vanService.getVanByPlateNumber(plateNumber);
    }
    @PostMapping("addvan")
    public void add(@RequestBody AddVanRequest request){
        vanService.addVan(request);
    }

    @DeleteMapping("delete/{plateNumber}")
    public void delete(@RequestBody DeleteVanRequest request){
        vanService.deleteVan(request);
    }

    @PutMapping("update/{plateNumber}")
    public void update(@PathVariable String plateNumber, @RequestBody UpdateVanRequest request){
        vanService.updateVan(plateNumber, request);
    }
}

