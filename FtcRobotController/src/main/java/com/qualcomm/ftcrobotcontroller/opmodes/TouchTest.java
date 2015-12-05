package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;


public class TouchTest extends OpMode {
    TouchSensor TSensor;
    DcMotor FLMotor;
    DcMotor FRMotor;
    DcMotor BLMotor;
    DcMotor BRMotor;
    public void init(){

        TSensor = hardwareMap.touchSensor.get("touch_sensor");
        FLMotor = hardwareMap.dcMotor.get("motor_1");
        FRMotor = hardwareMap.dcMotor.get("motor_2");
        BLMotor = hardwareMap.dcMotor.get("motor_3");
        BRMotor = hardwareMap.dcMotor.get("motor_4");
    }

    @Override
    public void loop() {
        if(TSensor.isPressed()){
            FLMotor.setPower(0.2);
            FRMotor.setPower(0.2);
            BLMotor.setPower(0.2);
            BRMotor.setPower(0.2);


        }
        else{

            FLMotor.setPower(0);
            FRMotor.setPower(0);
            BLMotor.setPower(0);
            BRMotor.setPower(0);


        }

    }
}
