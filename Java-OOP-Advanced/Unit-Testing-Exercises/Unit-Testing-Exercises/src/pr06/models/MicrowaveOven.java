package pr06.models;

import pr06.interfaces.Client;
import pr06.interfaces.Database;
import pr06.interfaces.Message;

public class MicrowaveOven implements Client{

    private String username;
    private Message tweet;
    private Database connectedDatabase;

    public MicrowaveOven(String username) {
        this.setUsername(username);
        this.connectedDatabase = new Server();
    }

    private void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.username = username;
    }

    @Override
    public void createTweet(String message) {
        Message newTweet = new Tweet(message, this.username);
        this.tweet = newTweet;
    }

    @Override
    public void sendTweet() {
        if (this.tweet == null) {
            throw new IllegalArgumentException();
        }

        // First print message on console
        System.out.println(this.tweet.retrieveMessage());
        // Finally addToDatabase message to database
        this.connectedDatabase.addToDatabase(this.tweet);
    }
}
