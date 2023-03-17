package com.olmez.fan.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import com.olmez.fan.FanTestApplication;
import com.olmez.fan.model.FanPace;
import com.olmez.fan.model.enums.CeilingFan;
import com.olmez.fan.model.enums.FanDirection;
import com.olmez.fan.utility.TestUtility;

/**
 * /**
 * Test classes use test database!
 */
@SpringBootTest(classes = FanTestApplication.class)
@TestPropertySource(TestUtility.SOURCE_PROPERTIES)
@ActiveProfiles(TestUtility.PROFILE)
class CeilingFanRepositoryTest {

    @Autowired
    private CeilingFanRepository repository;

    @BeforeEach
    public void setup() {
        // clear test db
        repository.deleteAll();
    }

    @Test
    void testFindAll() {
        // adjust
        var fan = new CeilingFan();
        fan.setName("fan");
        fan = repository.save(fan);

        var fan2 = new CeilingFan();
        fan.setName("fan2");
        fan.setPace(FanPace.MEDIUM);
        fan.setDirection(FanDirection.COUNTER_CLOCKWISE);
        fan2 = repository.save(fan2);

        // act
        var fanList = repository.findAll();
        assertThat(fanList).hasSize(2);
    }

}
