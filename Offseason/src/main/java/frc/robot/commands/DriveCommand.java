package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.tank.Tank;
import java.sql.Driver;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import frc.robot.Robot;

/***
 * @author Noah Simon
 * @author Raadwan Masum
 * @author Rohin Sood
 *         Default command to control the SwervedriveSubsystem with joysticks
 */

public class DriveCommand extends Command {

   private DoubleSupplier leftSpeed;
    private DoubleSupplier rightSpeed;

    public DriveCommand(DoubleSupplier leftSpeed, DoubleSupplier rightSpeed)
    {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        addRequirements(Robot.TankDrive);
    }

    @Override
    public void execute() {
        Robot.TankDrive.setVoltage(leftSpeed.getAsDouble(),rightSpeed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        Robot.TankDrive.stopModules();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}