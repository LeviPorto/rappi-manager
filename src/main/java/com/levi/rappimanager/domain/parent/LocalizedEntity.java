package com.levi.rappimanager.domain.parent;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
abstract class LocalizedEntity implements Serializable {

    @Column
    private Double latitude;
    @Column
    private Double longitude;

}

