package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;


public class RedBlueTest extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor motor1;
        DcMotor motor2;
        Drive myDrive;
        boolean red = false;

        myDrive = new Drive(hardwareMap.dcMotor.get("motor_1"),hardwareMap.dcMotor.get("motor_2"), red);



        /*
        if(red == true) {
            motor2 = hardwareMap.dcMotor.get("motor_2");
            motor1 = hardwareMap.dcMotor.get("motor_1");
            motor1.setDirection(DcMotor.Direction.REVERSE);
        }
        else {
            motor1 = hardwareMap.dcMotor.get("motor_2");
            motor2 = hardwareMap.dcMotor.get("motor_1");
            motor2.setDirection(DcMotor.Direction.REVERSE);
        }
        motor1.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
*/







        waitForStart();
        boolean next = myDrive.forward(100,0.5);
        /*
        motor1.setTargetPosition((int) target);

        motor2.setTargetPosition((int) target);
        motor1.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor2.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor1.setPower(0.50);
        motor2.setPower(0.50);
        */
/*
        target = Drive.forward(15);
        motor2.setTargetPosition((int) target);
        motor2.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor1.setPower(0);
        motor2.setPower(0.70);
*/
        while (!next){}
        telemetry.addData("The End", "Is Near");
    }
}
