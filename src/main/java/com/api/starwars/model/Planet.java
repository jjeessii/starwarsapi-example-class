package com.api.starwars.model;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by accesoeps on 30/06/17.
 */
@Entity
@Data
//@Getter @Setter and @NoArgsConstructor
public class Planet extends ResourceSupport{
    //planet no debe extender de resourcesupport, estoy mezclando modelo con resource support deberia crear un objeto nuevo
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
