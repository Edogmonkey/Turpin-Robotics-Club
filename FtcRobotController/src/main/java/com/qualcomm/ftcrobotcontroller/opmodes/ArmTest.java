package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by QuantumStatus on 11/12/2015.
 */
public class ArmTest extends OpMode
{

    DcMotor lift;
    Servo bucket;
    Servo spin;
    int ENCODER_LIMIT;

    public void init()
    {
        lift = hardwareMap.dcMotor.get("lift");
        bucket = hardwareMap.servo.get("bucket");
        spin = hardwareMap.servo.get("spin");
        lift.setDirection(DcMotor.Direction.REVERSE);
        lift.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        lift.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        ENCODER_LIMIT = -360;
    }
    public void loop()
    {
        if (gamepad2.left_stick_y > 0.05 && lift.getCurrentPosition() > ENCODER_LIMIT){
            lift.setPower(-0.75);
            lift.setTargetPosition(lift.getCurrentPosition());}
        else if (gamepad2.left_stick_y < -0.5){
            lift.setPower(0.5);
            lift.setTargetPosition(lift.getCurrentPosition());}
        else
            lift.setMode(DcMotorController.RunMode.RUN_TO_POSITION);

        if (gamepad2.x){
            bucket.setPosition(1);}
        else if (gamepad2.b){
            bucket.setPosition(0);}

        if (gamepad2.a){
            spin.setDirection(Servo.Direction.FORWARD);
            spin.setPosition(1);}
        else if (gamepad2.y){
            spin.setDirection(Servo.Direction.REVERSE);
            spin.setPosition(1);}
        else
            spin.setPosition(0.47);

        telemetry.addData("Lift", lift.getCurrentPosition());
        telemetry.addData("Target", lift.getTargetPosition());
    }
    public void stop(){}
}
