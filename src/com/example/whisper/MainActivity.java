package com.example.whisper;

import java.io.IOException;
import java.util.ArrayList;

import com.example.whisper2.R;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.IntentService;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ListActivity implements OnClickListener {
	public static ArrayList<String> valuesMain = new ArrayList<String>();
    Button btnRegId;
    EditText etRegId;
    GoogleCloudMessaging gcm;    
    String regid;
    String PROJECT_NUMBER = "84394029801";
    ListView listView ;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;    	    
    ImageButton refresh;
        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	final GcmMessageHandler GCM = new GcmMessageHandler();
    	
    	super.onCreate(savedInstanceState);
    	
        setContentView(R.layout.activity_main);
        // Get ListView object from xml
        listView = (ListView) findViewById(android.R.id.list);
                
        adapter = new ArrayAdapter<String>(
        		this,
                android.R.layout.simple_list_item_1,
                listItems);
        
        listItems.add(0, "WelcomeTo Whisper!");       
        
        setListAdapter(adapter);
                
        refresh = (ImageButton)findViewById(R.id.imageButton1);
              
        refresh.setOnClickListener(new View.OnClickListener()
		{            	
			public void onClick(View v)
			{
				ArrayList<String> newItems = valuesMain;
				
				for (int i = 0; i < newItems.size(); i ++ )
				{
					System.out.println(newItems.get(i));
					adapter.add(newItems.get(i));					
				}
				adapter.notifyDataSetChanged();
				valuesMain = new ArrayList<String>();
			}
		});
           
	    // ListView Item Click Listener
	    listView.setOnItemClickListener(new OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
                
               // ListView Clicked item index
               int itemPosition     = position;
               
               // ListView Clicked item value
               String  itemValue    = (String) listView.getItemAtPosition(position);
               adapter.remove(adapter.getItem(itemPosition));
               adapter.notifyDataSetChanged();
                  
                // Show Alert 
                Toast.makeText(getApplicationContext(),
                    itemValue + " is deleted", Toast.LENGTH_LONG)
                  .show();             
              }
         }); 	   
    }
        
    public void getRegId(){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg = "";

                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(getApplicationContext());
                    }
                	Log.i("TEST", "ok1");

                    regid = gcm.register(PROJECT_NUMBER);
                	Log.i("TEST", "ok2");

                    msg = "Device registered, registration ID=" + regid;
                    Log.i("GCM",  msg);

                } catch (IOException ex) {
                    msg = "Error :" + ex.getMessage();
                }
                return msg;
            }

            @Override
            protected void onPostExecute(String msg) {
                etRegId.setText(msg + "\n");
            }
        }.execute(null, null, null);
    }
    
    @Override
    public void onClick(View v) {
        getRegId();
    } 
}