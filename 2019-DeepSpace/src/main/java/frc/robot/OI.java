/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
  public Joystick driverController = new Joystick(RobotMap.DRIVER_PORT);
  public Joystick operatorController = new Joystick(RobotMap.OPERATOR_PORT);


  public OI(){
  // link buttons to commands here
  }

  public double getForward(){
    double forward = driverController.getRawAxis(1);

    // deadband correction (cause not all joysticks center to 0)
    if (Math.abs(forward)<0.05)
      return 0.0;
    else 
      return forward;
  }

  public double getRotate(){
    double rotate = driverController.getRawAxis(4);

    if (Math.abs(rotate)<0.05)
      return 0.0;
    else 
      return rotate;
    }
}
