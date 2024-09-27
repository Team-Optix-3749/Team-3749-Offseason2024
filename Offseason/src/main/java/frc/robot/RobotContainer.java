// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.DriveCommand;

public class RobotContainer {

private final CommandXboxController m_driverController =
      new CommandXboxController(RobotConstants.OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    Robot.TankDrive.setDefaultCommand(new DriveCommand(m_driverController::getLeftY, m_driverController::getRightY)); 
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
