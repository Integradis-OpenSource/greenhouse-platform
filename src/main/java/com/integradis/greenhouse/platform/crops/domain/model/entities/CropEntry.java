package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CropEntry {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Getter
    private String day;

    @Getter
    private LocalDate date;

    @Getter
    private LocalTime time;

    @Getter
    private String author;

    @Getter
    private Long nextItemId;

    @ManyToOne
    @Getter
    @JoinColumn(name="crop_id", nullable = false)
    private Crop crop;

    @Getter
    protected CropPhase cropPhase;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;

    public CropEntry(){
        this.date = LocalDate.now();
        this.day = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        this.time = LocalTime.now();
        this.nextItemId = null;
    }

    public CropEntry(String author, Long nextItemId, Crop crop){
        this.author = author;
        this.date = LocalDate.now();
        this.nextItemId = nextItemId;
        this.crop = crop;
        this.day = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        this.time = LocalTime.now();
    }

    public String getFormattedCropPhase(){
        return this.cropPhase.toString().toLowerCase();
    }

    public String getFormattedTime() { return this.time.toString(); }

    public void updateNextItemId(Long nextItemId){
        this.nextItemId = nextItemId;
    }
}
