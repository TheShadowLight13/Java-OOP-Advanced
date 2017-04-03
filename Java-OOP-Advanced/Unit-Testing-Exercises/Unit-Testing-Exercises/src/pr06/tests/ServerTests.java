package pr06.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pr06.interfaces.Database;
import pr06.interfaces.Message;
import pr06.models.Server;
import pr06.models.Tweet;

public class ServerTests {

    private Database database;

    @Before
    public void initializeTestObjects() {
        this.database = new Server();
    }

    @Test
    public void testEmptyCtor() {
        Assert.assertEquals(0, this.database.getAllMessage().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToDatabaseNullThrowsException() {
        this.database.addToDatabase(null);
    }

    @Test
    public void testAddToDatabaseMessage() {
        Message tweet = new Tweet("test", "haha");
        this.database.addToDatabase(tweet);

        Message tweetFromDB = this.database.getAllMessage().get(0);

        Assert.assertTrue(
                tweetFromDB.retrieveMessage().equals("test") &&
                        tweetFromDB.retrieveAuthorUsername().equals("haha")
        );
    }

    @Test
    public void testGetAllMessage() {
        Assert.assertEquals(0, this.database.getAllMessage().size());
    }
}
