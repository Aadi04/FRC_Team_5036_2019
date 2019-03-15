/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
//import sun.tools.jconsole.inspector.OperationEntry;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.CargoIntake.*;
import frc.robot.commands.*;
import frc.robot.commands.HatchCommands.*;
import frc.robot.commands.Sequences.*;
import frc.robot.commands.Auto.*;
import frc.robot.commands.TimerDelayOutTake;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
  public Joystick driverController = new Joystick(RobotMap.DRIVER_PORT);
  public Joystick operatorController = new Joystick(RobotMap.OPERATOR_PORT);

 
  private Button forceStopIntake = new JoystickButton(operatorController, 8); // start button
  private Button fullintakeSequence = new JoystickButton(operatorController, 6); // right trigger
  
  
   private Button sliderIn =  new JoystickButton(operatorController, 2); //b button
   private Button sliderOut = new JoystickButton(operatorController, 3); //x button

   private Button scoreHatchSequence = new JoystickButton(driverController, 6); // left trigger pressed
   private Button forceStopHatch = new JoystickButton(driverController, 6); // left trigger released

   private Button scoreBall = new JoystickButton(driverController, 5);

   //private Button tunePID = new JoystickButton(driverController, 6);
   private Button reverseSeq = new JoystickButton(operatorController, 4);
   private Button allPuncherOut = new JoystickButton(operatorController, 5);// Left trigger Pressed
   private Button allPuncherIn = new JoystickButton(operatorController, 5);// Left Trigger Released
   private POVButton autoButton = new POVButton(operatorController, 0);


  public OI()
  {
   // INTAKE
    this.fullintakeSequence.whenPressed(new intakeSequence());
    this.forceStopIntake.whenPressed(new stopIntakeSequence());
    this. reverseSeq.whenPressed(new reverseSeq());
    //Hatch
    this.sliderIn.whenPressed(new SliderInAndLED());
    this.sliderOut.whenPressed(new SliderOutAndLED());

    this.scoreHatchSequence.whenPressed(new ScoreHatch());
    this.forceStopHatch.whenReleased(new StopHatch());

    this.scoreBall.whenPressed(new TimerDelayOutTake());
    this.allPuncherOut.whenPressed(new allPusherOut());
    this.allPuncherIn.whenReleased(new allPusherIn());

    //this.autoButton.whenPressed(command);
    //this.tunePID.whenPressed(new changePIDConstants());
    //this.tunePID.whenPressed(new TurnToAnlge(90, 0.5, 0.7));

    //this.tunePID.whenPressed(new driveDistance(-100,1,0.5));
  }
  
 

//Driver Methods
  public double getForward(){
    double forward = driverController.getRawAxis(1);

    // deadband correction (cause not all joysticks center to 0)
    if (Math.abs(forward)<0.03)
      return 0.0;
    else 
      return forward;
  }

  public double getRotate()
  {
    double rotate = driverController.getRawAxis(4);

    if (Math.abs(rotate * 0.4)<0.03) // Get Rid of the mutiply
      return 0.0;
    else 
      return rotate;
  }
  public double getThrottle()
  {
    return driverController.getRawAxis(2);
    
  }
}

