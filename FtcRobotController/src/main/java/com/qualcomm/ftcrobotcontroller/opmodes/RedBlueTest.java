package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;



public class RedBlueTest extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        Drive myDrive;
        boolean red = true;

        myDrive = new Drive(hardwareMap.dcMotor.get("motor_1"),hardwareMap.dcMotor.get("motor_2"), red);

        waitForStart();

        myDrive.arcmountainturn(24,90,0.5);
       myDrive.forward(36,0.5);

        myDrive.pointturn(-90,0.25);
        myDrive.pointturn(180,0.25);
       //myDrive.backward(24, 0.5);




       //myDrive.forward(6,0.5);



        telemetry.addData("The End", "Is Near");
    }



}
