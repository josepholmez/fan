package com.olmez.fan.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.olmez.fan.model.enums.FanDirection;
import com.olmez.fan.model.enums.FanPace;

class CeilingFanTest {

    @Test
    void testStopFan() {
        // adjust
        var fan = new CeilingFan();
        fan.setPace(FanPace.MEDIUM);
        fan.setDirection(FanDirection.COUNTERCLOCKWISE);

        // act
        CeilingFan retFan = CeilingFan.stopFan(fan);

        // assert
        assertThat(retFan.getPace()).isEqualTo(FanPace.OFF);
        assertThat(retFan.getDirection()).isEqualTo(FanDirection.CLOCKWISE);
    }

    @Test
    void testIsStopDay() {
        // adjust
        var fan = new CeilingFan();

        // act
        var retVal = fan.isStopDay();

        // assert
        assertThat(retVal).isFalse();
    }

}
