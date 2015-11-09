package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Cole Salvato on 10/26/2015.
 */
public class ServoTest extends LinearOpMode{




    public void runOpMode() throws InterruptedException{

        Servo servo;


        servo = hardwareMap.servo.get("servo");



        for(int A=0; A <= 10; A++) {
            servo.setPosition(0);
            sleep(1000);
            servo.setPosition(1);
            sleep(1000);

        }



    }
}
