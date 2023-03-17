package com.olmez.fan.model.enums;

import lombok.Getter;

/**
 * It represents a ceiling fan pace. There are 3-speed settings and an “off”
 * (speed 0) setting.
 */
@Getter
public enum FanPace {
    OFF("Off", 0),
    LOW("Low", 1),
    MEDIUM("Medium", 2),
    HIGH("High", 3);

    private String label;
    private int pace;

    private FanPace(String label, int pace) {
        this.label = label;
        this.pace = pace;
    }

    @Override
    public String toString() {
        return label;
    }

}