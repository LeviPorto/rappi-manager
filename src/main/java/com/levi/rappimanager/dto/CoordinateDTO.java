package com.levi.rappimanager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class CoordinateDTO {

    private Double latitude;
    private Double longitude;
    private Integer deliveryManId;

}
