// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticsSubsystem;

public class PneumaticsCommand extends CommandBase {
  private final PneumaticsSubsystem m_pneumatics;
  private final int m_setPosition; // 0: Forward, 1: Reverse

  public PneumaticsCommand(PneumaticsSubsystem pneumatics, int setPosition) {
    m_pneumatics = pneumatics;
    m_setPosition = setPosition;
    addRequirements(m_pneumatics);
  }

  @Override
  public void initialize() {
    if (m_setPosition == 0) {
      m_pneumatics.forward();
    } else {
      m_pneumatics.reverse();
    }
  }

}
