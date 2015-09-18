package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by edogmonkey on 9/15/15.
 */
public class newTeleop extends OpMode
{
    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public void init()  //Initialize any motors, sensors, or other objects on the robot
    {
        leftMotor = hardwareMap.dcMotor.get("leftMotor");//Set the leftMotor to the motor in the hardware map
        rightMotor = hardwareMap.dcMotor.get("rightMotor");//Set the rightMotor to the motor in  the hardware map
        rightMotor.setDirection(DcMotor.Direction.REVERSE);//Reverse the right motor
    }

    public void loop()  //Constantly loops while the OpMode is active.  Place teleop code here
    {
        leftMotor.setPower(gamepad1.left_stick_y * -1);    //Assign left motor to left stick
        rightMotor.setPower(gamepad1.right_stick_y * -1);   //Assign right motor to right stick
    }
}
