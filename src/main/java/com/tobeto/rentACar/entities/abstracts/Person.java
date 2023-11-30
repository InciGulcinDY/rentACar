package com.tobeto.rentACar.entities.abstracts;

import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.entities.concretes.Personnel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "person")

public abstract class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthday")
    private LocalDateTime birthday;
    @Column(name = "international_id")
    private String internationalId;

    @Transient
    private transient Integer age = getAge(birthday);

    public  Integer getAge(LocalDateTime birthday){
        if (birthday == null){
            return null;
        }
        LocalDate currentDate = LocalDate.now();
        return Period.between(LocalDate.from(birthday), currentDate).getYears();
    }
}
