/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.NewHatchMech;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.TurnLEDOn;

public class Intake_NewHatchMech extends Command {
  public Intake_NewHatchMech() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_newHatch);
    requires(Robot.m_conveyor);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_newHatch.runIntake(-0.6);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (Robot.m_newHatch.LimitSwitch1() == false && Robot.m_newHatch.LimitSwitch2() == false)
    {
      return true;
    }
    else 
    {
      
      return false;
    }
    
    

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    if (Robot.m_newHatch.LimitSwitch1() == false)
    {
      System.out.print(Robot.m_newHatch.LimitSwitch1());
      System.out.print(Robot.m_newHatch.LimitSwitch2());
      Robot.m_newHatch.runIntake(-0.15);
    }
    else
    {
      Robot.m_newHatch.runIntake(0);
    }
    
    Robot.m_newHatch.LEDS();
    //Robot.m_conveyor.ledOn(1);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
