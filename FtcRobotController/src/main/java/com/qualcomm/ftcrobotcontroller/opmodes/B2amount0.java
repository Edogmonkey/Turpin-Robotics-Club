package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by Cole Salvato on 12/12/2015.
 */
public class B2amount0 extends LinearOpMode{


    public void runOpMode() throws InterruptedException{

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
        myDrive.backward(8, 0.5);
        sleep(0000);

        myDrive.pointturn(45, 0.25);

        myDrive.backward(60, 0.5);

        myDrive.pointturn(450, 0.25);

        myDrive.backward(10, 0.5);

        telemetry.addData("The End", "Is Near");

    }

}
