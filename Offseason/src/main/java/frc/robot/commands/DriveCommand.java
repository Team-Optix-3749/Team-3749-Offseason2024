package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.tank.Tank;

import java.util.function.DoubleSupplier;

public class DriveCommand extends Command {
    Tank tank = Robot.TankDrive;

    private DoubleSupplier joystickX;
    private DoubleSupplier joystickY;

    public DriveCommand(DoubleSupplier joystickX, DoubleSupplier joystickY) {
        this.joystickX = joystickX;
        this.joystickY = joystickY;
        addRequirements(Robot.TankDrive);
    }

    @Override
    public void execute() {
        double joystickX = this.joystickX.getAsDouble();
        double joystickY = this.joystickY.getAsDouble();

        // Log out joystick positions
        SmartDashboard.putNumber("Joystick X", joystickX);
        SmartDashboard.putNumber("Joystick Y", joystickY);

        tank.drivetrain.arcadeDrive(joystickX, joystickY);
    }

    @Override
    public void end(boolean interrupted) {
        tank.stopModules();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}