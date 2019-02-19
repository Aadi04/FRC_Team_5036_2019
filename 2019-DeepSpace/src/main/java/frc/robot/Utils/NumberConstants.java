package frc.robot.Utils;

public class NumberConstants{
// change values according to encoders used
    //robot constants
	public static final double TOP_SPEED = 10.51; // {robot} / real world
	public static final double MAX_TORQUE = 796.0467; // max torque motor can output in inch-lbs
	public static final double WHEEL_RADIUS = 3; // radius of drive wheel in inches
	public static final double MASS = 100; // mass of robot in pounds
	public static final double MAX_ACCELERATION = MAX_TORQUE / (WHEEL_RADIUS * MASS); // T/dm = a
	public static final int DEFAULT_SEGMENT_RESOLUTION = 1000; //# of vel points per segment
	public static final int PulsePerRotation = 128;
    public static final double gearRatio = 10.75/1;
    public static final double EncoderPulsePerRot = PulsePerRotation*gearRatio;

	//control loop
	public static final double LOOPER_PERIOD = 0.010; //10 ms
	public static final double deltaT = 0.020;
	
	//DriveTrain PID Constants (change values)
    public static double drive_kP = 0.01;
    public static double drive_kI = 0.01;
	public static double drive_kD = 0.1;

	public static final double drive_epsilon = 1.5;

}