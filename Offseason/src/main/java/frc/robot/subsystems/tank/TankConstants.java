package frc.robot.subsystems.tank;

public class TankConstants {
    public static class MotorIDs {
        public static int frontLeft = 0;
        public static int frontRight = 1;
        public static int backLeft = 2;
        public static int backRight = 3;
    }

    public static boolean[] inversion = { false, false };

    public static double deadband = 0.08;

    public static double gearing = 1;

    public static double maxVoltage = 12.0;
}
