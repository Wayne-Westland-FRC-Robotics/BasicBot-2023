// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ArmCommand extends CommandBase {
  private final ArmSubsystem m_arm;
  private final Double m_speed;
  
  public ArmCommand(ArmSubsystem arm, Double speed) {
    m_arm = arm;
    m_speed = speed;
    addRequirements(m_arm);
  }

  @Override
  public void execute() {
    m_arm.move(m_speed);
  }

  @Override
  public void end(boolean interrupted) {
    m_arm.move(0.0);
  }
}
