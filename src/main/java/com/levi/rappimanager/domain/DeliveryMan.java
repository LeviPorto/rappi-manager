package com.levi.rappimanager.domain;

import com.levi.rappimanager.crud.IdentifiedEntity;
import com.levi.rappimanager.domain.enumeration.Occupation;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "delivery_man", indexes = {@Index(name = "occupation_index", columnList="occupation")})
public class DeliveryMan implements Serializable, IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;

    @ManyToOne(targetEntity = Restaurant.class)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column
    private Occupation occupation;

    @Column
    private String phoneIMEI;

}
