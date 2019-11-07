package edu.ahsrobotics;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class DriveUnit {
    private double gearRatio;
    private String deviceName;
    private HardwareMap hardwareMap;
    private DcMotor motor;
    private boolean direction;
    //private static OpMode opmode;


    public Intake(double gearRatio, String deviceName, boolean direction) {
        this.gearRatio = gearRatio;
        this.deviceName = deviceName;
        this.direction = direction;
        init();
    }

    public void init(){
        motor = FTCUtilities.getHardwareMap().get(DcMotor.class,deviceName);
    }

    public void setPower(double power){
        if(!direction){power=-power;}
        motor.setPower(power);
    }

    public void zeroDistance(){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

}
