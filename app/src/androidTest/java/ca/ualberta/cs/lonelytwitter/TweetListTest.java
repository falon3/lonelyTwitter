package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Created by scheers on 9/30/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    // public something myHelperForTesting()

    public void testDeleteTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihhi");
        tweetList.add(tweet);
        tweetList.delete(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }


    public void testHasTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihhi");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testAddTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihhi");
        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));
        try {
            tweetList.add(tweet);
            assertTrue(false);
        }
        catch(IllegalArgumentException e) {
            System.out.println("Duplicate Tweet!");
        }
        //tweetList.add(tweet); // test to fail: should throw an IllegalArgumentException when one tries to add a duplicate tweet

    }

    public void testTweetCount(){

    }

    public void testGetTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihhi");
        tweetList.add(tweet);
        Tweet returnedTweet = tweetList.getTweet(0);
        assertTrue((tweet.date.equals(returnedTweet.date)) &&
                (tweet.getText().equals(returnedTweet.getText())));
    }

    public void testGetTweetType(){

    }
}