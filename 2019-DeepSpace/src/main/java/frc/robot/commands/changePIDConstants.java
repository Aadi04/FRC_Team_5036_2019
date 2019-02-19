/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class changePIDConstants extends Command {
  double newkP, newkI, newkD, newSetpoint;

  public changePIDConstants() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_DriveTrain);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    this.newkP = 0;
    this.newSetpoint = 0;
    this.newkI = 0;
    this.newkD = 0;

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    newkP = SmartDashboard.getNumber("kP",0.0);
    newkI = SmartDashboard.getNumber("kI", 0.0);
    newkD = SmartDashboard.getNumber("kD", 0.0);
    newSetpoint = SmartDashboard.getNumber("Setpoint", 0.0);

    Robot.m_DriveTrain.drivekP = newkP;
    Robot.m_DriveTrain.drivekI = newkI;
    Robot.m_DriveTrain.drivekD = newkD;
    Robot.m_DriveTrain.setPoint = newSetpoint;

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println(Robot.m_DriveTrain.setPoint);
    System.out.println(Robot.m_DriveTrain.drivekP);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
