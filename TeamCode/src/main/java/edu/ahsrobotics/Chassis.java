package edu.ahsrobotics;

import java.util.Timer;

public class Chassis{

    private DriveUnit RightFront;
    private DriveUnit LeftFront;
    private DriveUnit RightBack;
    private DriveUnit LeftBack;

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

    public void StraitMotion(double Speed,double Distence){
        RightBack.zeroDistance();
        LeftBack.zeroDistance();
        RightFront.zeroDistance();
        LeftFront.zeroDistance();

        boolean run = true;
        While(run){
            RightBack.setPower(Speed);
            LeftBack.setPower(Speed);
            RightFront.setPower(Speed);
            LeftFront.setPower(Speed);

            double TravledRight = RightFront.getInchesTravelled();
            double TravledLeft = LeftFront.getInchesTravelled();

            if(TravledRight => Distence || TravledLeft => Distence){
                run = false;
            }
        }

        RightBack.setPower(0);
        LeftBack.setPower(0);
        RightFront.setPower(0);
        LeftFront.setPower(0);
    }

    public void Pivit(double speed,double Rotation){

    }

    public void Strafe(double speed,double Rotation){

    }

    public void Arc(double speed,double Rotation){

}

}

