package edu.ahsrobotics;

public class Motion extends PlanElement{

    private MotionRunner runner;

    public Motion(MotionRunner motionRunner){
        this.runner = motionRunner;
    }

    @Override
    public void execute(){
       runner.execute(this);
    }


}
