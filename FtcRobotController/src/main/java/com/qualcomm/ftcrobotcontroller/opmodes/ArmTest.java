package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Edogmonkey on 11/12/2015.
 */
public class ArmTest extends OpMode
{

    DcMotor arm;
    DcMotor armPivot;
    Servo armBucket;

    public void init()
    {
        arm = hardwareMap.dcMotor.get("motorArm");
        armPivot = hardwareMap.dcMotor.get("motorPivot");
        armBucket = hardwareMap.servo.get("servoBucket");
    }
    public void loop()
    {
        double bucketPos;
        Servo.Direction bucketDir;
        double armPower = gamepad2.right_stick_y * 0.25;
        if(0.05 > gamepad2.right_stick_y && gamepad2.right_stick_y > -0.05)
            armPower += 0.1;
        double armPivotPower = gamepad2.left_stick_x;
        arm.setPower(armPower);
        armPivot.setPower(armPivotPower);
    }
    public void stop(){}
}
