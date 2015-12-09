package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by QuantumStatus on 12/2/2015.
 */
public class FullUserControl extends OpMode
{

    DcMotor right;
    DcMotor left;
    DcMotor twist;
    DcMotor lift;
    Servo servo;
    Servo spin;
    int ENCODER_CPR = 1440;
    double ENCODER_LIMIT = ENCODER_CPR * (270 / 360);

    public void init()
    {

        servo = hardwareMap.servo.get("servo");
        spin = hardwareMap.servo.get("spin");
        right = hardwareMap.dcMotor.get("motorRight");
        left = hardwareMap.dcMotor.get("motorLeft");
        twist = hardwareMap.dcMotor.get("motorTwist");
        lift = hardwareMap.dcMotor.get("motorLift");
        spin.setPosition(1);
        spin.setDirection(Servo.Direction.FORWARD);
        right.setDirection(DcMotor.Direction.REVERSE);
        twist.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);

    }

    public void loop()
    {

        right.setPower(-gamepad1.right_stick_y * 0.75);

        left.setPower(-gamepad1.left_stick_y * 0.75);

        if (gamepad2.dpad_left && gamepad2.dpad_right)
            twist.setPower(0);
        else if (gamepad2.dpad_right)
            twist.setPower(0.1);
        else if (gamepad2.dpad_left && (twist.getCurrentPosition() < ENCODER_LIMIT))
            twist.setPower(-0.1);

        if (gamepad2.dpad_up && gamepad2.dpad_down)
            lift.setPower(-0.25);
        else if (gamepad2.dpad_up && twist.getCurrentPosition() < ENCODER_LIMIT)
            lift.setPower(-0.50 + 0.25);
        else if (gamepad2.dpad_down)
            lift.setPower(0.50);

        if (gamepad2.left_trigger > 0){
            servo.setDirection(Servo.Direction.FORWARD);
            servo.setPosition(1);}
        else if (gamepad2.right_trigger > 0){
            servo.setDirection(Servo.Direction.REVERSE);
            servo.setPosition(1);}
        else
            servo.setPosition(0);

    }

    public void stop(){}


}
