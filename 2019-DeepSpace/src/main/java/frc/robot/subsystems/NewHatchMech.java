/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class NewHatchMech extends Subsystem{

   public VictorSP intake;
   public DigitalInput limitswitch1, limitswitch2;
   public Spark LED;

   public NewHatchMech()
   {
       intake = new VictorSP(RobotMap.HATCH_INTAKE);
       limitswitch1 = new DigitalInput(RobotMap.LIMITSWITCH_1);
       limitswitch2 = new DigitalInput(RobotMap.LIMITSWITCH_2);
       LED = new Spark(RobotMap.LED);
   }
   public void runIntake(double power)
   {
        intake.set(power);
   }
   public boolean LimitSwitch1()
   {
        return limitswitch1.get();
    }
   public boolean LimitSwitch2()
   {
        return limitswitch2.get();
   }
   public void LEDS()
   {
        if (LimitSwitch1() == true && LimitSwitch2() == true)
        {
             LED.set(1);
        }
        else 
        {
             LED.set(0);
        }
   }
   
    @Override
    protected void initDefaultCommand() 
    {

    }

}
