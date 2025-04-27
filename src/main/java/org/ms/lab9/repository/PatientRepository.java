package org.ms.lab9.repository;

import org.ms.lab9.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByLastNameContainingIgnoreCase(String searchString);

}
