package com.olmez.fan.model;

import lombok.Getter;

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