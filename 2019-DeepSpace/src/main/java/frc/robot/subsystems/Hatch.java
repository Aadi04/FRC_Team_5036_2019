package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Hatch extends Subsystem
{
    DoubleSolenoid Puncher, Slider, babyShark; 
    
    public Hatch()
    {
        Puncher = new DoubleSolenoid(RobotMap.PUNCHER_IN, RobotMap.PUNCHER_OUT);
        Slider = new DoubleSolenoid(RobotMap.SLIDER_IN, RobotMap.SLIDER_OUT);
        babyShark = new DoubleSolenoid(RobotMap.BABY_SHARK_IN, RobotMap.BABY_SHARK_OUT);
    }

    public void puncherPush()
    {
        Puncher.set(DoubleSolenoid.Value.kForward);
    }
    public void puncherIn()
    {
        Puncher.set(DoubleSolenoid.Value.kReverse);
    }
    public void sliderOut()
    {
        Slider.set(DoubleSolenoid.Value.kForward);
    }
    public void sliderIn()
    {
        Slider.set(DoubleSolenoid.Value.kReverse);
    }
    public void babySharkExtend()
    {
        babyShark.set(DoubleSolenoid.Value.kForward);
    }
    public void babySharkHold()
    {
        babyShark.set(DoubleSolenoid.Value.kReverse);
    }

    @Override
    protected void initDefaultCommand() {

    }
}