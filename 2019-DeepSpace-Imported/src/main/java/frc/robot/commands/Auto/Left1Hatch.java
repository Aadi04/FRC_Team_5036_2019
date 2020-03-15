/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class Left1Hatch extends CommandGroup {
 
  public Left1Hatch() {
    addSequential(new driveDistance(10, 2, 0.7));
    addSequential(new TurnToAnlge(-90, 1, 0.7));
    addSequential(new driveDistance(2, 2, 0.7));
    addSequential(new TurnToAnlge(90, 1, 0.7));
    addSequential(new driveDistance(10, 2, 0.7));
    // addSequential(new ScoreHatch());
    // addSequential(new StopHatch());
    addSequential(new driveDistance(-10, 2, 0.7));
  }
}
