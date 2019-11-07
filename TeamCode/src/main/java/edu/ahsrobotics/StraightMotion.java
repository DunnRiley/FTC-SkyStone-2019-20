package edu.ahsrobotics;

public class StraightMotion extends Motion {

    private double motorPower;
    private double distance;

    public StraightMotion(MotionRunner runner ,double motorPower, double distance){
        super (runner);
        this.motorPower=motorPower;
        this.distance= distance;

    }

    public double getMotorPower() {
        return motorPower;
    }

    public double getDistance() {
        return distance;
    }
}
