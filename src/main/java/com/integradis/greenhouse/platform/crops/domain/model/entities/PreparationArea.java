package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class PreparationArea {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int day;
    private Date date;
    private Date time;
    private int activites;
    private int temperature;
    private String comment;

    @Getter
    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;
}
