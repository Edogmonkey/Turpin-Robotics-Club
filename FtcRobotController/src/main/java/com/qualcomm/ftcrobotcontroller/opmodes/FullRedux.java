package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by QuantumStatus on 12/26/2015.
 */

public class FullRedux extends OpMode {

    DcMotor motorRight;     // Motor Controller 1: Port 1
    DcMotor motorLeft;      // Motor Controller 1: Port 2
    DcMotor motorTwist;     // Motor Controller 2: Port 2
    DcMotor motorBucket;    // Motor Controller 3: Port 1
    DcMotor motorLift;      // Motor Controller 3: Port 2
    Servo servoPlow;        // Servo Controller 1: Port 1
    //Servo servoSpin;        // Servo Controller 1: Port 2
    boolean plowExtended;
    double plowLength;
    double plowExtension;
    int ENCODER_LIMIT;

    public void init() {

        // Map all of the components
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorBucket = hardwareMap.dcMotor.get("motorBucket");
        motorLift = hardwareMap.dcMotor.get("motorLift");
        motorTwist = hardwareMap.dcMotor.get("motorTwist");
        //servoSpin = hardwareMap.servo.get("servoSpin");
        servoPlow = hardwareMap.servo.get("servoPlow");

        // Reverse left motor and twist motor
        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        motorTwist.setDirection(DcMotor.Direction.REVERSE);

        // Reset motor encoders
        //motorLift.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motorTwist.setMode(DcMotorController.RunMode.RESET_ENCODERS);

        // Set to run using encoders
        //motorLift.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motorTwist.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        ENCODER_LIMIT = 360;
        plowLength = servoPlow.getPosition();
        plowExtended = false;
        plowExtension = 0.4;

        //motorLift.setTargetPosition(motorLift.getCurrentPosition());

    }

    public void loop() {

        // Set power to drive motors
        motorRight.setPower(gamepad1.right_stick_y * 0.75);
        motorLeft.setPower(gamepad1.left_stick_y * 0.75);

        // Set power to twist motor
        if (gamepad2.dpad_left && gamepad2.dpad_right) {
            motorTwist.setPower(0); }
        else if (gamepad2.dpad_left) {
            motorTwist.setPower(0.075); }
        else if (gamepad2.dpad_right) {
            motorTwist.setPower(-0.075); }
        else {
            motorTwist.setPower(0); }

        // Set power to lift motor
        /*if (gamepad2.dpad_up && gamepad2.dpad_down) {
            motorLift.setMode(DcMotorController.RunMode.RUN_TO_POSITION); }
        else if (gamepad2.dpad_up && motorLift.getCurrentPosition() < ENCODER_LIMIT) {
            motorLift.setMode(DcMotor.RunMode.);
            motorLift.setPower(0.25);
            motorLift.setTargetPosition(motorLift.getCurrentPosition()); }
        else if (gamepad2.dpad_down) {
            motorLift.setPower(-0.125);
            motorLift.setTargetPosition(motorLift.getCurrentPosition()); }
        else {
            motorLift.setMode(DcMotorController.RunMode.RUN_TO_POSITION); }*/

        if (gamepad2.dpad_up && gamepad2.dpad_down) {
            motorLift.setPower(0); }
        else if (gamepad2.dpad_up) {
            motorLift.setPower(0.25); }
        else if (gamepad2.dpad_down) {
            motorLift.setPower(-0.125); }
        else {
            motorLift.setPower(0); }

        telemetry.addData("Lift", motorLift.getCurrentPosition());
        telemetry.addData("Target", motorLift.getTargetPosition());

        // Set power to bucket motor
        if (gamepad2.left_trigger > 0.1 && gamepad2.right_trigger > 0.1) {
            motorBucket.setPower(0); }
        else if (gamepad2.left_trigger > 0.1) {
            motorBucket.setPower((double)gamepad2.left_trigger); }
        else if (gamepad2.right_trigger > 0.1) {
            motorBucket.setPower((double)gamepad2.right_trigger); }
        else {
            motorBucket.setPower(0); }

        // Extend plow
        if (gamepad1.dpad_up && !plowExtended) {
            plowExtended = true;
            plowLength += plowExtension; }
        // Retract plow
        else if (gamepad1.dpad_down && plowExtended) {
            plowExtended = false;
            plowLength -= plowExtension; }
        // Set plow position
        servoPlow.setPosition(plowLength);

    }

}

