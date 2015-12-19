package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Cole Salvato on 10/26/2015.
 */
public class ServoTest extends OpMode {


    Servo servo;
    double servoPosition;
    double servoDelta = 0.01;
    final static double SERVO_MAX_POS = 0.01;
    final static double SERVO_MIN_POS = 0.50;


    public void init(){

        servo = hardwareMap.servo.get("servo");
        servoPosition = 0.25;

    }

    public void loop(){

        /*if (gamepad2.x){
            servoPosition -= servoDelta;}
        else if (gamepad2.b){
            servoPosition += servoDelta;}
        servoPosition = Range.clip(servoPosition, SERVO_MIN_POS, SERVO_MAX_POS);
        servo.setPosition(servoPosition);*/

        if (gamepad2.a){
            servo.setDirection(Servo.Direction.FORWARD);
            servo.setPosition(1);
        }
        else if (gamepad2.y){
            servo.setDirection(Servo.Direction.REVERSE);
            servo.setPosition(1);
        }
        else
            servo.setPosition(0);

    }
}
