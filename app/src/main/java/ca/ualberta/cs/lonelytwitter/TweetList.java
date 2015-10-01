package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by scheers on 9/30/15.
 */
public class TweetList {


    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();


    public void add(Tweet tweet) {
        //should throw an IllegalArgumentException when one tries to add a duplicate tweet
        if (this.hasTweet(tweet)) {
            throw new IllegalArgumentException("duplicate tweet");
        }
        tweets.add(tweet);



    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int x){
        return tweets.get(x);
    }
}
