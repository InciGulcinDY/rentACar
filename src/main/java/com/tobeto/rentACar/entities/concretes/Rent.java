package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "rents")
@Entity
public class Rent {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "deliver_date_to_customer")
    private LocalDateTime deliverDateToCustomer;
    @Column(name = "return_date")
    private LocalDateTime returnDate;
    @Column(name = "is_rented_with_childseat")
    private Boolean isRentedWithChildSeat;
    @ManyToOne
    @JoinColumn(name = "personnel_id")
    private Personnel personnel;
}
