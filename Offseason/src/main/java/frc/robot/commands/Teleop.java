package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

/***
 * @author Noah Simon
 * @author Raadwan Masum
 * @author Rohin Sood
 *         Default command to control the SwervedriveSubsystem with joysticks
 */

public class Teleop extends Command {

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        
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