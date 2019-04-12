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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.*;

/**
 * Add your docs here.
 */
public class NewHatchMech extends Subsystem{

   public VictorSP intake;
   public DigitalInput limitswitch1, limitswitch2;
   public static Conveyor conveyor = Robot.m_conveyor;
   

   public NewHatchMech()
   {
       intake = new VictorSP(RobotMap.HATCH_INTAKE);
       limitswitch1 = new DigitalInput(RobotMap.LIMITSWITCH_1);
       limitswitch2 = new DigitalInput(RobotMap.LIMITSWITCH_2);
   }
   public void runIntake(double power)
   {
        System.out.println("This is settting the power");
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
        if (LimitSwitch1() == false && LimitSwitch2() == false)
        {
            conveyor.ledOn(1);
        }
        else 
        {
             conveyor.ledOff(0);
        }
   }
   public void updateHatchMech()
   {
        SmartDashboard.getBoolean("LimitSwitch1", LimitSwitch1());
        SmartDashboard.getBoolean("LimitSwitch2",LimitSwitch2());
   }
   
    @Override
    protected void initDefaultCommand() 
    {

    }

}
