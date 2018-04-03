package pow;

public class Power {

    public double pow(double a, double b) throws AequalsZeroException, AorBlessThanZeroException {

        if(a == 0) {
            throw new AequalsZeroException("a nie moze byc rowne zero");
        }
        else if (a < 0 || b < 0) {
            throw new AorBlessThanZeroException("a i b powinny być dodanie");
        }
        return Math.pow(a, b);
    }
}
