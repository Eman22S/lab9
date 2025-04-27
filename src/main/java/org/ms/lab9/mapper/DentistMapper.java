package org.ms.lab9.mapper;

import org.ms.lab9.dto.requestDto.DentistRequestDto;
import org.ms.lab9.dto.responseDto.DentistResponseDto;
import org.ms.lab9.model.Dentist;
import org.springframework.stereotype.Component;

@Component
public class DentistMapper {

    public Dentist toEntity(DentistRequestDto dto) {
        return new Dentist(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getSpecialization()
        );
    }

    public DentistResponseDto toDto(Dentist dentist) {
        DentistResponseDto dto = new DentistResponseDto();
        dto.setFirstName(dentist.getFirstName());
        dto.setLastName(dentist.getLastName());
        dto.setId(dentist.getId());
        dto.setSpecialization(dentist.getSpecialization());
        return dto;
    }
}
