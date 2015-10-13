package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {
    private EditText bodyText;
    private Button saveButton;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }


    public void testEditATweet(){
        // starts lonelyTwitter
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();
        // make sure we have a tweet to edit
        //user clicks on tweet they wanna edit
        bodyText = activity.getBodyText();

        activity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText.setText("hamburgers");
            }
        });
        getInstrumentation().waitForIdleSync(); //make sure our UI thread finishes
        saveButton = activity.getSaveButton();

        activity.runOnUiThread(new Runnable() {
            public void run() {
                saveButton.performClick();
            }
        });
        getInstrumentation().waitForIdleSync(); //make sure our UI thread finishes


        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("hamburgers", tweet.getText());
        activity.runOnUiThread(new Runnable() {
            public void run() {
                oldTweetsList.performClick();

            }
        });

        //set up an activityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(), null, false);


        // Set up an ActivityMonitor
        ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(ReceiverActivity.class.getName(),
                        null, false);

        // Validate that ReceiverActivity is started
        TouchUtils.clickView(this, sendToReceiverButton);
        EditTweetActivity receiverActivity = (EditTweetActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(TIMEOUT_IN_MS);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity.getClass());

        // Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);



    }
}