package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by scheers on 9/16/15.
 */
public interface Tweetable {
    // interface dont usually have constructors or attributes vs. class
    // kinda like a checklist for things that classes need to have
    public String getText();
    public Date getDate();
}
