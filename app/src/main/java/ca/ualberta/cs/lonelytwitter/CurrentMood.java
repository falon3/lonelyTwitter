package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by scheers on 9/16/15.
 */
public abstract class CurrentMood {

    // attributes
    protected Date date;

    public CurrentMood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String getMood();
}
