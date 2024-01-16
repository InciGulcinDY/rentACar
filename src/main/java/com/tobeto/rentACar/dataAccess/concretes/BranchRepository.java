package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.Branch;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Integer> {


}
