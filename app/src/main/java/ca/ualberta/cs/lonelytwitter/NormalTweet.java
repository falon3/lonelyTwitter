package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by scheers on 9/16/15.
 */
public class NormalTweet extends Tweet {
    public NormalTweet(String text, Date date) {
        super(text, date);
    }

    public NormalTweet(String tweet) {
        super(tweet);
    }

    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}
