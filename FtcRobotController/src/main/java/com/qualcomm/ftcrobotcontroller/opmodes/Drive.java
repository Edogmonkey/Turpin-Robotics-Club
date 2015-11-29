package com.qualcomm.ftcrobotcontroller.opmodes;



import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Cole Salvato on 11/27/2015.
 */
public class Drive{
    static DcMotor motor1;
    static DcMotor motor2;
    public Drive(DcMotor motorLeft, DcMotor motorRight) {
        motor1 = motorLeft;
        motor2 = motorRight;
        motor1.setDirection(DcMotor.Direction.REVERSE);
        }



    public static boolean forward(double DISTANCE, double power){




        final int ENCODER_CPR = 1440;
        final double GEAR_RATIO = 1;
        final double WHEEL_DIAMETER = 2.7;

        final  double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
        final  double ROTATIONS = DISTANCE / CIRCUMFERENCE;
        final  double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
        motor1.setTargetPosition((int) COUNTS);
        motor2.setTargetPosition((int) COUNTS);
        motor1.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor2.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor1.setPower(power);
        motor2.setPower(power);

        while(motor1.getCurrentPosition() < COUNTS && motor2.getCurrentPosition() < COUNTS)
        {}
        motor1.setPower(0);
        motor2.setPower(0);
        return true;
    }



    public static boolean backward(double DISTANCE, double power){




        final int ENCODER_CPR = 1440;
        final double GEAR_RATIO = 1;
        final double WHEEL_DIAMETER = 2.7;

        final  double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
        final  double ROTATIONS = DISTANCE / CIRCUMFERENCE;
        final  double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
        motor1.setTargetPosition((int) COUNTS);
        motor2.setTargetPosition((int) COUNTS);
        motor1.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor2.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor1.setPower(-power);
        motor2.setPower(-power);

        while(motor1.getCurrentPosition() > COUNTS && motor2.getCurrentPosition() > COUNTS)
        {}
        motor1.setPower(0);
        motor2.setPower(0);
        return true;
    }






}
