
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")
//@Disabled
public class BasicOpMode_AutoOne extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        //init
        FTCUtilities.setHardWareMap(hardwareMap);
        FTCUtilities.setTelemetry(telemetry);
        FTCUtilities.setOpMode(this);
        Robot robot = new Robot();
        robot.init();
        TestPlan testplan = new testplan(robot);
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();
        testplan.run();
    }
}
