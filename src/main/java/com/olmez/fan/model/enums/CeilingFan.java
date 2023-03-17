package com.olmez.fan.model.enums;

import java.time.LocalDate;
import java.time.Month;

import org.checkerframework.checker.nullness.qual.Nullable;

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

    private @Nullable String name;
    private FanPace pace = FanPace.OFF;
    private FanDirection direction = FanDirection.CLOCKWISE;

    public boolean isStopDay() {
        var stopDay = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 25);
        return LocalDate.now().equals(stopDay);
    }

    public static CeilingFan stopFan(CeilingFan fan) {
        fan.setPace(FanPace.OFF);
        fan.setDirection(FanDirection.CLOCKWISE);
        return fan;
    }

    @Override
    public String toString() {
        return (name == null || name.isEmpty()) ? "noname" : name;
    }

}
