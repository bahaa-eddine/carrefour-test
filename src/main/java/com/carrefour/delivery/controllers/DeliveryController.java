package com.carrefour.delivery.controllers;

import com.carrefour.delivery.dtos.BookingRequestDTO;
import com.carrefour.delivery.dtos.TimeSlotDTO;
import com.carrefour.delivery.enums.DeliveryMethod;
import com.carrefour.delivery.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/time-slots")
    public List<TimeSlotDTO> getAvailableTimeSlots(@RequestParam(required = false) DeliveryMethod deliveryMethod) {
        if (deliveryMethod == null) {
            return deliveryService.getAllAvailableTimeSlots();
        } else {
            return deliveryService.getAvailableTimeSlots(deliveryMethod);
        }    }

    @PostMapping("/time-slots/book")
    public TimeSlotDTO bookTimeSlot(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return deliveryService.bookTimeSlot(bookingRequestDTO.getTimeSlotId());
    }

    @GetMapping("/methods")
    public List<DeliveryMethod> getDeliveryMethods() {
        return deliveryService.getDeliveryMethods();
    }

    @DeleteMapping("/time-slots/cancel")
    public TimeSlotDTO cancelBooking(@RequestParam Long bookingId) {
        return deliveryService.cancelBooking(bookingId);
    }
}