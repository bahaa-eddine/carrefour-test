package com.carrefour.delivery.dtos;

import com.carrefour.delivery.enums.DeliveryMethod;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeSlotDTO {
    private Long id;
    private DeliveryMethod deliveryMethod;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean booked;
}