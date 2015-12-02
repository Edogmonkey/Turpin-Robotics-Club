package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Cole Salvato on 10/3/2015.
 */
public class TankDrive extends OpMode {
    boolean motorFast = false;
    DcMotor lift;
    DcMotor right;
    DcMotor left;
    DcMotor twist;
    Servo servo;
    double rightPower = 0;
    double leftPower = 0;
    public void init()
    {

        servo = hardwareMap.servo.get("servo");
        right = hardwareMap.dcMotor.get("motorRight");
        left = hardwareMap.dcMotor.get("motorLeft");
        twist = hardwareMap.dcMotor.get("motorTwist");
        lift = hardwareMap.dcMotor.get("motorLift");
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
          /*rightPower = (-gamepad1.right_stick_y * 0.33);
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
        }*/
        right.setPower(-gamepad1.right_stick_y * 0.33);
        left.setPower(-gamepad1.left_stick_y * 0.33);
        twist.setPower(gamepad2.left_stick_x * 0.5);
        lift.setPower(gamepad2.left_stick_y * 0.6 + 0.15);
        if (gamepad2.left_trigger > 0)
            servo.setPosition(gamepad2.left_trigger);
        else if (gamepad2.right_trigger > 0)
            servo.setPosition(gamepad2.right_trigger);
    }
    public void stop(){}
}
