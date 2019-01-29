/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // Drivetrain Motors - Victor SP

  public static final int DRIVE_RIGHT_FRONT = 1;
  public static final int DRIVE_RIGHT_BACK = 2;
  public static final int DRIVE_LEFT_FRONT = 3;
  public static final int DRIVE_LEFT_BACK = 4;

  //controller ports
  public static final int DRIVER_PORT = 0;
  public static final int OPERATOR_PORT = 1;
}