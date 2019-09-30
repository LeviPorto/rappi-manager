package com.levi.rappimanager.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.levi.rappimanager.crud.IdentifiedEntity;
import com.levi.rappimanager.domain.parent.GenericFood;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Promotion extends GenericFood implements Serializable, IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "promotion")
    @JsonBackReference("promotionItems")
    private List<PromotionItem> promotionItems;

    @ManyToOne(targetEntity = Restaurant.class)
    private Restaurant restaurant;

}
