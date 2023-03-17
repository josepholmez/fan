package com.olmez.fan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import com.olmez.fan.utility.TestUtility;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Profile(TestUtility.PROFILE)
@Slf4j
public class FanTestApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(FanTestApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("---Test application is running!--");
  }

}
