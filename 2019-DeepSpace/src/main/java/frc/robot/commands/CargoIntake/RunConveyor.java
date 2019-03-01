/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CargoIntake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Conveyor;

public class RunConveyor extends Command {

  //private boolean Finished;

  public RunConveyor() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_conveyor);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Finished = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    // if (Conveyor.buttonSensor() == true) {
    //   Robot.m_conveyor.runConveyor(0.75);
    // } else {
    //   Robot.m_conveyor.runConveyor(0);
    //  // Finished = true;
    // }
    Robot.m_conveyor.runConveyor(-1);
    
  }
    

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //if (!Robot.m_conveyor.buttonSensor())
      return false;
    }
  

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_conveyor.runConveyor(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.m_conveyor.runConveyor(0);
  }
}
