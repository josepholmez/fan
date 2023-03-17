package com.olmez.fan.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.olmez.fan.model.FanPace;
import com.olmez.fan.model.enums.CeilingFan;
import com.olmez.fan.model.enums.FanDirection;
import com.olmez.fan.services.impl.CeilingFanServiceImpl;

@ExtendWith(MockitoExtension.class)
class CeilingFanServiceImplTest {

    @InjectMocks
    private CeilingFanServiceImpl fanService;

    private CeilingFan fan;

    @Test
    void testPullCord1_NoFan_ExpectedNull() {
        assertThat(fanService.pullCord1(null)).isNull();
    }

    @Test
    void testDefaultCase_ExpectedPaceOffAndDirectionClockwise() {
        // arrange
        fan = new CeilingFan();
        // assert
        assertThat(fan.getPace()).isEqualTo(FanPace.OFF);
        assertThat(fan.getDirection()).isEqualTo(FanDirection.CLOCKWISE);
    }

    @Test
    void testPullCord1_FirstPull_ExpectedPaceLOW() {
        // adjust
        fan = new CeilingFan();
        // act
        var retFan = fanService.pullCord1(fan);
        // assert
        assertThat(retFan.getPace()).isEqualTo(FanPace.LOW);
        assertThat(retFan.getDirection()).isEqualTo(FanDirection.CLOCKWISE);
    }

    @Test
    void testPullCord1_MultiplePace() {
        // arrange
        fan = new CeilingFan();
        // act (0 -> 1)
        var restFan = fanService.pullCord1(fan);
        // assert
        assertThat(restFan.getPace()).isEqualTo(FanPace.LOW);

        // try again (1 -> 2)
        restFan = fanService.pullCord1(restFan);
        assertThat(restFan.getPace()).isEqualTo(FanPace.MEDIUM);

        // try again (2 -> 3)
        restFan = fanService.pullCord1(restFan);
        assertThat(restFan.getPace()).isEqualTo(FanPace.HIGH);

        // try again (3 -> 0)
        restFan = fanService.pullCord1(restFan);
        assertThat(restFan.getPace()).isEqualTo(FanPace.OFF);
    }

    @Test
    void testPullCord2_FirstPull_ExpectedCounterClockwise() {
        // adjust
        fan = new CeilingFan();
        // act
        var retFan = fanService.pullCord2(fan);
        // assert
        assertThat(retFan.getDirection()).isEqualTo(FanDirection.COUNTER_CLOCKWISE);
    }

    @Test
    void testPullCord2_MultiplePull() {
        // arrange
        fan = new CeilingFan();
        // act (clockwise -> counter clockwise)
        var restFan = fanService.pullCord2(fan);
        // assert
        assertThat(restFan.getDirection()).isEqualTo(FanDirection.COUNTER_CLOCKWISE);

        // try again (counter clockwise -> clockwise)
        restFan = fanService.pullCord2(restFan);
        assertThat(restFan.getDirection()).isEqualTo(FanDirection.CLOCKWISE);

        // try again (clockwise -> counter clockwise)
        restFan = fanService.pullCord2(restFan);
        assertThat(restFan.getDirection()).isEqualTo(FanDirection.COUNTER_CLOCKWISE);
    }

    @Test
    void testPullCord2AndPullCord2_MultipleCase() {
        // arrange
        fan = new CeilingFan();
        fan.setPace(FanPace.MEDIUM);

        // pull cord1
        var restFan = fanService.pullCord1(fan);
        assertThat(restFan.getPace()).isEqualTo(FanPace.HIGH);
        assertThat(restFan.getDirection()).isEqualTo(FanDirection.CLOCKWISE);

        // pull cord2
        restFan = fanService.pullCord2(restFan);
        assertThat(restFan.getPace()).isEqualTo(FanPace.HIGH);
        assertThat(restFan.getDirection()).isEqualTo(FanDirection.COUNTER_CLOCKWISE);

        // pull cord1
        restFan = fanService.pullCord1(restFan);
        assertThat(restFan.getPace()).isEqualTo(FanPace.OFF);
        assertThat(restFan.getDirection()).isEqualTo(FanDirection.COUNTER_CLOCKWISE);

        // pull cord2
        restFan = fanService.pullCord2(restFan);
        assertThat(restFan.getPace()).isEqualTo(FanPace.OFF);
        assertThat(restFan.getDirection()).isEqualTo(FanDirection.CLOCKWISE);

    }

}
