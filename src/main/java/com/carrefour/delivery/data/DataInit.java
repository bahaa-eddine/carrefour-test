package com.carrefour.delivery.data;

import com.carrefour.delivery.models.TimeSlot;
import com.carrefour.delivery.repositories.TimeSlotRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@Profile("dev")
public class DataInit implements CommandLineRunner {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Override
    public void run(String... args) throws Exception {
        // Read JSON file and convert to list of TimeSlot objects
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        InputStream inputStream = new ClassPathResource("data-init.json").getInputStream();
        List<TimeSlot> timeSlots = objectMapper.readValue(inputStream, new TypeReference<List<TimeSlot>>() {});

        // Save time slots to repository
        timeSlotRepository.saveAll(timeSlots);
    }
}