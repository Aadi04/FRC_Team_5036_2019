/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Sequences;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.CargoIntake.*;

public class intakeSequence extends CommandGroup {

  public intakeSequence() {
    addSequential(new armOut());
    addSequential(new runIntake());
    addSequential(new StopIntake());
    addSequential(new armIn());
    cancel();
  }
}