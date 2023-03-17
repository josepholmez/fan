package com.olmez.fan.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected boolean deleted = false;
}
