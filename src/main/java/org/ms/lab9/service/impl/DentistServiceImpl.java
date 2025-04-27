package org.ms.lab9.service.impl;

import lombok.RequiredArgsConstructor;
import org.ms.lab9.dto.requestDto.DentistRequestDto;
import org.ms.lab9.dto.responseDto.DentistResponseDto;
import org.ms.lab9.exception.ResourceNotFoundException;
import org.ms.lab9.mapper.DentistMapper;
import org.ms.lab9.model.Dentist;
import org.ms.lab9.repository.DentistRepository;
import org.ms.lab9.service.DentistService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DentistServiceImpl implements DentistService {

    private final DentistRepository repository;
    private final DentistMapper mapper;

    @Override
    public DentistResponseDto create(DentistRequestDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public List<DentistResponseDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
    @Override
    public Page<DentistResponseDto> getAllDentists(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDto);
    }

    @Override
    public DentistResponseDto getById(Integer id) {
        Dentist dentist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dentist not found with id: " + id));
        return mapper.toDto(dentist);
    }

    @Override
    public void delete(Integer id) {
        Dentist dentist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dentist not found with id: " + id));
        repository.delete(dentist);
    }
}
