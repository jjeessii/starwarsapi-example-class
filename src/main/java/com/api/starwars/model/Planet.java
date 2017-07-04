package com.api.starwars.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by accesoeps on 30/06/17.
 */
@Entity
@Data
//@Getter @Setter and @NoArgsConstructor
public class Planet {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer rotationPeriod;
    private Integer orbitalPeriod;
    private Integer diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private Integer surfaceWater;
    private Long population;
}
