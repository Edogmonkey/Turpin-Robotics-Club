package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;



public class RedBlueTest extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        Drive myDrive;
        boolean red = false;

        myDrive = new Drive(hardwareMap.dcMotor.get("motor_1"),hardwareMap.dcMotor.get("motor_2"), red);

        waitForStart();
        boolean next = myDrive.forward(24,0.5);
        while (!next){}
        next = false;



        next = myDrive.backward(24, 0.5);
        while (!next){}
        next = false;



        next = myDrive.forward(0,0.5);
        while (!next){}
        next = false;

        telemetry.addData("The End", "Is Near");
    }
}
