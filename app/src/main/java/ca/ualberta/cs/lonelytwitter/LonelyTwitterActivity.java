package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity { //View

	private static final String FILENAME = "file.sav"; //Model
	private EditText bodyText; // View
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>(); //View
	private ListView oldTweetsList; //View
	private ArrayAdapter<Tweet> adapter; //View

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) { //View

		super.onCreate(savedInstanceState); //Model
		setContentView(R.layout.main); // View

		bodyText = (EditText) findViewById(R.id.body); //View
		Button saveButton = (Button) findViewById(R.id.save); //View
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList); //View

		saveButton.setOnClickListener(new View.OnClickListener() { //View

			public void onClick(View v) { //Controller
				setResult(RESULT_OK); // Controller
				String text = bodyText.getText().toString(); // View
				tweets.add(new NormalTweet(text)); //Controller
				saveInFile(); //model
				adapter.notifyDataSetChanged(); //model

			}
		});
	}

	@Override
	protected void onStart() { //controller
		// TODO Auto-generated method stub
		super.onStart(); //controller
		loadFromFile(); //model
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets); //view
		oldTweetsList.setAdapter(adapter); // controller
		adapter.notifyDataSetChanged(); // model
	}

	private void loadFromFile() { //model
		try { //controller
			FileInputStream fis = openFileInput(FILENAME); // model
			BufferedReader in = new BufferedReader(new InputStreamReader(fis)); // moel
			Gson gson = new Gson(); // model
			// https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
			Type arraylistType = new TypeToken<ArrayList<NormalTweet>>() {}.getType(); //model
			tweets = gson.fromJson(in, arraylistType); //model

		} catch (FileNotFoundException e) { //controller
			tweets = new ArrayList<Tweet>(); //model
		} catch (IOException e) { //controller
			throw new RuntimeException(e); //model
		}
	}
	
	private void saveInFile() { //model
		try { //controller
			FileOutputStream fos = openFileOutput(FILENAME, 0); //model
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos)); //model
			Gson gson = new Gson(); //model
			gson.toJson(tweets, out); //model
			out.flush(); //model
			fos.close(); //model
		} catch (FileNotFoundException e) { //conroller
			// TODO Auto-generated catch block
			throw new RuntimeException(e); //model
		} catch (IOException e) { //controller
			// TODO Auto-generated catch block
			throw new RuntimeException(e); //model
		}
	}
}