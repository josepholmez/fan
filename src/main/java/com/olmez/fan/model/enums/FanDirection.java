package com.olmez.fan.model.enums;

import lombok.Getter;

@Getter
public enum FanDirection {
    CLOCKWISE("Clockwise"),
    COUNTER_CLOCKWISE("Counter Clockwise");

    private String label;

    private FanDirection(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

}
