/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

public class DriveTrain extends Subsystem {
  private VictorSP rightFront;
  private VictorSP rightBack;
  private VictorSP leftFront;
  private VictorSP leftBack;

  // Gyro
  ADXRS450_Gyro Gyro;

  public DriveTrain(){
    rightFront = new VictorSP(RobotMap.DRIVE_RIGHT_FRONT);
    rightBack = new VictorSP(RobotMap.DRIVE_RIGHT_BACK);
    leftFront = new VictorSP(RobotMap.DRIVE_LEFT_FRONT);
    leftBack = new VictorSP(RobotMap.DRIVE_LEFT_BACK);

    Gyro = new ADXRS450_Gyro();
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ArcadeDrive());
  }

  public void leftDriveOutput(double forward, double rotation){
    double left = forward - rotation;

    // change negatives and stuff here
    if (left>1){
      leftFront.set(-1);
      leftBack.set(-1);
    }
    else{
      leftFront.set(-left);
      leftBack.set(-left);
    }
  }

  public void rightDriveOutput(double forward, double rotation){
    double right = forward + rotation;

    if(right>1){
      rightFront.set(1);
      rightBack.set(1);
    }
    else{
      rightFront.set(right);
      rightBack.set(right);
    }
  }

  // gyro methods

  public double getCurrentAngle(){
    return Gyro.getAngle();
  }

  public void calibrateGyro(){
    Gyro.calibrate();
  }

  public void resetGyro(){
    Gyro.reset();
  }

public boolean GyroConnected(){
 return Gyro.isConnected();
}

}