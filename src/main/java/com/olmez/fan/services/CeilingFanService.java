package com.olmez.fan.services;

import com.olmez.fan.model.enums.CeilingFan;

public interface CeilingFanService {

    CeilingFan pullCord1(CeilingFan fan);

    CeilingFan pullCord2(CeilingFan fan);
}
