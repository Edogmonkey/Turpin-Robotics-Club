package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.TouchSensor;


public class RedBlueTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Drive myDrive;
        TouchSensor Tsensor;
        boolean red;
        Tsensor = hardwareMap.touchSensor.get("touch");

        if (Tsensor.isPressed()) {
            red = false;
        }
        else {
            red = true;
        }
        telemetry.addData("red", red);
        myDrive = new Drive(hardwareMap.dcMotor.get("motorLeft"), hardwareMap.dcMotor.get("motorRight"), red);

        waitForStart();

        sleep(10000);
        myDrive.backward(72, 0.5);

        myDrive.pointturn(90, 0.25);
        //myDrive.pointturn(180,0.25);
        myDrive.backward(72, 0.5);


        //myDrive.forward(6,0.5);


        telemetry.addData("The End", "Is Near");
    }
}



