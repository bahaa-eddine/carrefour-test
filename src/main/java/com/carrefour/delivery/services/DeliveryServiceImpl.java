package com.carrefour.delivery.services;


import com.carrefour.delivery.dtos.TimeSlotDTO;
import com.carrefour.delivery.enums.DeliveryMethod;
import com.carrefour.delivery.exceptions.TimeSlotAlreadyBookedException;
import com.carrefour.delivery.exceptions.TimeSlotNotBookedException;
import com.carrefour.delivery.exceptions.TimeSlotNotFoundException;
import com.carrefour.delivery.mappers.TimeSlotMapper;
import com.carrefour.delivery.models.TimeSlot;
import com.carrefour.delivery.repositories.DeliveryRepository;
import com.carrefour.delivery.repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private TimeSlotMapper timeSlotMapper;

    public List<TimeSlotDTO> getAvailableTimeSlots(DeliveryMethod deliveryMethod) {
        return timeSlotRepository.findByDeliveryMethodAndBookedFalse(deliveryMethod)
                .stream()
                .map(timeSlotMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TimeSlotDTO bookTimeSlot(Long timeSlotId) {
        TimeSlot timeSlot = timeSlotRepository.findById(timeSlotId)
                .orElseThrow(() -> new TimeSlotNotFoundException("Time slot not found"));
        if (timeSlot.isBooked()) {
            throw new TimeSlotAlreadyBookedException("Time slot already booked");
        }
        timeSlot.setBooked(true);
        TimeSlot bookedTimeSlot = timeSlotRepository.save(timeSlot);
        return timeSlotMapper.toDTO(bookedTimeSlot);
    }

    public List<DeliveryMethod> getDeliveryMethods() {
        return Arrays.asList(DeliveryMethod.values());
    }

    public TimeSlotDTO cancelBooking(Long bookingId) {
        TimeSlot timeSlot = deliveryRepository.findById(bookingId)
                .orElseThrow(() -> new TimeSlotNotFoundException("Booking not found"));

        if (!timeSlot.isBooked()) {
            throw new TimeSlotNotBookedException("Time slot is not booked");
        }

        timeSlot.setBooked(false);
        return timeSlotMapper.toDTO(deliveryRepository.save(timeSlot));
    }

    @Override
    public List<TimeSlotDTO> getAllAvailableTimeSlots() {
        List<TimeSlot> timeSlots = timeSlotRepository.findByBookedFalse();
        return timeSlots.stream().map(timeSlotMapper::toDTO).collect(Collectors.toList());
    }
}