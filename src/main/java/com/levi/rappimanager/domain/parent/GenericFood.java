package com.levi.rappimanager.domain.parent;

import com.levi.rappimanager.domain.enumeration.FoodCategory;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class GenericFood {

    @Column
    private Boolean spotLight;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Double price;

    @Column
    private FoodCategory category;

}
