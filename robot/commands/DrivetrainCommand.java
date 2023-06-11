// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DrivetrainCommand extends CommandBase {
  private final DrivetrainSubsystem m_drivetrain;
  private final DoubleSupplier m_leftSpeed;
  private final DoubleSupplier m_rightSpeed;

  public DrivetrainCommand(DrivetrainSubsystem drivetrain, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
    m_drivetrain = drivetrain;
    m_leftSpeed = leftSpeed;
    m_rightSpeed = rightSpeed;
    addRequirements(m_drivetrain);
  }

  @Override
  public void execute() {
    m_drivetrain.drive(m_leftSpeed.getAsDouble(), m_rightSpeed.getAsDouble());
  }
}
