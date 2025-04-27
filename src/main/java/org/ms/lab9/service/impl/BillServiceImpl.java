package org.ms.lab9.service.impl;

import lombok.RequiredArgsConstructor;
import org.ms.lab9.model.Bill;
import org.ms.lab9.model.Patient;
import org.ms.lab9.repository.BillRepository;
import org.ms.lab9.repository.PatientRepository;
import org.ms.lab9.service.BillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final PatientRepository patientRepository;

    @Override
    public List<Bill> getBillsByPatientId(Integer patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return billRepository.findByPatient(patient);
    }
}


