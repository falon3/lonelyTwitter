package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by romansky on 9/30/15.
 */
public class TweetList implements MyObservable{
    private ArrayList<MyObserver> observers = new ArrayList<MyObserver>();
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        tweets.add(tweet);
        notifyObserver();
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public void addObserver(MyObserver myO){
        observers.add(myO);

    }

    public void notifyObserver(){
        for (MyObserver observer: observers){
            observer.myNotify();
        }
    }

}
