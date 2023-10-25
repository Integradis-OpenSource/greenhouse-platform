package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class Bunker {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int day;
    private Date date;
    private Date time;
    private int thermocoupleOne;
    private int thermocoupleTwo;
    private int thermocoupleThree;
    private float averageThermocouple;
    private int motorFrequency;
    private String comment;

    @Getter
    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;

    public Bunker() {

    }
    public Bunker(Crop crop){
        this.crop = crop;
    }
}
