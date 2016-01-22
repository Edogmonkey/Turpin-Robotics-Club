package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by QuantumStatus on 1/19/2016.
 */
public class ArmTester extends OpMode {

    DcMotor motorBucket;
    DcMotor motorLift;

    public void init() {

        motorBucket = hardwareMap.dcMotor.get("motorBucket");
        motorLift = hardwareMap.dcMotor.get("motorLift");
        motorLift.setDirection(DcMotor.Direction.REVERSE);

    }

    public void loop() {

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
            motorBucket.setPower(-(double)gamepad2.right_trigger); }
        else {
            motorBucket.setPower(0); }

    }

}
