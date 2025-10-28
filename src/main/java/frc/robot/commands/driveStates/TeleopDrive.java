package frc.robot.commands.driveStates;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.drive.Drivetrain;
import frc.robot.util.DrivetrainPublisher;

/**
 * basic teleop drive command that sets drivetrain inputs based on controller joysticks
 * Field centric control
 */
public class TeleopDrive extends Command {

    public TeleopDrive() {
        DrivetrainPublisher.setSuppliers(Robot.driverController::getLeftX,
                Robot.driverController::getLeftY,
                Robot.driverController::getRightX,
                () -> true
        );
        DrivetrainPublisher.setAcceptInputsSupplier(() -> true);

        addRequirements(Robot.drivetrain);
    }

    @Override
    public boolean isFinished() {
        return true;
   }

    @Override
    public boolean runsWhenDisabled() {
        return true;
   }
}
