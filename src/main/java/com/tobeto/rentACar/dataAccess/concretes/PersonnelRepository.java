package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
    boolean existsPersonnelByCompanyId(int companyId);
    boolean existsPersonnelByFirstName(String firstName);
    boolean existsPersonnelByLastName(String lastName);
    boolean existsPersonnelByInternationalId(String internationalId);
}
