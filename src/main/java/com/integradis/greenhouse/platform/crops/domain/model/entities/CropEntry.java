package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Entity
public class CropEntry {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String day;
    private LocalDate date;
    private LocalDate time;

    @Getter
    private String author;

    @Getter
    private Long nextItemId;

    @ManyToOne
    @Getter
    private Crop crop;

    @Getter
    protected CropPhase cropPhase;

    public CropEntry(){
        this.date = LocalDate.now();
        this.day = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        this.nextItemId = null;
    }

    public CropEntry(String author, Long nextItemId){
        this.author = author;
        this.date = LocalDate.now();
        this.nextItemId = nextItemId;
        this.day = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public void updateNextItemId(Long nextItemId){
        this.nextItemId = nextItemId;
    }
}
