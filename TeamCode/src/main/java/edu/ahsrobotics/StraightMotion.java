package edu.ahsrobotics;

public class StraightMotion extends Motion {

    private double motorPower;
    private double distance;

    public StraightMotion(double motorPower, double distance, double timeout){
        this.motorPower=motorPower;
        this.distance= distance;
        this.timeout=timeout;
    }

    public double getMotorPower() {
        return motorPower;
    }

    public double getDistance() {
        return distance;
    }
}
