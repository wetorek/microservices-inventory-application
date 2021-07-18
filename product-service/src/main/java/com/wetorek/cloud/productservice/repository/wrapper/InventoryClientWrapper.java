package com.wetorek.cloud.productservice.repository.wrapper;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wetorek.cloud.productservice.domain.Availability;
import com.wetorek.cloud.productservice.repository.InventoryFeignClient;
import com.wetorek.cloud.productservice.repository.dto.AvailabilityRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InventoryClientWrapper {

    private final InventoryFeignClient inventoryFeignClient;

    @HystrixCommand(
            commandKey = "availability-by-ids",
            fallbackMethod = "getDefaultAvailability",
            threadPoolKey = "inventoryClientThreadPool"
    )
    public List<Availability> getAvailabilityByListOfUniqIds(List<String> ids) {
        var request = new AvailabilityRequestDto(ids);
        return inventoryFeignClient.getAvailabilityByListOfUniqIds(request).getAvailabilities();
    }

    @SuppressWarnings("unused")
    List<Availability> getDefaultAvailability(List<String> ids) {
        return ids.stream()
                .map(id -> new Availability(id, 0))
                .collect(Collectors.toList());
    }

}
