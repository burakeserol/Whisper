package com.example.whisper;

import java.util.ArrayList;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class GcmMessageHandler extends IntentService {

	ArrayList<String> values = new ArrayList<String>();
    String mes;
    private Handler handler;
        
    public GcmMessageHandler() {
        super("GcmMessageHandler");
    }
    
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        handler = new Handler();
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();       

        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);
        
        mes = extras.getString("title");
        showToast(mes);	
       //main.accumulate(mes);
       /*Intent newIntent = new Intent(GcmMessageHandler.this, MainActivity.class);
       newIntent.putExtra("myMes", mes);       
       startActivity(newIntent);
       newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       */
          
	   MainActivity.valuesMain.add(mes);
       
       Log.i("Message:", "Alýnan :" + mes);
       
       Log.i("GCM", "Received : (" +messageType+")  "+extras.getString("title"));

       GcmBroadcastReceiver.completeWakefulIntent(intent);
    }   
    
    public void showToast(final String message){
        handler.post(new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
         });

    }    
}