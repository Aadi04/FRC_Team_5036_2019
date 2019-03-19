/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.HatchCommands.babySharkHold;
import frc.robot.commands.HatchCommands.sliderOut;

public class allPusherOut extends CommandGroup {
  /**
   * Add your docs here.
   */
  public allPusherOut() {
    addSequential(new sliderOut());
    addParallel(new babySharkHold());
    cancel();
  }
}
