# About

This project was created by Joseph (Yusuf) Ölmez on March 17, 2023, as part of the job application process at Medavie Blue Cross.
As the first step for the Full Stack Developer opportunity, the following assignment was requested to be codded.
This project is the answer to this assignment.

# Assigment

From : Ankit Kalal (ankit.kalal@medavie.bluecross.ca)
Date of Issue : March 17, 2023 10:33 AM
Due Date : March 19, 2023 10:33 AM

Test statement follows:

In Java, implement a simple ceiling fan which has two pull cords and the following characteristics:
· One cord increases the speed each time it is pulled. There are 3 speed settings, and an “off” (speed 0) setting. If the cord is pulled on speed 3, the fan returns to the “off” setting.
· One cord reverses the direction of the fan at the current speed setting. Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again.
· The ceiling fan should be “off” on December 25th all day even if the cords are pulled.
· You can assume the unit is always powered (no wall switch)

Assessment format: Please provide your project via a link to your public code repository.

Please send your assessment results directly to ankit.kalal@medavie.bluecross.ca within 48 hours.

# Repository

- Owner: Joseph (Yusuf) Olmez
- Public access repository: https://bitbucket.org/josephpersonal/fan/src/main/

# Note

The MySQL database connection is disabled. Database usage, security, or frontend are not included in this project as they are not within the scope of the assignment.

# How do I create the project

## Problem

The problem is to implement a Java program that simulates a ceiling fan with specific functionalities such as changing speed and direction, turning off on a specific date (December 25th), and having an "off" setting.

## Requirements

• Two pull cords: The ceiling fan should have two pull cords that can be used to control the speed and direction of the fan.
• Three-speed settings: The fan should have three-speed settings and an "off" setting. Pulling the cord once should increase the speed, and pulling the cord on speed 3 should turn off the fan.
• Reversing direction: The second cord should be used to reverse the direction of the fan at the current speed setting. Once the direction has been reversed, it should remain reversed as the speed is changed until it is reversed again.
• StopDay setting: On December 25th, the fan should be off all day, regardless of the cord's position.

## Functionalities to implement the requirements:

• Method 1-pullCord1() for increasing the speed: When the first pull cord is pulled, the speed of the fan should increase by one. If the fan is already at the maximum speed (3), then pulling the cord should turn off the fan.
• Method 2: pullCord2() for reversing the direction: When the second pull cord is pulled, the direction of the fan should reverse. Once the direction has been reversed, it should remain reversed until it is reversed again.
• Method 3: stopFan() for setting the fan to the "off" position: The speed should be set to "off". The direction should be set to clockwise.
• Method 4: isStopDay() for checking the date: The program should check the current date and determine if it is December 25th. If it is, then the fan should be turned off.

## Design:

• Service Layer design pattern was used.
• BaseObject class: This class is the superclass which is used to reduce boilerplate code (id, deleted).
• CeilingFan class: This class represents the state of the ceiling fan. It holds the status of the speed and direction of the fan. It also contains methods that check stop day and stop the fan. At first, it was assumed that CeilingFan objects would be stored in the database, then this was ignored.
• Pace and Direction enum classes: These classes represent the speed and direction settings of the fan. The Speed class represents the speed settings from 0 to 3, while the Direction class represents the direction of the fan. These classes can use to change the state of the fan.
• CeilingFanService class: This class is the service that controls the speed and direction of the fan.
• Unit Test classes: These classes test the methods of the CeilingFan and CeilingFanService classes. These tests cover all scenarios.
