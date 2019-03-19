/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.CargoIntake.throtle;

/**
 * Add your docs here.
 */
public class Conveyor extends Subsystem {
  public VictorSPX ConveyorFront;
  public VictorSPX ConveyorBack;
  public Spark LED;
  public static DigitalInput button;
  public PowerDistributionPanel pdp;


  public Conveyor(){
    ConveyorBack = new VictorSPX(RobotMap.CONVEYOR1);
    ConveyorFront = new VictorSPX(RobotMap.CONVEYOR2);
    LED = new Spark(RobotMap.LED);
    button = new DigitalInput(2);
    pdp = new PowerDistributionPanel();

    //ConveyorBack.follow(ConveyorFront);
  }

  public void runConveyor(double power){
      ConveyorFront.set(ControlMode.PercentOutput, power);
      ConveyorBack.set(ControlMode.PercentOutput, power);
  }

  public void LEDBrightness(double x){
    LED.set(x);
  }
  public void ledOn(int speed)
  {
    LED.set(speed);
  }
  public void ledOff(int speed)
  {
    LED.set(speed);
  }
  public boolean buttonSensor()
  {
    return button.get();
  }

    @Override
    protected void initDefaultCommand() {
      setDefaultCommand(new throtle());

    }
  public double getCurrent5()
  {
    return pdp.getCurrent(1);
  }
  public double getCurrent6()
  {
    return pdp.getCurrent(0);
  }
  public double getCurrentAvg()
  {
    return (getCurrent5() + getCurrent6()) / 2;
  }
  
  public void updateConveyor()
  {
    SmartDashboard.putBoolean("button", buttonSensor());
    SmartDashboard.putNumber("Current 5", getCurrent5());
    SmartDashboard.putNumber("Current 6", getCurrent6());
  }
 

}


