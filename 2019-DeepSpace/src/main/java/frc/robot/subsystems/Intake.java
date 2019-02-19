package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//import org.junit.internal.builders.NullBuilder;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;

public class Intake extends Subsystem
{
    public TalonSRX intake1;
    DoubleSolenoid intakePiston;

    public Intake()
    {
        intake1 = new TalonSRX(RobotMap.INTAKE);
        intakePiston = new DoubleSolenoid(RobotMap.LEFT_PISTON_IN, RobotMap.LEFT_PISTON_OUT);
    }
    public void runningIntake (double power)
    {
        intake1.set(ControlMode.PercentOutput, power);
    }
    public void intakeOut(){
        intakePiston.set(DoubleSolenoid.Value.kForward);
    }
    public void intakeIn()
    {
        intakePiston.set(DoubleSolenoid.Value.kReverse);
    }

    @Override
    protected void initDefaultCommand() {

    }
}