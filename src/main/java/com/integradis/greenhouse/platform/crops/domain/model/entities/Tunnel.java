package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class Tunnel extends AuditableModel {
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
    private float roomTemperature;
    private int freshAir;
    private int recirculation;
    private String comment;

    @Getter
    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;

    public Tunnel() {

    }

    public Tunnel(Crop crop) {
        this.crop = crop;
    }
}
