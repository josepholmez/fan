package com.olmez.fan.services;

import com.olmez.fan.model.CeilingFan;
import com.olmez.fan.model.enums.FanDirection;
import com.olmez.fan.model.enums.FanPace;

/**
 * This allows changing the speed and direction of the ceiling fan.
 */
public interface CeilingFanService {

    /**
     * This allows incrementing the speed of the given fan each time it is called.
     * If the fan speed is 3 {@link FanPace.HIGH}, the fan is stopped. Stop means
     * pace={@link FanPace.OFF}, direction={@link FanDirection.CLOCKWISE}
     * 
     * @param fan
     * @return one pace accelerated fan
     */
    CeilingFan pullCord1(CeilingFan fan);

    /**
     * This allows switching the direction of the given fan each time it is called.
     * If the direction of the fan is {@link FanDirection.CLOCKWISE}, this method
     * switches to {@link FanDirection.COUNTERLOCKWISE} or versa.
     * 
     * @param fan
     * @return reversed fan
     */
    CeilingFan pullCord2(CeilingFan fan);
}
