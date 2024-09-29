package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import java.util.function.DoubleSupplier;

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
        double finalLeft = Math.abs(leftSpeed.getAsDouble()) < 0.1 ? 0 : leftSpeed.getAsDouble();
        double finalRight = Math.abs(rightSpeed.getAsDouble()) < 0.1 ? 0 : rightSpeed.getAsDouble();
        Robot.TankDrive.setVoltage(finalLeft,finalRight);
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