package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by QuantumStatus on 1/27/2016.
 */
public class GyroTurnTest extends LinearOpMode {


    public void runOpMode() throws InterruptedException {

        Drive myDrive;
        TouchSensor Tsensor;
        boolean red;
        Tsensor = hardwareMap.touchSensor.get("touch");

        if (Tsensor.isPressed()) {
            red = false;
        } else {
            red = true;
        }
        telemetry.addData("red", red);

        waitForStart();

    }

}
