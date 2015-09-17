package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by scheers on 9/16/15.
 */
public class Stoked extends CurrentMood {
    public Stoked(Date date) {
        super(date);
    }

    @Override
    public String getMood(){
        return "Stoked!";

    }
}
