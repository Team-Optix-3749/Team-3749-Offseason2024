package frc.robot.subsystems.tank;

public interface TankIO {
    public static class TankData {
        public double tankVolts = 0.0;
        public double tankVelocityRadPerSec = 0.0;
        public double tankTempCelcius = 0.0;
        public double tankCurrentAmps = 0.0;
    }
    /** Updates the set of loggable inputs. */
    public default void updateData(TankData data) {

    }

    /** Run the drive motor at the specified voltage. */
    public default void setVoltage(double tankVolts) 
    {
        
    }

    /** Enable or disable brake mode on the drive motor. */
    public default void setBrakeMode(boolean enable) {
    }

}