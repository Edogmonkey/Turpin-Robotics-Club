package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
/**
 * Created by Cole Salvato on 10/9/2015.
 */
public class mechanimDrive extends OpMode {

    DcMotor frontleft;
    DcMotor frontright;
    DcMotor backleft;
    DcMotor backright;
    float flvalue;
    float frvalue;
    float blvalue;
    float brvalue;

    public void init(){

        frontleft = hardwareMap.dcMotor.get("motor_1");
        frontright = hardwareMap.dcMotor.get("motor_2");
        backleft = hardwareMap.dcMotor.get("motor_3");
        backright = hardwareMap.dcMotor.get("motor_4");

        frontright.setDirection(DcMotor.Direction.REVERSE);
        backright.setDirection(DcMotor.Direction.REVERSE);


    }
    public void loop(){

        flvalue = -gamepad1.left_stick_x - gamepad1.left_stick_y;
        frvalue = gamepad1.left_stick_x - gamepad1.left_stick_y;
        blvalue = gamepad1.left_stick_x - gamepad1.left_stick_y;
        brvalue = -gamepad1.left_stick_x - gamepad1.left_stick_y;

        flvalue = flvalue + gamepad1.right_stick_x;
        frvalue = frvalue - gamepad1.right_stick_x;
        blvalue = blvalue + gamepad1.right_stick_x;
        brvalue = brvalue - gamepad1.right_stick_x;





        frontleft.setPower(flvalue/2);
        frontright.setPower(frvalue/2);
        backleft.setPower(blvalue/2);
        backright.setPower(brvalue/2);




    }
}
