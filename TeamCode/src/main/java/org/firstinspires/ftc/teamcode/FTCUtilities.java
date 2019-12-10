import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FTCUtilities {

    private static HardwareMap hardwareMap;
    private static Telemetry telemetry;
    private static OpMode opMode;

    public static HardwareMap getHardwareMap(){
        return hardwareMap;
    }

    public static void setHardWareMap(HardwareMap hw){
        FTCUtilities.hardwareMap = hw;
    }

    public static void setTelemetry(Telemetry t){
        FTCUtilities.telemetry = t;
    }

    public static Telemetry getTelemetry(){
        return telemetry;
    }

    public static void setOpMode(OpMode o){
        FTCUtilities.opMode = o;
    }

    public static void OpSleep(int ms){
        ((LinearOpMode) opMode).sleep(ms);
    }
}
