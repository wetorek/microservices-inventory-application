package com.wetorek.cloud.inventory.inventoryservice.controller;

import com.wetorek.cloud.inventory.inventoryservice.controller.dto.AvailabilityRequestDto;
import com.wetorek.cloud.inventory.inventoryservice.controller.dto.AvailabilityResponseDto;
import com.wetorek.cloud.inventory.inventoryservice.service.AvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/availability")
@RequiredArgsConstructor
public class AvailabilityController {
    private final AvailabilityService availabilityService;

    @PostMapping("/getAvailabilityByListOfUniqIds")
    public AvailabilityResponseDto getAvailabilityByListOfUniqIds(@RequestBody AvailabilityRequestDto availabilityRequestDto) {
        var availabilities = availabilityService.getAvailabilityByListOfUniqIds(availabilityRequestDto.getIds());
        return new AvailabilityResponseDto(availabilities);
    }
}
