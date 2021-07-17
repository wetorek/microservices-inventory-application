package com.wetorek.cloud.inventory.inventoryservice.controller.dto;

import com.wetorek.cloud.inventory.inventoryservice.entity.Availability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityResponseDto {

    List<Availability> availabilities;

}
