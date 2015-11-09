package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by Cole Salvato on 10/4/2015.
 */
public class OneRotation extends LinearOpMode {

    DcMotor left;
    DcMotor right;


        public void runOpMode() throws InterruptedException
        {
            right = hardwareMap.dcMotor.get("motor_2");
            left = hardwareMap.dcMotor.get("motor_1");

            right.setDirection(DcMotor.Direction.REVERSE);

            waitForStart();



            for(int A=0; A <= 3; A++) {
                right.setPower(1);
                left.setPower(1);

                sleep(1000);

                right.setPower(-1);
                left.setPower(-1);

                sleep(1000);


            }
            right.setPower(0);
            left.setPower(0);




        }



}
