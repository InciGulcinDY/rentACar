package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.RentRepository;
import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.entities.concretes.Personnel;
import com.tobeto.rentACar.entities.concretes.Rent;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.abstracts.PersonnelService;
import com.tobeto.rentACar.services.abstracts.RentService;
import com.tobeto.rentACar.services.dtos.rents.request.AddRentRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentManager implements RentService {
    private final RentRepository rentRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final PersonnelService personnelService;
    @Override
    public void addRentRequest(AddRentRequest request) {
        //Business Rule-1:


        // Mapping:
        Rent rent = new Rent();
        Car car = carService.getById(request.getVehicleId());
        rent.setVehicle(car);
        Customer customer = customerService.getById(request.getCustomerId());
        rent.setCustomer(customer);
        rent.setDeliverDateToCustomer(request.getDeliverDateToCustomer());
        rent.setReturnDate(request.getReturnDate());
        rent.setIsRentedWithChildSeat(request.getIsRentedWithChildSeat());
        Personnel personnel = personnelService.getById(request.getPersonnelId());
        rent.setPersonnel(personnel);
        rentRepository.save(rent);


    }
}
