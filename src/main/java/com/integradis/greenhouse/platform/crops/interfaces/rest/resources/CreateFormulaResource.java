package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateFormulaResource(
                                    String author,
                                    int hay,
                                    int corn,
                                    int guano,
                                    float cottonSeedCake,
                                    int soybeanMeal,
                                    float gypsum,
                                    int urea,
                                    int ammoniumSulphate) {
}
