package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class Formula {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int day;
    private Date date;
    private Date time;
    private int hay;
    private int corn;
    private int guano;
    private float cottonSeedCake;
    private int soybeanMeal;
    private float gypsum;
    private int urea;
    private int ammoniumSulphate;

    @Getter
    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;

    public Formula(Crop crop){
        this.crop = crop;
    }

    public Formula(){

    }
}
