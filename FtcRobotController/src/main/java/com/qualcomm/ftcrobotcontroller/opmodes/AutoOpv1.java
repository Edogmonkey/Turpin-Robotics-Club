package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by edogmonkey on 10/8/15.
 */
public class AutoOpv1 extends LinearOpMode
{

    DcMotor leftMotor;
    DcMotor rightMotor;
    public void runOpMode() throws InterruptedException
    {
        leftMotor = hardwareMap.dcMotor.get("leftMotor");//Set the leftMotor to the motor in the hardware map
        rightMotor = hardwareMap.dcMotor.get("rightMotor");//Set the rightMotor to the motor in  the hardware map
        rightMotor.setDirection(DcMotor.Direction.REVERSE);//Reverse the right motor

        waitForStart();

        for (int x = 0; x < 4; x++)
        {
            leftMotor.setPower(1.0);
            rightMotor.setPower(1.0);

            sleep(500);

            leftMotor.setPower(0.5);
            rightMotor.setPower(-0.5);

            sleep(500);
        }

        leftMotor.setPower(0);
        rightMotor.setPower(0);

    }
}
