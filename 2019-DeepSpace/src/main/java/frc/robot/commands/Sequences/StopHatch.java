/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.TurnLEDoff;
import frc.robot.commands.HatchCommands.*;

public class StopHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public StopHatch() {
    System.out.println("This is from Stop Hatch");
    
    addSequential(new puncherIn());
    addSequential(new babySharkLetGo());
    addSequential(new sliderIn());
    addParallel(new TurnLEDoff());
    
  }
}
