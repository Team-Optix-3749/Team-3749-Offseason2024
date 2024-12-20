package frc.robot.subsystems.tank;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import frc.robot.RobotConstants;

public class TankSim implements TankIO {
    private FlywheelSim leftMotor = new FlywheelSim(DCMotor.getCIM(2), TankConstants.gearing, 0.04);
    private FlywheelSim rightMotor = new FlywheelSim(DCMotor.getCIM(2), TankConstants.gearing, 0.04);

    private double leftAppliedVolts = 0.0;
    private double rightAppliedVolts = 0.0;

    boolean leftInverted = TankConstants.inversion[0];
    boolean rightInverted = TankConstants.inversion[1];

    public TankSim() {

    }

    @Override
    public void updateData(TankData data) {
        leftMotor.update(RobotConstants.Sim.loopPeriodSec);
        rightMotor.update(RobotConstants.Sim.loopPeriodSec);

        data.leftVolts = leftAppliedVolts;
        data.rightVolts = rightAppliedVolts;
    }

    @Override
    public void setVoltage(double leftTankVolts, double rightTankVolts) {
        leftAppliedVolts = leftTankVolts;
        rightAppliedVolts = rightTankVolts;
        leftMotor.setInputVoltage(leftAppliedVolts * (leftInverted ? -1 : 1));
        rightMotor.setInputVoltage(rightAppliedVolts * (rightInverted ? -1 : 1));
    }

    @Override
    public void setLeftVoltage(double leftTankVolts) {
        double appliedVolts = MathUtil.clamp(leftTankVolts, -TankConstants.maxVoltage, TankConstants.maxVoltage);
        leftAppliedVolts = appliedVolts;

        leftMotor.setInputVoltage(appliedVolts * (leftInverted ? -1 : 1));
    }

    @Override
    public void setRightVoltage(double rightTankVolts) {
        double appliedVolts = MathUtil.clamp(rightTankVolts, -TankConstants.maxVoltage, TankConstants.maxVoltage);
        rightAppliedVolts = appliedVolts;

        rightMotor.setInputVoltage(appliedVolts * (rightInverted ? -1 : 1));
    }
}