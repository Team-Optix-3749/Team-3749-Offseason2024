package frc.robot.subsystems.tank;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.MathUtil;

public class TankTalon implements TankIO {
    private TalonSRX frontLeftMotor = new TalonSRX(TankConstants.MotorIDs.frontLeft);
    private TalonSRX backLeftMotor = new TalonSRX(TankConstants.MotorIDs.backLeft);
    private TalonSRX frontRightMotor = new TalonSRX(TankConstants.MotorIDs.frontRight);
    private TalonSRX backRightMotor = new TalonSRX(TankConstants.MotorIDs.backRight);

    public TankTalon() {
        frontLeftMotor.setInverted(true);
        backLeftMotor.setInverted(true);

        frontLeftMotor.setNeutralMode(NeutralMode.Brake);
        frontRightMotor.setNeutralMode(NeutralMode.Brake);
        backLeftMotor.setNeutralMode(NeutralMode.Brake);
        backRightMotor.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void updateData(TankData data) {
        data.leftVolts = frontLeftMotor.getBusVoltage();
        data.rightVolts = frontRightMotor.getBusVoltage();

        //! Likely DOES NOT WORK! This is copilot code, check docs for how to actually get speed
        data.leftVelocityRadPerSec = frontLeftMotor.getSelectedSensorVelocity() * 2 * Math.PI / 4096;
        data.rightVelocityRadPerSec = frontRightMotor.getSelectedSensorVelocity() * 2 * Math.PI / 4096;
    }

    @Override
    public void setVoltage(double leftTankVolts, double rightTankVolts) {
        double percentOutput_l = leftTankVolts / TankConstants.maxVoltage;
        double percentOutput_r = rightTankVolts / TankConstants.maxVoltage;

        percentOutput_l = MathUtil.clamp(percentOutput_l, -1, 1);
        percentOutput_r = MathUtil.clamp(percentOutput_r, -1, 1);

        frontLeftMotor.set(TalonSRXControlMode.PercentOutput, percentOutput_l);
        backLeftMotor.set(TalonSRXControlMode.PercentOutput, percentOutput_l);

        frontRightMotor.set(TalonSRXControlMode.PercentOutput, percentOutput_r);
        backRightMotor.set(TalonSRXControlMode.PercentOutput, percentOutput_r);
    }

    @Override
    public void setLeftVoltage(double leftTankVolts) {
        double percentOutput = leftTankVolts / TankConstants.maxVoltage;

        percentOutput = MathUtil.clamp(percentOutput, -1, 1);

        frontLeftMotor.set(TalonSRXControlMode.PercentOutput, leftTankVolts);
        backLeftMotor.set(TalonSRXControlMode.PercentOutput, leftTankVolts);
    }

    @Override
    public void setRightVoltage(double rightTankVolts) {
        double percentOutput = rightTankVolts / TankConstants.maxVoltage;

        percentOutput = MathUtil.clamp(percentOutput, -1, 1);

        frontRightMotor.set(TalonSRXControlMode.PercentOutput, rightTankVolts);
        backRightMotor.set(TalonSRXControlMode.PercentOutput, rightTankVolts);
    }
}
