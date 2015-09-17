package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by scheers on 9/16/15.
 */
public class ImportantTweet extends Tweet {
    // extends copies everything from Tweet except for the constructors

    public ImportantTweet(String tweet, Date date) {
        super(tweet, date);
        this.setText(tweet);
        this.date = date;
    }

    public ImportantTweet(String tweet) {
        super(tweet);
    }

    @ Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

    /*@Override ///added above any methods we think are overriding, but can override anyways so mostly just here for spell checking
    //to make sure we are in act re-using another function and giving it new things
    public string getTest(){
        return  "!!!" + super.getText();

    }*/

}

//polymorshism you can treat any class as any one of its super classes