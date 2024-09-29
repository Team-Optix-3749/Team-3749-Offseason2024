package frc.robot.subsystems.tank;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import frc.robot.RobotConstants;

public class TankSim implements TankIO
{
    private FlywheelSim leftMotor = new FlywheelSim(DCMotor.getNEO(2),1,0.04);
    private FlywheelSim rightMotor = new FlywheelSim(DCMotor.getNEO(2),1,0.04);

    private double leftGoalVolts = 0;
    private double rightGoalVolts = 0;

    public TankSim()
    {

    }

    @Override
    public void updateData(TankData data) {
        leftMotor.update(RobotConstants.Sim.loopPeriodSec);
        rightMotor.update(RobotConstants.Sim.loopPeriodSec);
        
        data.leftVolts = leftGoalVolts;
        data.rightVolts = rightGoalVolts;
    }

    @Override
    public void setVoltage(double leftTankVolts,double rightTankVolts) {
        leftGoalVolts = leftTankVolts;
        rightGoalVolts = rightTankVolts;
        leftMotor.setInputVoltage(leftGoalVolts);
        rightMotor.setInputVoltage(rightGoalVolts);
    }

}
