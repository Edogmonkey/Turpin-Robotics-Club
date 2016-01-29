package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by QuantumStatus on 1/28/2016.
 */
public class servoClawReset extends OpMode {

    Servo servoBucket;

    public void init()
    {
        servoBucket = hardwareMap.servo.get("servoBucket");
    }

    public void loop()
    {
        servoBucket.setPosition(0.5);
    }

}
