package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by scheers on 9/16/15.
 */
public class Angry extends CurrentMood {
    public Angry(Date date) {
        super(date);
    }

    @Override
    public String getMood(){
        return "ANGRY_FACE";

    }

}
