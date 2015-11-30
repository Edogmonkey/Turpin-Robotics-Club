package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Cole Salvato on 10/3/2015.
 */
public class TankDrive extends OpMode {
    boolean motorFast = false;
    boolean twisting = false;
    DcMotor right;
    DcMotor left;
    DcMotor twist;
    double rightPower = 0;
    double leftPower = 0;
    public void init()
    {

        right = hardwareMap.dcMotor.get("motor_2");
        left = hardwareMap.dcMotor.get("motor_1");
        twist = hardwareMap.dcMotor.get("motor_3");

        left.setDirection(DcMotor.Direction.REVERSE);

    }
    public void loop()
    {
    if(gamepad1.b = true || motorFast == true)
    {
        rightPower = (-gamepad1.right_stick_y * 0.75);
        leftPower = (-gamepad1.left_stick_y * 0.75);
        motorFast = true;
    }
    if(gamepad1.a = true || motorFast == false)
    {

        rightPower = (-gamepad1.right_stick_y * 0.33);
        leftPower = (-gamepad1.left_stick_y * 0.33);
        motorFast = false;
    }
        if(gamepad1.left_bumper == true){
            leftPower = leftPower - 0.25;
        }
        if(gamepad1.right_bumper == true){
            rightPower = rightPower - 0.25;
        }
        if(gamepad1.left_trigger > 0.2){
            leftPower = leftPower + 0.25;
        }
        if(gamepad1.right_trigger > 0.2){
            rightPower = rightPower + 0.25;
        }
        right.setPower(rightPower);
        left.setPower(leftPower);
        if(gamepad1.x == true){
            twist.setPower(0.5);
            twisting = true;
        }
        if(gamepad1.y == true){
            twist.setPower(-0.5);
            twisting = true;
        }
        if(twisting == false){
            twist.setPower(0);
        }
        twisting = false;

    }
    public void stop(){}
}
