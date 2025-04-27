package org.ms.lab9.service;


import org.ms.lab9.model.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getBillsByPatientId(Integer patientId);
}

