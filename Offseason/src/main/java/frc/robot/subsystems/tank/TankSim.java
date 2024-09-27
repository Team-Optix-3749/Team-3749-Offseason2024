package frc.robot.subsystems.tank;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import frc.robot.RobotConstants;

public class TankSim implements TankIO
{
    private FlywheelSim frontLeft = new FlywheelSim(DCMotor.getNEO(1),1,0.04);
    private FlywheelSim backLeft = new FlywheelSim(DCMotor.getNEO(1),1,0.04);
    private FlywheelSim frontRight = new FlywheelSim(DCMotor.getNEO(1),1,0.04);
    private FlywheelSim backRight = new FlywheelSim(DCMotor.getNEO(1),1,0.04);

    public TankSim()
    {

    }

    @Override
    public void updateData(TankData data) {
        frontLeft.update(RobotConstants.Sim.loopPeriodSec);
        backLeft.update(RobotConstants.Sim.loopPeriodSec);
        backRight.update(RobotConstants.Sim.loopPeriodSec);
        frontRight.update(RobotConstants.Sim.loopPeriodSec);
    }

    @Override
    public void setVoltage(double tankVolts) {
        frontLeft.setInputVoltage(tankVolts);
    }

}
