package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

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
    double servoPosition;
    double servoDelta = 0.1;
    final static double SERVO_MAX_POS = 0.20;
    final static double SERVO_MIN_POS = 0.90;
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
        right.setDirection(DcMotor.Direction.REVERSE);
        twist.setDirection(DcMotor.Direction.REVERSE);
        lift.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        twist.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        lift.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        twist.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

    }

    public void loop()
    {

        right.setPower(-gamepad1.right_stick_y * 0.75);

        left.setPower(-gamepad1.left_stick_y * 0.75);

        if (gamepad2.dpad_left && gamepad2.dpad_right)
            twist.setPower(0);
        else if (gamepad2.dpad_right)
            twist.setPower(-0.075);
        else if (gamepad2.dpad_left /*&& twist.getCurrentPosition() < ENCODER_LIMIT*/)
            twist.setPower(0.075);
        else
            twist.setPower(0);

        if (gamepad2.dpad_up && gamepad2.dpad_down)
            lift.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        else if (gamepad2.dpad_up && twist.getCurrentPosition() < ENCODER_LIMIT){
            lift.setPower(-1);
            lift.setTargetPosition(lift.getCurrentPosition());}
        else if (gamepad2.dpad_down){
            lift.setPower(1);
            lift.setTargetPosition(lift.getCurrentPosition());}
        else
            lift.setMode(DcMotorController.RunMode.RUN_TO_POSITION);

        lift.setPower(gamepad2.left_stick_y * 0.5);

        if (gamepad2.left_bumper){
            servoPosition -= servoDelta;}
        else if (gamepad2.right_bumper){
            servoPosition += servoDelta;}
        servoPosition = Range.clip(servoPosition, SERVO_MIN_POS, SERVO_MAX_POS);
        servo.setPosition(servoPosition);

        if (gamepad2.a){
            spin.setDirection(Servo.Direction.FORWARD);
            spin.setPosition(1);
        }
        else if (gamepad2.y){
            spin.setDirection(Servo.Direction.REVERSE);
            spin.setPosition(1);
        }
        else
            spin.setPosition(0.47);


    }

    public void stop(){}


}