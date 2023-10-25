package com.integradis.greenhouse.platform.crops.domain.model.aggregates;

import com.integradis.greenhouse.platform.crops.domain.model.entities.*;

import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Crop extends AbstractAggregateRoot<Crop> {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private Date startDate;
    @LastModifiedDate
    private Date endDate;
    private boolean state;

    public CropPhase cropPhase;

    @Getter
    @OneToMany
    @JoinColumn(name = "formula_id")
    private List<Formula> formula;

    @Getter
    @OneToMany
    @JoinColumn(name = "preparation_area_id")
    private List<PreparationArea> preparationArea;

    @Getter
    @OneToMany
    @JoinColumn(name = "bunker_id")
    private List<Bunker> bunker;

    @Getter
    @OneToMany
    @JoinColumn(name = "tunnel_id")
    private List<Tunnel> tunnel;

    @Getter
    @OneToMany
    @JoinColumn(name = "grow_room_id")
    private List<GrowRoomRecord> growRoomRecord;

    public Crop(){
        formula = new ArrayList<>();
        preparationArea = new ArrayList<>();
        bunker = new ArrayList<>();
        tunnel = new ArrayList<>();
        growRoomRecord = new ArrayList<>();
    }

    public void start(){
        this.startDate = new Date();
        this.state = true;
        this.cropPhase = CropPhase.FORMULA;
    }

    public void complete(){
        this.endDate = new Date();
        this.state = false;
    }

    public boolean isActive(){
        return this.state;
    }

}
