package edu.ahsrobotics;

import java.util.Timer;

public class Chassis implements MotionRunner {

    private DriveUnit RightFront;
    private DriveUnit LeftFront;
    private DriveUnit RightBack;
    private DriveUnit LeftBack;

    private double offset = 1.5;
    private double vDilation = 1;
    private double hDilation = 3;
    private double runTime;


    public Chassis(){
        this.RightFront= new DriveUnit(1,4,"RightFront",false);
        this.LeftFront= new DriveUnit(1,4,"LeftFront",true);
        this.RightBack= new DriveUnit(1,4,"RightBack",false);
        this.LeftBack= new DriveUnit(1,4,"LeftBack",true);
    }



    public void init(){
        RightFront.init();
        LeftFront.init();
        LeftBack.init();
        RightBack.init();
    }

    public void execute(Motion m){

        double s_location = RightBack.getInchesTravelled();
        StraightMotion s = (StraightMotion) m;
        double test_distance = s.getDistance();
        runTime = Math.log(Math.pow(10,test_distance)-1);
        double startTime = System.currentTimeMillis();

        while(Math.abs(s_location)+test_distance>Math.abs(RightBack.getInchesTravelled())){

            double desired_distance = controlDistance(System.currentTimeMillis()-startTime);
            double actual_distance = RightBack.getInchesTravelled();
            double error = desired_distance-actual_distance;

        }

        RightBack.setPower(0);
        LeftBack.setPower(0);
        RightFront.setPower(0);
        LeftFront.setPower(0);
    }

//These return the distance we should have travelled in inches
    private double rampUp(double time){
        return vDilation*Math.log(1+Math.exp(hDilation*(time-offset)))-vDilation*Math.log(1+Math.exp(hDilation*(0-offset)));

    }

    private double rampDown(double time){
        return -vDilation*Math.log(1+Math.exp(-(hDilation*(time-runTime)-offset)))+2*rampUp(runTime/2+offset);

    }

}

