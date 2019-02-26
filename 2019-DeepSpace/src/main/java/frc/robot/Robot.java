/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Utils.NumberConstants;
import frc.robot.commands.Sequences.intakeSequence;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hatch;
import frc.robot.subsystems.Intake;
import frc.robot.commands.Auto.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveTrain m_DriveTrain = new DriveTrain();
  public static Conveyor m_conveyor = new Conveyor();
  public static Intake m_intake = new Intake();
  public static OI m_oi;
  public static Hatch m_hatch = new Hatch();
  Compressor compressor;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  CommandGroup intakeSequence;

  Preferences pref;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    updateSmartDashboard();
    CameraServer.getInstance().startAutomaticCapture();
    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    m_chooser.setDefaultOption("DO NOTHING", new DoNothingAuto());
    m_chooser.addOption("Right 1 Hatch", new Right1Hatch());
    m_chooser.addOption("Left 1 Hatch", new Left1Hatch());
    SmartDashboard.putData("Auto mode", m_chooser);
    compressor = new Compressor();
    //NumberConstants.drive_kD = pref.getDouble("drive kD", 0.1);
    //NumberConstants.drive_kI = pref.getDouble("drive kI", 0.03);
    //NumberConstants.drive_kP = pref.getDouble("drive kP", 0.12);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    if (m_autonomousCommand != null) {
     m_autonomousCommand.cancel();
   }
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
    updateSmartDashboard();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
   if (m_autonomousCommand != null) {
     m_autonomousCommand.start();
   }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
   Scheduler.getInstance().run();
    // updateSmartDashboard();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null){
      m_autonomousCommand.cancel();
    }
    compressor.start();

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    updateSmartDashboard();

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    updateSmartDashboard();
  }

  public void updateSmartDashboard(){
    Robot.m_DriveTrain.updateDrivetrainSensors();
    Robot.m_conveyor.updateConveyor();
    SmartDashboard.putNumber("kP", Robot.m_DriveTrain.drivekP);
    SmartDashboard.putNumber("kI", Robot.m_DriveTrain.drivekI);
    SmartDashboard.putNumber("kD", Robot.m_DriveTrain.drivekD);
    SmartDashboard.putNumber("Setpoint", Robot.m_DriveTrain.setPoint);
  }

public static void m_conveyor(double throttle) {
}
}
