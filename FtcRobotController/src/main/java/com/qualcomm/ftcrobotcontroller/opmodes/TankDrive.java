package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Cole Salvato on 10/3/2015.
 */
public class TankDrive extends OpMode {
    boolean motorFast = false;
    DcMotor lift;
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
        lift = hardwareMap.dcMotor.get("motor_4");
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
        twist.setPower(gamepad2.left_stick_x * 0.5);
        lift.setPower(gamepad2.left_stick_y * 0.6 + 0.15);


    }
    public void stop(){}
}
