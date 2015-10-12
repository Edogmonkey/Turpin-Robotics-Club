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
    public boolean motorFast;
    public double left;
    public double right;

    public void init()  //Initialize any motors, sensors, or other objects on the robot
    {
        leftMotor = hardwareMap.dcMotor.get("leftMotor");//Set the leftMotor to the motor in the hardware map
        rightMotor = hardwareMap.dcMotor.get("rightMotor");//Set the rightMotor to the motor in  the hardware map
        rightMotor.setDirection(DcMotor.Direction.REVERSE);//Reverse the right motor
    }

    public void loop()  //Constantly loops while the OpMode is active.  Place teleop code here
    {

        left = gamepad1.left_stick_y * -1;
        right = gamepad1.right_stick_y * -1;

        if (gamepad1.left_trigger > 0 || motorFast)
        {
            leftMotor.setPower(left);
            rightMotor.setPower(right);
            motorFast = true;
        }

        if (gamepad1.right_trigger > 0 || !motorFast)
        {
            leftMotor.setPower(left*0.5);
            rightMotor.setPower(right*0.5);
            motorFast = false;
        }

        if (gamepad1.left_bumper)
        {
            leftMotor.setPower(1);
            rightMotor.setPower(-1);
        }

        if (gamepad1.right_bumper)
        {
            leftMotor.setPower(-1);
            rightMotor.setPower(1);
        }

    }
}
