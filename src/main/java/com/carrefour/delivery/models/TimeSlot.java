package com.carrefour.delivery.models;

import com.carrefour.delivery.enums.DeliveryMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean booked;
}