package com.wetorek.cloud.productservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Availability {

    private String uniq_id;
    private Integer amount;

}
