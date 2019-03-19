/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TurnToAnlge extends Command {

  double setpoint, epsilon, const_multiplier;

  public TurnToAnlge(double setpoint, double epsilon, double const_multiplier) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_DriveTrain);
    this.setpoint = setpoint;
    this.epsilon = epsilon;
    this.const_multiplier = const_multiplier;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_DriveTrain.resetGyro();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_DriveTrain.turnToAngle(setpoint, epsilon, const_multiplier);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // if (Robot.m_DriveTrain.atTarget()){
    //   return true;
    // } else {
    //   return false;
    // }
    return Robot.m_DriveTrain.atTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_DriveTrain.stop();
  //  Robot.m_DriveTrain.drivePID.resetPID();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.m_DriveTrain.stop();
    Robot.m_DriveTrain.drivePID.resetPID();
  }
}
