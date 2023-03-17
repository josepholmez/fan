package com.olmez.fan.model.enums;

import com.olmez.fan.model.BaseObject;
import com.olmez.fan.model.FanPace;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CeilingFan extends BaseObject {

    private String name;
    private FanPace pace = FanPace.OFF;
    private FanDirection direction = FanDirection.CLOCKWISE;

}
