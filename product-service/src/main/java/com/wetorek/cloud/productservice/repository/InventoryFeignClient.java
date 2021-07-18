package com.wetorek.cloud.productservice.repository;

import com.wetorek.cloud.productservice.common.Consts;
import com.wetorek.cloud.productservice.repository.dto.AvailabilityRequestDto;
import com.wetorek.cloud.productservice.repository.dto.AvailabilityResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventory-service")
public interface InventoryFeignClient {

    @PostMapping(Consts.INVENTORY_API_GET_AVAILABILITY_BY_IDS)
    AvailabilityResponseDto getAvailabilityByListOfUniqIds(@RequestBody AvailabilityRequestDto availabilityRequestDto);

}
