package com.example.whisper;

import com.example.AppLogic.*;
import com.example.whisper2.R;

import android.text.Editable;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ScanActivity extends Activity{

	String RegID;
	ImageButton refresh;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan);
		
				
		//creation
		TextView send = (TextView)findViewById(R.id.sender);
		
		ImageView image1 = (ImageView)findViewById(R.id.imageView1);
		ImageView image2 = (ImageView)findViewById(R.id.imageView2);
		ImageView image3 = (ImageView)findViewById(R.id.imageView3);
		ImageView image4 = (ImageView)findViewById(R.id.imageView4);
		
		final EditText text = (EditText)findViewById(R.id.editText1);
		
		
		//listeners
		send.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {
											
				Editable temp = text.getText();
				String message = temp.toString();
				
				Log.v("EditText", text.getText().toString());
								
				String apiKey = "AIzaSyDsTSYvSc8tKRLGLPEA0PhUun-qtDu6pCw";
				
				POST2GCM postThread = new POST2GCM(apiKey, App.createContent(message, RegID ));
				System.out.println("Hey");
				postThread.start();
				
				/*try {
					postThread.join();
				} catch (InterruptedException e) {
					System.err.println("Thread Interrupted");
				}*/
								
				text.setText("");
				Toast.makeText(getApplicationContext(), "Message has been sent" + RegID, Toast.LENGTH_SHORT).show();
			}
		});
			
		image1.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {
				//Test
				RegID = "APA91bFi1uyGRvIsl3-NmtNhhduImW_VJ7uYZqv2c82_C6kuU9Gjlm-pFrQf-HqUgdE3vpCGqZ8FPJdFDbpOqKAVI_8AVHoEdPLh8u8OPBBostD0ILUeqC4SKTP87eR4eFGAlHxsr3V27_cP3PEMbbdRi5cVPj713Q";
			}
		});
		
		image2.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {
				//Oðuzhan
				RegID = "APA91bHkaGV5L-DkPX4EcyyIT5fVD01NX-yvPYmHKjwazvlkx2xOeiHjRU2NiXUstHtShabGSiFl9lQchxGRIZUwymD_fbQ0V8wZOSw066w0K14cOpnyyYusjJ_e0MmSFvk6mY3EhCUUUdF8ElPnifveJbrRBD923w";
			}
		});
		
		image3.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {
				//Iþýtan
				RegID = "APA91bHDstsFF4B5J9wNuL1VXgeJqxDLcV4OyOmZjMQIs1MIjnYd9H_NpxKfumemQu-Wnac2wXMOT8ieWBlwEFN60WhUJB32mJb9w6_ppQkevlQTwledvmbRAdKxgMWEzd5ZVTPA8qW4rhLJI08-iCqr4FrQCWRdmg";
			}
		});
		
		image4.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {
				//Lütfü
				RegID = "APA91bHoxBH3EVWZzGVpJhzjH4XxbM_HrTiyCmS7UWfNJgerbaDVHuv7oReFfkhsl2puuf8mUUYYhn66ZtaXQyPtqYAxmIe9lL3eXbPTK_vApBlPI57ijoNAA9I8OvhRYfv2wgm8EDzwj-0U1JkL6nilrlor9i_iGQ";
			}
		});				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public void update(){
		refresh.
	}
	
}
