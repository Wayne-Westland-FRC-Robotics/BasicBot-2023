// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.GeneralConstants;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.DrivetrainCommand;
import frc.robot.commands.PneumaticsCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;

public class RobotContainer {
  private final DrivetrainSubsystem m_drivetrain = new DrivetrainSubsystem();
  private final ArmSubsystem m_arm = new ArmSubsystem();
  private final PneumaticsSubsystem m_pneumatics = new PneumaticsSubsystem();
  
  private final CommandXboxController m_driverController = new CommandXboxController(
    GeneralConstants.DRIVER_CONTROLLER_ID
  );
  private final CommandXboxController m_operatorController = new CommandXboxController(
    GeneralConstants.OPERATOR_CONTROLLER_ID
  );

  public RobotContainer() {
    m_drivetrain.setDefaultCommand(
      new DrivetrainCommand(m_drivetrain, m_driverController::getLeftY, m_driverController::getRightY)
    );
    
    configureBindings();
  }

  private void configureBindings() {
    m_operatorController.a().whileTrue(new ArmCommand(m_arm, ArmConstants.ARM_SPEED));
    m_operatorController.b().whileTrue(new ArmCommand(m_arm, -ArmConstants.ARM_SPEED));

    m_operatorController.x().onTrue(new PneumaticsCommand(m_pneumatics, 0));
    m_operatorController.y().onTrue(new PneumaticsCommand(m_pneumatics, 1));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
