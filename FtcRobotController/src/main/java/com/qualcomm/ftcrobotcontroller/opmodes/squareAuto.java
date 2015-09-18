package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by edogmonkey on 9/15/15.
 */
public class squareAuto extends LinearOpMode
{
    DcMotor leftMotor; //Create our two motors
    DcMotor rightMotor;
    public void initializeRobot() throws InterruptedException //Method to initialize robot motors and variables
    {
        leftMotor = hardwareMap.dcMotor.get("leftMotor"); //Set the motors to devices in the hardware map
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        rightMotor.setDirection(DcMotor.Direction.REVERSE); //Reverse the right motor
        resetEncoder(leftMotor); //Reset the motor on a specified motor
    }

    public void resetEncoder(DcMotor motor) throws InterruptedException //Reset the encoder on the specified robot
    {
        DcMotorController.RunMode currentMode = motor.getChannelMode(); //Get the motor mode to return to
        motor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS); //Set the channel mode to reset the encoder
        while (motor.getCurrentPosition() != 0) //Wait for motor encoder to reset
            waitOneHardwareCycle();
        motor.setChannelMode(currentMode); //Set the motor mode back to its previous state
        while (motor.getChannelMode() != currentMode) //Wait for motor to finish switching
            waitOneHardwareCycle();
    }

    public void drive (int target, double power) throws InterruptedException //Drive a specified distance and a specified power
    {
        resetEncoder(leftMotor); //Reset the left motor encoder
        if (target != 0) //If the target is 0, we aren't moving anywhere, so exit the loop
        {
            float direction = target / Math.abs(target); //Set the motor direction to be the sign of the target value
            while (Math.abs(leftMotor.getCurrentPosition()) < Math.abs(target)) //Drive until the specified distance is reached
            {
                leftMotor.setPower(direction * power); //Start the motors moving and apply power
                rightMotor.setPower(direction * power);
                telemetry.addData("Left motor encoder", leftMotor.getCurrentPosition());
                waitOneHardwareCycle();
            }
        }
        leftMotor.setPower(0); //Stop the motors
        rightMotor.setPower(0);
    }


    public void rotate (int direction, double power, int time) throws InterruptedException //Rotate the robot in set direction
    {
        leftMotor.setPower((double) (direction) * power); //Start the motors moving
        rightMotor.setPower((double) (direction) * power * -1); //Ensure the right motor is moving opposite the left
        sleep(time); //Wait desired time (milliseconds)
        leftMotor.setPower(0); //Shut of power to the motors
        rightMotor.setPower(0);
        resetEncoder(leftMotor); //Reset the encoder
        waitOneHardwareCycle();
    }

    public void runOpMode() throws InterruptedException //Place all code to run the robot here
    {
        initializeRobot(); //Setup motors for program start

        drive(1440, .35);
        rotate(1, .35, 500);

        drive(1440, .35);
        rotate(1, .35, 500);

        drive(1440, .35);
        rotate(1, .35, 500);

        drive(1440, .35);
        rotate(1, .35, 500);

    }
}
