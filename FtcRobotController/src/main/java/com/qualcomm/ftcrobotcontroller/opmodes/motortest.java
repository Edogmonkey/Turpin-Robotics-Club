package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
/**
 * Created by Cole Salvato on 10/10/2015.
 */
public class motortest extends OpMode {


    DcMotor motor_1;
    DcMotor motor_2;
    DcMotor motor_3;
    DcMotor motor_4;

    public void init(){


        motor_1 = hardwareMap.dcMotor.get("motor_1");
        motor_2 = hardwareMap.dcMotor.get("motor_2");
        motor_3 = hardwareMap.dcMotor.get("motor_3");
        motor_4 = hardwareMap.dcMotor.get("motor_4");





    }


    public  void loop(){

        if(gamepad1.a = true){
            motor_1.setPower(1);
        }
        else
        {
            motor_1.setPower(0);
        }
        if(gamepad1.b = true){
            motor_2.setPower(1);
        }
        else
        {
            motor_2.setPower(0);
        }
        if(gamepad1.x = true){
            motor_3.setPower(1);
        }
        else
        {
            motor_3.setPower(0);
        }
        if(gamepad1.y = true){
            motor_4.setPower(1);
        }
        else
        {
            motor_4.setPower(0);
        }




    }









}
