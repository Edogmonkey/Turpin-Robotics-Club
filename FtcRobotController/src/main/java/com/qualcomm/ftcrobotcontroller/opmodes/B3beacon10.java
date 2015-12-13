package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by Cole Salvato on 12/12/2015.
 */
public class B3beacon10 extends LinearOpMode {


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
        myDrive.backward(6, 0.5);
        sleep(10000);

        myDrive.pointturn(45, 0.25);

        myDrive.backward(90, 0.5);

        myDrive.pointturn(45, 0.25);

        myDrive.backward(20, 0.5);



        telemetry.addData("The End", "Is Near");

    }

}
