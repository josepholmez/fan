package com.olmez.fan.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * When it is desired to create new objects, "id", and "deleted" fields are
 * defined in this class in order to reduce boilerplate code crowd. Deleting
 * objects in the database is generally not desired. Therefore, "deleted" is set
 * as {@code true} for deleted objects.
 */
@MappedSuperclass
@Getter
@Setter
public class BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected boolean deleted = false;
}
