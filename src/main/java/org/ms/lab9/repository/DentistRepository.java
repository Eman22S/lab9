package org.ms.lab9.repository;

import org.ms.lab9.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {

}
