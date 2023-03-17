package com.olmez.fan.model.enums;

import lombok.Getter;

/**
 * It represents a ceiling fan direction. There are two ways settings as
 * clockwise or counterclockwise.
 */
@Getter
public enum FanDirection {
    CLOCKWISE("Clockwise"),
    COUNTERCLOCKWISE("Counterclockwise");

    private String label;

    private FanDirection(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

}
