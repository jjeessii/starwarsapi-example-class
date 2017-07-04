package com.api.starwars.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by accesoeps on 30/06/17.
 */
@Entity
@Data
@EntityListeners({AuditingEntityListener.class})
public class People {

    @Id
    @GeneratedValue
    private Long peopleId;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime edited;

    private String name;
    private String birthYear;
    private String eyeColor;
    private String gender;
    private String hairColor;
    private String height;
    private String mass;
    private String skinColor;
}
