package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

/**
 * Created by Cole Salvato on 10/26/2015.
 */
public class SensorTest extends OpMode {
    Double sensor;
    OpticalDistanceSensor ods;
    public void init(){

        ods = hardwareMap.opticalDistanceSensor.get("ods1");



    }
    public void loop(){

        sensor = ods.getLightDetected();
        telemetry.addData("optical distance sensor", sensor);


    }
}
