package com.olmez.fan.model;

import java.time.LocalDate;
import java.time.Month;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.olmez.fan.model.enums.FanDirection;
import com.olmez.fan.model.enums.FanPace;

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
    /**
     * speed of ceiling fan (it can be 0-off, 1-low, 2-medium, 3-high)
     */
    private FanPace pace = FanPace.OFF;
    /**
     * direction of ceiling fan (it can be clockwise or counter clockwise)
     */
    private FanDirection direction = FanDirection.CLOCKWISE;

    /**
     * It should stop on the 25th of December every year.
     * 
     * @return {@code true} if the date is December 25, {@code false} otherwise.
     */
    public boolean isStopDay() {
        var stopDay = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 25);
        return LocalDate.now().equals(stopDay);
    }

    /**
     * This stops the ceiling fan and sets as its pace=off and its
     * direction=clockwise.
     * 
     * @param fan
     * @return Ceiling fan with zero speed and clockwise direction
     */
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
