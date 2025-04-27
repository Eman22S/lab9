package org.ms.lab9.repository;


import org.ms.lab9.model.Bill;
import org.ms.lab9.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    List<Bill> findByPatient(Patient patient);

}
