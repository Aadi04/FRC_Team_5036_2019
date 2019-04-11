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

  //Victor SPX
  public static final int CONVEYOR1 = 5;
  public static final int CONVEYOR2 = 6;
  public static final int INTAKE = 7;

  // SPARK (IDK WHY WE DONT JUST USE A RELAY)
  public static final int LED = 0;

  //Intake Pistons 
  public static final int LEFT_PISTON_IN = 4; 
  public static final int LEFT_PISTON_OUT = 0;
  //Hatch Pistons
  public static final int PUNCHER_IN = 6;
  public static final int PUNCHER_OUT = 2;
  public static final int SLIDER_IN = 5;
  public static final int SLIDER_OUT= 1;
  public static final int BABY_SHARK_IN = 3;
  public static final int BABY_SHARK_OUT = 7;

  // new hatch mech
  public static final int HATCH_INTAKE = 9; //Needs to be changed
  


  //Sensors
  public static final int ENC_IN = 0;
  public static final int ENC_OUT = 1;

  public static final int LIMITSWITCH_1 = 5; //Needs to be Changed
  public static final int LIMITSWITCH_2 = 2; //Needs to be Changed

  public static final int BUTTON_SENSOR = 4; 
  public static final int BUTTON_SENSOR_1 = 6; // Needs to be Changed 
  public static final int BUTTON_SENSOR_2 = 7; //Needs to be Changed 

}
