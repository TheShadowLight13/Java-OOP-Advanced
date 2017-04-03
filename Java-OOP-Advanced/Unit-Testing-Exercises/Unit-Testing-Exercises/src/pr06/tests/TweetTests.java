package pr06.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pr06.interfaces.Message;
import pr06.models.Tweet;

public class TweetTests {

    private Message tweet;

    @Before
    public void initializeTestObjects() {
        this.tweet = new Tweet("test", "haho");
    }

    @Test
    public void testCtorWithMessageAndUsername() {
        Assert.assertTrue(
                this.tweet.retrieveMessage().equals("test") &&
                this.tweet.retrieveAuthorUsername().equals("haho")
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorWithNullMessageAndValidUsername() {
        this.tweet = new Tweet(null, "haho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorWithValidMessageAndNullUsername() {
        this.tweet = new Tweet("test", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorWithEmptyMessageAndValidUsername() {
        this.tweet = new Tweet("", "haho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorWithValidMessageAndEmptyUsername() {
        this.tweet = new Tweet("test", "");
    }

    @Test
    public void testRetrieveMessage() {
        Assert.assertEquals(
                "Wrong message", "test", this.tweet.retrieveMessage());
    }

    @Test
    public void testRetrieveAuthorUsername() {
        Assert.assertEquals(
                "Wrong username", "haho", this.tweet.retrieveAuthorUsername());
    }
}
