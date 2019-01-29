package frc.robot.Utils;

//can be used for position calculations (gyro + encoder)
public class PIDController{

    double pGain;
    double iGain;
    double dGain;

    double pOut;
    double iOut;
    double dOut;

    double error;
    double errorSum = 0;
    double lastError = 0;

    double dProccessVar;

    double output = 0;

    boolean atTarget = false;

    public PIDController( double p, double i, double d){
        errorSum = 0;
		lastError = 0;
		pGain = p;
		iGain = i;
		dGain = d;
    }

    public double calcPID(double setPoint, double currentValue, double epsilon){
        error = setPoint - currentValue;

        if (Math.abs(error)<= epsilon){
            atTarget = true;
        } else{
            atTarget = false;
        }

        // P
        pOut = pGain * error;

        // I
        errorSum += error;
        iOut = iGain * errorSum;

        // D
        dProccessVar = error - lastError;
        dOut = dGain * dProccessVar;
        lastError = error;

        output = pOut + iOut + dOut;

        if (output != 0.0){
            output = output/Math.abs(output) * (1.0-Math.pow(0.1, Math.abs(output)));
        }

        return output;
    }

    public void resetPID(){
        errorSum = 0;
        lastError = 0.0;
        atTarget = false;
    }

    public boolean isDone(){
        return atTarget;
    }
}