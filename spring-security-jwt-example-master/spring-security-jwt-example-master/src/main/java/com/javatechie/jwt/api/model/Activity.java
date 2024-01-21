package com.javatechie.jwt.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmovie")
    private Long idmovie;

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "cinemano")
    private String cinemaNo;

    @Column(name = "nameactivity")
    private String namemovie;

    @Column(name = "detail")
    private String detail;

}
