package com.carrefour.delivery.exceptions;

public class TimeSlotNotBookedException extends RuntimeException {
    public TimeSlotNotBookedException(String message) {
        super(message);
    }
}