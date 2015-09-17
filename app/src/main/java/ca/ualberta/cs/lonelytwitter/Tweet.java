package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/** have attributes, constructors, methods
 * class can be private(only accessible by the current class), protected or public
 * Created by scheers on 9/16/15.
 */
public abstract class Tweet implements Tweetable {
    // this is same as doing ...Tweet extends Object
    // because it goes ImportantTweet-> Tweet-> Object

    // attributes
    private String text;
    protected Date date;

    private ArrayList<CurrentMood> mood;


    public Tweet(String text, Date date){
        //constructors
        this.text = text;
        this.date = date;
        // this is a reference to the current object
    }

    public Tweet(String tweet) {
        this.text = tweet;
        this.date = new Date();
        // new is special... uhhh look it up cant remember

        // encapsulation!!! -> means keep your attributes private or protected
        //code-> generate-> getter and setter

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) throws TweetTooLongException {
        if (text.length() <= 140) {
            this.text = text;
        } else{
            throw new TweetTooLongException();
            //also are runtime exceptions can throw and catch
        }
    }

    public abstract Boolean isImportant();
}
