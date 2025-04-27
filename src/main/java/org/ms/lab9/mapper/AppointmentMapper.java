package org.ms.lab9.mapper;

import org.ms.lab9.dto.requestDto.AppointmentRequestDto;
import org.ms.lab9.dto.responseDto.AppointmentResponseDto;
import org.ms.lab9.model.Appointment;
import org.ms.lab9.model.Dentist;
import org.ms.lab9.model.Patient;
import org.ms.lab9.model.Surgery;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public Appointment toEntity(AppointmentRequestDto dto, Dentist d, Patient p, Surgery s) {
        Appointment a = new Appointment();
        a.setDentist(d);
        a.setPatient(p);
        a.setSurgery(s);
        a.setAppointmentDate(dto.getAppointmentDate());
        a.setAppointmentTime(dto.getAppointmentTime());
        a.setStatus(dto.getStatus());
        return a;
    }

    public AppointmentResponseDto toDto(Appointment a) {
        AppointmentResponseDto dto = new AppointmentResponseDto();
        dto.setDentistName(a.getDentist().getFirstName() + " " + a.getDentist().getLastName());
        dto.setPatientNo(a.getPatient().getPatientNo());
        dto.setPatientName(a.getPatient().getFirstName() + " " + a.getPatient().getLastName());
        dto.setAppointmentDate(a.getAppointmentDate());
        dto.setAppointmentTime(a.getAppointmentTime());
        dto.setSurgeryNo(a.getSurgery().getSurgeryNo());
        return dto;
    }
}