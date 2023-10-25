package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class Formula extends CropEntry {

    private int hay;
    private int corn;
    private int guano;
    private float cottonSeedCake;
    private int soybeanMeal;
    private float gypsum;
    private int urea;
    private int ammoniumSulphate;

    public Formula(){
        this.cropPhase = CropPhase.FORMULA;
    }

    public Formula(String author, Long nextItemId){
        super(author, nextItemId);
        this.cropPhase = CropPhase.FORMULA;
    }
}
