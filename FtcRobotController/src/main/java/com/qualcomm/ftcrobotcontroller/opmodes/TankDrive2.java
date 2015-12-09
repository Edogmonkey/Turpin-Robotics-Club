package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Cole Salvato on 10/3/2015. What a
 */
public class TankDrive2 extends OpMode {

    DcMotor lift;
    DcMotor right;
    DcMotor left;
    DcMotor twist;
    Servo servo;
    Servo spin;

    public void init()
    {
        servo = hardwareMap.servo.get("servo");
        spin = hardwareMap.servo.get("spin");
        right = hardwareMap.dcMotor.get("motorRight");
        left = hardwareMap.dcMotor.get("motorLeft");
        twist = hardwareMap.dcMotor.get("motorTwist");
        lift = hardwareMap.dcMotor.get("motorLift");
        right.setDirection(DcMotor.Direction.REVERSE);
    }
    public void loop()
    {
        right.setPower(-gamepad1.right_stick_y * 0.75);
        left.setPower(-gamepad1.left_stick_y * 0.75);
        twist.setPower(gamepad2.left_stick_x * 0.25);
        if (-gamepad2.right_stick_y > 0)
            lift.setPower(-gamepad2.right_stick_y * 0.6 - 0.25);
        if (gamepad2.left_trigger > 0){
            servo.setDirection(Servo.Direction.FORWARD);
            servo.setPosition(gamepad2.left_trigger);}
        else if (gamepad2.right_trigger > 0){
            servo.setDirection(Servo.Direction.REVERSE);
            servo.setPosition(gamepad2.right_trigger);}
        else
            servo.setPosition(0);
        if (gamepad2.right_bumper)
            spin.setDirection(Servo.Direction.FORWARD);
        else
            spin.setDirection(Servo.Direction.REVERSE);
        spin.setPosition(1);
    }
    public void stop(){}
}
