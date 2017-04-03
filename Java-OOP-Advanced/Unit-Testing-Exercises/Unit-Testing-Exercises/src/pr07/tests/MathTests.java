package pr07.tests;

import org.junit.Assert;
import org.junit.Test;

public class MathTests {

    @Test
    public void testMathAbsWithNegativeWholeValue() {
        Assert.assertEquals(1, Math.abs(-1));
    }

    @Test
    public void testMathAbsWithPositiveWholeValue() {
        Assert.assertEquals(20, Math.abs(20));
    }

    @Test
    public void testMathAbsWithZeroValue() {
        Assert.assertEquals(0, Math.abs(0));
    }

    @Test
    public void testMathAbsWithNegativeFloatingPointNumber() {
        Assert.assertEquals(1.2, Math.abs(-1.2), 0.0001);
    }

    @Test
    public void testMathAbsWithPositiveFloatingPointNumber() {
        Assert.assertEquals(2.56, Math.abs(2.56), 0.0001);
    }

    @Test
    public void testMathFloorWithZeroValue() {
        Assert.assertEquals(0, Math.floor(0), 0.0001);
    }

    @Test
    public void testMathFloorWithNegativeFloatingPointValue() {
        Assert.assertEquals(-2, Math.floor(-1.234), 0.0001);
    }

    @Test
    public void testMathFloorWithPositiveFloatingPointValue() {
        Assert.assertEquals(20, Math.floor(20.2345), 0.0001);
    }

    @Test
    public void testMathFloorWithNegativeWholeValue() {
        Assert.assertEquals(-1, Math.floor(-1), 0.0001);
    }

    @Test
    public void testMathFloorWithPositiveWholeValue() {
        Assert.assertEquals(20, Math.floor(20), 0.0001);
    }
}
