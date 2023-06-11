// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private final CANSparkMax m_armMotor = new CANSparkMax(5, MotorType.kBrushless);

  private final RelativeEncoder m_encoder = m_armMotor.getEncoder();

  public ArmSubsystem() {
    m_armMotor.setIdleMode(IdleMode.kBrake);
  }
  
  public void move(Double speed) {
    m_armMotor.set(speed);
  }

  public Double getEncoderValue() {
    return m_encoder.getPosition();
  }
}
