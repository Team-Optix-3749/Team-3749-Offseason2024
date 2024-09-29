package frc.robot.subsystems.intake;

public interface IntakeIO {
    public static class TankData {
        public double leftVolts = 0.0; 
        public double rightVolts = 0.0;
        public double leftVelocityRadPerSec = 0.0;
        public double rightVelocityRadPerSec = 0.0;
        //because we are feeding the same voltage into the 2 left motors/right motors this should be fine
        //if not uhhhhh

        /* 
        public double tankTempCelcius = 0.0;
        public double tankCurrentAmps = 0.0; 
        lets figure out what to do about this at some point
        */
    }
    /** Updates the set of loggable inputs. */
    public default void updateData(TankData data) {

    }

    /** Run the drive motor at the specified voltage. */
    public default void setVoltage(double leftTankVolts, double rightTankVolts) 
    {
        
    }

    /** Enable or disable brake mode on the drive motor. */
    public default void setBrakeMode(boolean enable) {
    }

}