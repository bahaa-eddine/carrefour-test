package com.carrefour.delivery.mappers;

import com.carrefour.delivery.dtos.TimeSlotDTO;
import com.carrefour.delivery.models.TimeSlot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    TimeSlotDTO toDTO(TimeSlot timeSlot);
    TimeSlot toEntity(TimeSlotDTO timeSlotDTO);
}