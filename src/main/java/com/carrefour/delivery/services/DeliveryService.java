package com.carrefour.delivery.services;

import com.carrefour.delivery.dtos.TimeSlotDTO;
import com.carrefour.delivery.enums.DeliveryMethod;

import java.util.List;

public interface DeliveryService {
    List<DeliveryMethod> getDeliveryMethods();
    List<TimeSlotDTO> getAvailableTimeSlots(DeliveryMethod deliveryMethod);
    TimeSlotDTO bookTimeSlot(Long timeSlotId);
    TimeSlotDTO cancelBooking(Long bookingId);

    List<TimeSlotDTO> getAllAvailableTimeSlots();
}
