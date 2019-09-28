package com.levi.rappimanager.domain.parent;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
abstract class LocalizedEntity {

    @Column
    private Double latitude;
    @Column
    private Double longitude;

}

