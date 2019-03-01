/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CargoIntake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class runIntake extends Command {
  public runIntake() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_intake);
    requires(Robot.m_conveyor);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    System.out.println("its here");
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    Robot.m_intake.runningIntake(0.90);
    Robot.m_conveyor.runConveyor(-50);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() 
  {
    if (Robot.m_conveyor.buttonSensor() == false)
    {
      return true;
    } 
    {
      return false;
    }

  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    Robot.m_conveyor.runConveyor(0);
    Robot.m_intake.runningIntake(0); 
    //Robot.m_conveyor.ledOn(1);
    // if (Robot.m_conveyor.buttonSensor() == true)
    // {
    //   Robot.m_conveyor.ledOff(1);
    // }
    // else 
    // {
    //   Robot.m_conveyor.ledOn(0);
    // }
    }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

  }
}
