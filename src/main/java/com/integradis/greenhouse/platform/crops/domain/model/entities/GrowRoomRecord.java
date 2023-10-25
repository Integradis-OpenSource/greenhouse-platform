package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class GrowRoomRecord {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int day;
    private Date date;
    private Date time;
    private int grow_room;
    private float air_temperature;
    private String compost_temperature;
    private int carbon_dioxide;
    private int air_humidity;
    private float setting;
    private String comment;

    @Getter
    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;

    public GrowRoomRecord(){

    }

    public GrowRoomRecord(Crop crop){
        this.crop = crop;
    }

}
