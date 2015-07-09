package com.example.whisper;


import com.example.ServerAndDB.DatabaseController;
import com.example.ServerAndDB.ReportBugDatabase;
import com.example.whisper2.R;

//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ReportBugActivity extends 
Activity {

	private Button reportButton;
	private EditText contentOfBug;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_report_bug);

			contentOfBug = (EditText) findViewById( R.id.contentOfBug);
			reportButton = (Button) findViewById(R.id.reportButton);
		
			reportButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				System.out.println( "Report PRESSED");
				System.out.println( "Content: " + contentOfBug.getText());
				DatabaseController reportBugDB= new ReportBugDatabase();
				reportBugDB.execute( contentOfBug.getText().toString());
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.report_bug, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
