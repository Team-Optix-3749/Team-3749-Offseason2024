package frc.robot.subsystems.tank;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface TankIO {
    public static class TankData {
        public double leftVolts = 0.0; 
        public double rightVolts = 0.0;
        public double leftVelocityRadPerSec = 0.0;
        public double rightVelocityRadPerSec = 0.0;
    }

    MotorController setLeftVoltage = null;
    /** Updates the set of loggable inputs. */
    public default void updateData(TankData data) {

    }

    /** Run the drive motor at the specified voltage. */
    public default void setVoltage(double leftTankVolts, double rightTankVolts) 
    {
        
    }

    public default void setLeftVoltage(double leftTankVolts) 
    {
        
    }

    public default void setRightVoltage(double rightTankVolts) 
    {
        
    }

    /** Enable or disable brake mode on the drive motor. */
    public default void setBrakeMode(boolean enable) {
    }

}