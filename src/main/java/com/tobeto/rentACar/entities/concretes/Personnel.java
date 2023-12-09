package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "personnel")
@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class Personnel extends Person{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_id")
    private int companyId;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    @OneToMany(mappedBy = "personnel")
    private List<Rent> rents;
}
