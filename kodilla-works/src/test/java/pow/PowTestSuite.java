package pow;

import org.junit.Assert;
import org.junit.Test;

public class PowTestSuite {

    @Test
    public void testPowWithPositive() throws AorBlessThanZeroException, AequalsZeroException {
        //Given

        Power power = new Power();
        //When

         double result = power.pow(1,1);

        Assert.assertEquals(1, result, 0);
    }

    @Test(expected = AequalsZeroException.class)
    public void testPowWithAequalZero() throws AorBlessThanZeroException, AequalsZeroException {
        //Given
        Power power = new Power();
        //When

            power.pow(0, 3);

    }

    @Test(expected = AorBlessThanZeroException.class)
    public void testPowWithAorBnegative() throws AorBlessThanZeroException, AequalsZeroException {
        //Given
        Power power = new Power();
        //When
            power.pow(2, -3);

    }
}

