// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.tank;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.*;
import edu.wpi.first.math.kinematics.*;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Robot;
import frc.robot.subsystems.tank.TankIO.TankData;

public class Tank extends SubsystemBase {
    private TankIO tankIO;
    private TankData tankData = new TankData();
   
    public Tank()
    {
        tankIO = new TankTalon();
        if(Robot.isSimulation())
        {
            tankIO = new TankSim();
        }
    }

    public void stopModules()
    {

    }

    public void setVoltage(double leftVoltage, double rightVoltage)
    {
        tankIO.setVoltage(leftVoltage,rightVoltage);
    }

    public double[] getVoltage()
    {
        double[] data = {tankData.leftVolts,tankData.rightVolts};
        return data;
    }

    @Override
    public void periodic() {
        tankIO.updateData(tankData);
        SmartDashboard.putNumber("leftVoltage", getVoltage()[0]);
        SmartDashboard.putNumber("rightVoltage", getVoltage()[1]);
    }
}