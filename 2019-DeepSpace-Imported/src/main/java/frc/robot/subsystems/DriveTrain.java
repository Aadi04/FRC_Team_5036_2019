/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.Utils.NumberConstants;
import frc.robot.Utils.PIDController;
import frc.robot.commands.ArcadeDrive;

public class DriveTrain extends Subsystem {
  public VictorSP rightFront;
  public VictorSP rightBack;
  public VictorSP leftFront;
  public VictorSP leftBack;
  
  public double gyrokP, gyrokI, gyrokD;
  public double drivekP, drivekI, drivekD;
  public double setPoint;

  // Gyro
  public ADXRS450_Gyro Gyro;

  //Encoder
  public Encoder encoder;

  // PID
  public PIDController drivePID;
  public PIDController gyroPID;

  public int atTargetCount = 0;

  public DriveTrain(){
    rightFront = new VictorSP(RobotMap.DRIVE_RIGHT_FRONT);
    rightBack = new VictorSP(RobotMap.DRIVE_RIGHT_BACK);
    leftFront = new VictorSP(RobotMap.DRIVE_LEFT_FRONT);
    leftBack = new VictorSP(RobotMap.DRIVE_LEFT_BACK);

    gyrokP = 0.12;
    gyrokI = 0.0;
    gyrokD = 0.3;
    setPoint = 90;

    drivekP = 0.11;
    drivekI = 0.2;
    drivekD = 0.05;

    Gyro = new ADXRS450_Gyro();

    encoder = new Encoder (RobotMap.ENC_IN,RobotMap.ENC_OUT,false,Encoder.EncodingType.k4X);
    encoder.setDistancePerPulse((3.25*Math.PI/128)*(3.25/6));

    gyroPID = new PIDController(gyrokP, gyrokI, gyrokD);
    drivePID = new PIDController(drivekP, drivekI, drivekD);
    //drivePID = new PIDController(NumberConstants.drive_kP, NumberConstants.drive_kI, NumberConstants.drive_kD);
  }
  @Override
  public void initDefaultCommand() 
  {
    setDefaultCommand(new ArcadeDrive());
  }

  public void leftDriveOutput(double forward, double rotation)
  {
    double left = forward - rotation;

    // change negatives and stuff here
    if (left>1){
      leftFront.set(1);
      leftBack.set(1);
    }
    else{
      leftFront.set(left);
      leftBack.set(left);
    }
  }

  public void rightDriveOutput(double forward, double rotation){
    double right = forward + rotation;

    if(right>1){
      rightFront.set(-1);
      rightBack.set(-1);
    }
    else{
      rightFront.set(-right);
      rightBack.set(-right);
    }
  }

  public void rightGearbox(double power){
    rightFront.set(power);
    rightBack.set(power);
  }

  public void leftGearbox(double power){
    leftBack.set(power);
    leftFront.set(power);
  }

  public void stop(){
    leftDriveOutput(0, 0);
    rightDriveOutput(0, 0);
  }
  //Encoder Methods
  public double getEncInTick()
  {
    return encoder.getRaw();
  }
  public void resetEnc(){
    encoder.reset();
  }
  public double findingDist()
  {
    //return encoder.getRaw() / 93.0657;
    return encoder.getDistance();
  }

  // gyro methods

  public double getCurrentAngle(){
    return Gyro.getAngle();
  }

  public void resetGyro(){
    Gyro.reset();
  }

public boolean GyroConnected(){
 return Gyro.isConnected();
}

public boolean atTarget(){
  return drivePID.isDone();
}

public void turnToAngle(double setPoint, double epsilon, double const_multiplier){
  double output = gyroPID.calcPID(setPoint, getCurrentAngle(), epsilon);

  leftGearbox(-output*const_multiplier);
  rightGearbox(-output*const_multiplier);

}

public void driveDistance(double setPoint, double epsilon, double const_multiplier){
  double output = drivePID.calcPID(setPoint, findingDist(), epsilon);

  leftGearbox((-output + (getCurrentAngle()*0.03))*const_multiplier);
  rightGearbox((output - (getCurrentAngle()*0.03))*const_multiplier);
}

public void updateDrivetrainSensors(){
  SmartDashboard.putNumber("GyroAngle", getCurrentAngle());
  SmartDashboard.putBoolean("Gyro Connected", GyroConnected());
  SmartDashboard.putNumber("Encoder in Ticks ", getEncInTick());
  //SmartDashboard.putNumber("key", value)
  SmartDashboard.putBoolean("PID at Target", atTarget());
  SmartDashboard.putNumber("angle!", getCurrentAngle());
  SmartDashboard.putNumber("distance", findingDist());
}

}
