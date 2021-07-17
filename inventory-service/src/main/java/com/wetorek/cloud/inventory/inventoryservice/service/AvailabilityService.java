package com.wetorek.cloud.inventory.inventoryservice.service;

import com.wetorek.cloud.inventory.inventoryservice.entity.Availability;
import com.wetorek.cloud.inventory.inventoryservice.repository.AvailabilityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AvailabilityService {

    private final AvailabilityRepository availabilityRepository;

    public List<Availability> getAvailabilityByListOfUniqIds(List<String> uniqIds) {
        log.info("Getting availability for ids: {}", uniqIds);
        return availabilityRepository.getAvailabilityByListOfUniqIds(uniqIds);
    }
}
