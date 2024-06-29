package com.carrefour.delivery.repositories;

import com.carrefour.delivery.enums.DeliveryMethod;
import com.carrefour.delivery.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByDeliveryMethodAndBookedFalse(DeliveryMethod deliveryMethod);
    List<TimeSlot> findByBookedFalse();
}