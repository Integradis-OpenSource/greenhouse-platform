package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class Bunker extends CropEntry{
    private int thermocoupleOne;
    private int thermocoupleTwo;
    private int thermocoupleThree;
    private float averageThermocouple;
    private int motorFrequency;
    private String comment;

    public Bunker() {
        this.cropPhase = CropPhase.BUNKER;
    }
    public Bunker(String author, Long nextItemId){
        super(author, nextItemId);
        this.cropPhase = CropPhase.BUNKER;
    }
}
