package com.wetorek.cloud.productservice.repository;

import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wetorek.cloud.productservice.common.Consts;
import com.wetorek.cloud.productservice.domain.Availability;
import com.wetorek.cloud.productservice.repository.dto.AvailabilityRequestDto;
import com.wetorek.cloud.productservice.repository.dto.AvailabilityResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

//@Repository
@RequiredArgsConstructor
public class InventoryClient {
    private final RestTemplate restTemplate;

    @HystrixCommand(
            commandKey = "availability-by-ids",
            fallbackMethod = "getDefaultAvailability",
            threadPoolKey = "inventoryClientThreadPool"
    )
    public List<Availability> getAvailabilityByIds(List<String> ids) {
        var requestEntity = new AvailabilityRequestDto(ids);
        var response = restTemplate.postForEntity(
                Consts.INVENTORY_API_GET_AVAILABILITY_BY_IDS, requestEntity, AvailabilityResponseDto.class);
        return response.getBody() == null ? Lists.newArrayList() : response.getBody().getAvailabilities();
    }

    @SuppressWarnings("unused")
    List<Availability> getDefaultAvailability(List<String> ids) {
        return ids.stream().map(id -> new Availability(id, 0)).collect(Collectors.toList());
    }
}
