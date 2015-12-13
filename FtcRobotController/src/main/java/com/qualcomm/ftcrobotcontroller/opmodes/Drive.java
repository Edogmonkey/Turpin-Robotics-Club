package com.qualcomm.ftcrobotcontroller.opmodes;



import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

import static java.lang.Thread.sleep;

/**
 * Created by Cole Salvato on 11/27/2015.
 */
public class Drive{
    static DcMotor motor1;
    static DcMotor motor2;

    static int ENCODER_CPR = 1120;
    static double GEAR_RATIO = 1;
    static double WHEEL_DIAMETER = 2.7;

    public static int EncCounts;

    public Drive(DcMotor motorLeft, DcMotor motorRight, boolean red) {

        if(red == true) {
            motor2 = motorRight;
            motor1 = motorLeft;
            //motor1.setDirection(DcMotor.Direction.REVERSE);
            motor2.setDirection(DcMotor.Direction.REVERSE);
        }
        else {
            motor1 = motorRight;
            motor2 = motorLeft;
            //motor2.setDirection(DcMotor.Direction.REVERSE);
            motor1.setDirection(DcMotor.Direction.REVERSE);
        }
        motor1.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);



    }



    public static void forward(double DISTANCE, double power) throws InterruptedException{


        motor1.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);




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
        {EncCounts = motor1.getCurrentPosition();}
        motor1.setPower(0);
        motor2.setPower(0);

        motor1.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);

        sleep(50);

        return;
    }



    public static void backward(double DISTANCE, double power) throws InterruptedException{


        motor1.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);



        final  double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
        final  double ROTATIONS = DISTANCE / CIRCUMFERENCE;
        final  double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
        motor1.setTargetPosition((int) -COUNTS);
        motor2.setTargetPosition((int) -COUNTS);
        motor1.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor2.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor1.setPower(-power);
        motor2.setPower(-power);

        while(motor1.getCurrentPosition() > -COUNTS && motor2.getCurrentPosition() > -COUNTS) {}
        motor1.setPower(0);
        motor2.setPower(0);

        motor1.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);


        sleep(50);

        return;
    }


    public static void pointturn(int degrees, double power) throws InterruptedException
    {




        final  double ROTATIONS = (17.5 * degrees) / (WHEEL_DIAMETER * 360);// was 20 * degrees
        final  double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;

        motor1.setTargetPosition((int) -COUNTS);
        motor2.setTargetPosition((int) COUNTS);
        motor1.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor2.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        if(degrees > 0){
        motor1.setPower(-power);
        motor2.setPower(power);

        while(motor1.getCurrentPosition() > -COUNTS && motor2.getCurrentPosition() < COUNTS)
        {}}
        if(degrees < 0){
            motor1.setPower(power);
            motor2.setPower(-power);

            while(motor1.getCurrentPosition() < -COUNTS && motor2.getCurrentPosition() > COUNTS)
            {}

        }
        motor1.setPower(0);
        motor2.setPower(0);

        motor1.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);

        sleep(50);

        return;

    }


    public static void arcmountainturn(double radius, int degrees, double power) throws InterruptedException
    {
        //Sweep radius and power are of the outside track


        //outside tread (motor2)
        final  double ROTATIONS = (2 * radius * degrees) / (WHEEL_DIAMETER * 360);
        final  double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
        //inside tread
        double powerRatio = (2*radius-30)/(2*WHEEL_DIAMETER*radius);

        motor2.setTargetPosition((int) COUNTS);
        motor1.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        motor2.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

            motor1.setPower(power * powerRatio);
            motor2.setPower(power);

            while(motor2.getCurrentPosition() < COUNTS)
            {}
        motor1.setPower(0);
        motor2.setPower(0);
        motor1.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);

        sleep(50);

        return;

    }



}
