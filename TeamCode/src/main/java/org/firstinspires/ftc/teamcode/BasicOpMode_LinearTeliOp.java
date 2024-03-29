import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")
@Disabled
public class BasicOpMode_Linear extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        LBD  = hardwareMap.get(DcMotor.class, "LBD");
        RBD = hardwareMap.get(DcMotor.class, "RBD");
        LFD  = hardwareMap.get(DcMotor.class, "LFD");
        RFD = hardwareMap.get(DcMotor.class, "RFD");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        LBD.setDirection(DcMotor.Direction.REVERSE);
        RBD.setDirection(DcMotor.Direction.REVERSE);
        LFD.setDirection(DcMotor.Direction.FORWARD);
        RFD.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            double LBD;
            double RBD;
            double LFD;
            double RFD;

            double drive = -gamepad1.right_stick_y;
            double strafe  =  gamepad1.right_stick_x;
            LBD = Range.clip(drive, -1.0, 1.0);
            RBD = Range.clip(drive, -1.0, 1.0);
            LFD = Range.clip(drive, -1.0, 1.0);
            RFD = Range.clip(drive, -1.0, 1.0);

            LBD = Range.clip(-strafe, -1.0, 1.0);
            RBD = Range.clip(strafe, -1.0, 1.0);
            LFD = Range.clip(strafe, -1.0, 1.0);
            RFD = Range.clip(-strafe, -1.0, 1.0);

            LBD.setPower(LBD);
            RBD.setPower(RBD);
            LFD.setPower(LFD);
            RFD.setPower(RFD);
            
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
