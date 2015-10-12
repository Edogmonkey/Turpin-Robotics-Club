package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by edogmonkey on 10/8/15.
 */
public class AutoOpv1 extends LinearOpMode
{

    public DcMotor leftMotor;
    public DcMotor rightMotor;

    @Override
    public void runOpMode() throws InterruptedException
    {

        for(int i=0; i<4; i++) {
            leftMotor.setPower(1.0);
            rightMotor.setPower(1.0);

            sleep(1000);

            leftMotor.setPower(0.5);
            rightMotor.setPower(-0.5);

            sleep(500);
        }

        leftMotor.setPowerFloat();
        rightMotor.setPowerFloat();

    }
}
