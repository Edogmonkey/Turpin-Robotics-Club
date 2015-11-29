package com.qualcomm.ftcrobotcontroller.opmodes;



import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Cole Salvato on 11/27/2015.
 */
public class Drive extends OpMode{
    static DcMotor motor1;
    static DcMotor motor2;
    public void init() {
        motor2 = hardwareMap.dcMotor.get("motor_2");
        motor1 = hardwareMap.dcMotor.get("motor_1");
        motor1.setDirection(DcMotor.Direction.REVERSE);
    }
    public void loop() {}

    public static boolean forward (double DISTANCE){


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
        motor1.setPower(0.50);
        motor2.setPower(0.50);
        while(motor1.getCurrentPosition() < COUNTS && motor2.getCurrentPosition() < COUNTS)
        {}
        return true;
    }
}
