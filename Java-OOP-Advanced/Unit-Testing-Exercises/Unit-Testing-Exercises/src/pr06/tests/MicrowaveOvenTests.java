package pr06.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pr06.interfaces.Client;
import pr06.models.MicrowaveOven;

public class MicrowaveOvenTests {

    private Client microwaveOven;

    @Before
    public void initializeTestObjects() {
        this.microwaveOven = new MicrowaveOven("test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorWithNullUsername() {
        this.microwaveOven = new MicrowaveOven(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorWitEmptyUsername() {
        this.microwaveOven = new MicrowaveOven("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSendTweetWhenTweetIsNullThrowsException() {
        this.microwaveOven.sendTweet();
    }
}
