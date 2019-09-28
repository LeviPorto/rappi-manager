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
public class Food extends GenericFood implements Serializable, IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private ComboItem comboItem;

    @OneToOne
    private PromotionItem promotionItem;

    @OneToMany(mappedBy = "food")
    @JsonBackReference("genericFoodTags")
    private List<GenericFoodTag> genericFoodTags;

    @ManyToOne(targetEntity = Restaurant.class)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

}
