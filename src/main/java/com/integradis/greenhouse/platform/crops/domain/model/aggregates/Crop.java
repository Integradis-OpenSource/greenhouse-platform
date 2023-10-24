package com.integradis.greenhouse.platform.crops.domain.model.aggregates;

import com.integradis.greenhouse.platform.crops.domain.model.entities.*;

import com.integradis.greenhouse.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Crop extends AuditableModel {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private Date startDate;
    @LastModifiedDate
    private Date endDate;
    private boolean state;

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

    public void changeCropState(){
        this.state = false;
    }
}
