package org.ms.lab9.service.impl;


import lombok.RequiredArgsConstructor;
import org.ms.lab9.dto.requestDto.AppointmentRequestDto;
import org.ms.lab9.dto.responseDto.AppointmentResponseDto;
import org.ms.lab9.exception.ResourceNotFoundException;
import org.ms.lab9.mapper.AppointmentMapper;
import org.ms.lab9.model.Appointment;
import org.ms.lab9.model.Dentist;
import org.ms.lab9.model.Patient;
import org.ms.lab9.model.Surgery;
import org.ms.lab9.repository.AppointmentRepository;
import org.ms.lab9.repository.DentistRepository;
import org.ms.lab9.repository.PatientRepository;
import org.ms.lab9.repository.SurgeryRepository;
import org.ms.lab9.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repo;
    private final DentistRepository dentistRepo;
    private final PatientRepository patientRepo;
    private final SurgeryRepository surgeryRepo;
    private final AppointmentMapper mapper;

    @Override
    public AppointmentResponseDto create(AppointmentRequestDto dto) {
        Dentist d = dentistRepo.findById(dto.getDentistId()).orElseThrow(() -> new ResourceNotFoundException("Dentist not found"));
        Patient p = patientRepo.findById(dto.getPatientId()).orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        Surgery s = surgeryRepo.findById(dto.getSurgeryId()).orElseThrow(() -> new ResourceNotFoundException("Surgery not found"));
        Appointment a = mapper.toEntity(dto, d, p, s);
        return mapper.toDto(repo.save(a));
    }
    @Override
    public Page<AppointmentResponseDto> getAllAppointments(Pageable pageable) {
        return repo.findAll(pageable)
                .map(mapper::toDto);
    }
    @Override
    public List<AppointmentResponseDto> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }




}