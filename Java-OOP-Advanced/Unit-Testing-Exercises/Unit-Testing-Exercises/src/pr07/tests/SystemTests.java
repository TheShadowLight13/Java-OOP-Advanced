package pr07.tests;

import org.junit.Assert;
import org.junit.Test;

public class SystemTests {

    @Test
    public void testLineSeparatorWorksFine() {
        String separator = System.lineSeparator();
        Assert.assertEquals("\r\n", separator);
    }
}
