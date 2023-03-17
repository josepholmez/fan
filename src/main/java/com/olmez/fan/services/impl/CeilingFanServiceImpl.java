package com.olmez.fan.services.impl;

import org.springframework.stereotype.Service;

import com.olmez.fan.model.FanPace;
import com.olmez.fan.model.enums.CeilingFan;
import com.olmez.fan.model.enums.FanDirection;
import com.olmez.fan.services.CeilingFanService;

@Service
public class CeilingFanServiceImpl implements CeilingFanService {

    @Override
    public CeilingFan pullCord1(CeilingFan fan) {
        if (fan == null) {
            return null;
        }

        if (fan.isStopDay()) {
            return CeilingFan.stopFan(fan);
        }

        var curPace = fan.getPace();
        fan.setPace(increaseFanPace(curPace));
        return fan;

    }

    @Override
    public CeilingFan pullCord2(CeilingFan fan) {
        if (fan == null) {
            return null;
        }

        if (fan.isStopDay()) {
            return CeilingFan.stopFan(fan);
        }

        var curDirection = fan.getDirection();
        fan.setDirection(switchFanDirection(curDirection));
        return fan;
    }

    private FanPace increaseFanPace(FanPace pace) {
        if (pace == null) {
            return FanPace.OFF;
        }

        switch (pace) {
            case OFF:
                return FanPace.LOW;
            case LOW:
                return FanPace.MEDIUM;
            case MEDIUM:
                return FanPace.HIGH;
            default:
                return FanPace.OFF;
        }
    }

    private FanDirection switchFanDirection(FanDirection direction) {
        if (direction == null) {
            return FanDirection.CLOCKWISE;
        }
        return (direction == FanDirection.CLOCKWISE) ? FanDirection.COUNTER_CLOCKWISE : FanDirection.CLOCKWISE;
    }

}
