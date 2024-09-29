package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class IntakeTalon implements IntakeIO{

    //do not run this until device numbers have ben figured out
    //if you do i will be very sad :(
    //put device numbers in tankconstants

    //also this relies on percentoutput instead of voltage and speed stuff so uh
    //TODO: fix that

    private TalonSRX FrontLeftMotor = new TalonSRX(IntakeConstants.deviceNumbers.frontLeft);
    private TalonSRX BackLeftMotor = new TalonSRX(IntakeConstants.deviceNumbers.backLeft);
    private TalonSRX FrontRightMotor = new TalonSRX(IntakeConstants.deviceNumbers.frontRight);
    private TalonSRX BackRightMotor = new TalonSRX(IntakeConstants.deviceNumbers.backRight);

    public IntakeTalon()
    {
        FrontLeftMotor.setInverted(true);
        BackLeftMotor.setInverted(true);
    }

    @Override
    public void updateData(TankData data) {
        
        data.leftVolts = FrontLeftMotor.getBusVoltage();
        data.rightVolts = FrontRightMotor.getBusVoltage();
    }

    @Override
    public void setVoltage(double leftTankVolts,double rightTankVolts) 
    {
        FrontLeftMotor.set(TalonSRXControlMode.PercentOutput,leftTankVolts);
        BackLeftMotor.set(TalonSRXControlMode.PercentOutput,leftTankVolts);

        FrontRightMotor.set(TalonSRXControlMode.PercentOutput,rightTankVolts);
        BackRightMotor.set(TalonSRXControlMode.PercentOutput,rightTankVolts);
    }


}
