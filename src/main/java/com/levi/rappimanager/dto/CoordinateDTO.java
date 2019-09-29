package com.levi.rappimanager.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class CoordinateDTO {

    private Double latitude;
    private Double longitude;
    private Instant date;
    private Integer deliveryManId;

}
