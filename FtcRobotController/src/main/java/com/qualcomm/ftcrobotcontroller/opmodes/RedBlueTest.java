package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;



public class RedBlueTest extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        Drive myDrive;
        boolean red = true;

        myDrive = new Drive(hardwareMap.dcMotor.get("motor_1"),hardwareMap.dcMotor.get("motor_2"), red);

        waitForStart();

        sleep(10000);
       myDrive.backward(72,0.5);

        myDrive.pointturn(90,0.25);
        //myDrive.pointturn(180,0.25);
       myDrive.backward(72, 0.5);




       //myDrive.forward(6,0.5);



        telemetry.addData("The End", "Is Near");
    }



}
