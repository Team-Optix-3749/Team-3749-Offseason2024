// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.tank;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Robot;
import frc.robot.subsystems.tank.TankIO.TankData;

public class Tank extends SubsystemBase {
    private TankIO tankIO;
    private TankData tankData = new TankData();
    public DifferentialDrive drivetrain;

    public Tank() {
        tankIO = new TankTalon();
        if (Robot.isSimulation()) {
            tankIO = new TankSim();
        }

        drivetrain = new DifferentialDrive(
                (double v) -> tankIO.setLeftVoltage(v * -1), // diff drive automatically inverts voltages on left
                tankIO::setRightVoltage);
        drivetrain.setDeadband(TankConstants.deadband);

        drivetrain.setMaxOutput(12);
    }

    public void stopModules() {
        drivetrain.arcadeDrive(0, 0);
    }

    public double[] getVoltage() {
        double[] data = { tankData.leftVolts, tankData.rightVolts };
        return data;
    }

    @Override
    public void periodic() {
        tankIO.updateData(tankData);

        SmartDashboard.putNumber("tank/Left Voltage", tankData.leftVolts);
        SmartDashboard.putNumber("tank/Right Voltage", tankData.rightVolts);
    }
}