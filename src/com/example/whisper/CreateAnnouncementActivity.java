package com.example.whisper;

//import android.support.v7.app.ActionBarActivity;
import com.example.ServerAndDB.AnnouncementCreateDatabase;
import com.example.ServerAndDB.DatabaseController;
import com.example.whisper2.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
 
public class CreateAnnouncementActivity extends Activity {
     
    private SeekBar radiusBar;
    private SeekBar durationBar;
     
    private TextView radiusText;
    private TextView durationText;
     
    private Button createButton;
     
    private EditText contentOfAnnouncement;
     
    private CheckBox visibility;
     
     
    private int radius;
    private int duration;
       
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_announcement);
        
        System.out.println("CALISTIM");
         
        visibility = (CheckBox)findViewById(R.id.visibility);
        contentOfAnnouncement = (EditText) findViewById( R.id.contentOfAnnouncement);
        createButton = (Button) findViewById(R.id.createButton);
         
        createButton.setOnClickListener(new OnClickListener() {
             
            @Override
            public void onClick(View v) {
                 
                System.out.println( "CREATE PRESSED");
                System.out.println( "Content: " + contentOfAnnouncement.getText());
                System.out.println( "Radius: " + radius);
                System.out.println( "Duration: " + duration);
                 
                DatabaseController rft = new AnnouncementCreateDatabase();
                String s1=contentOfAnnouncement.getText().toString();
                String s2=Integer.toString(radius);
                String s3=Integer.toString(duration);
                String s4 = String.valueOf(visibility.isChecked());
                System.out.println( "s1" + s1);
                System.out.println( "s2" + s2);
                System.out.println( "s2" + s3);
                System.out.println( "s2" + s4);
                rft.execute( s1, s2, s3, s4);
 //               sdb.saveAnnouncement(123456, s1, duration, radius, s4);
            }
        });
         
        radiusBar = (SeekBar)findViewById(R.id.radiusBar);
        radiusBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                    boolean fromUser) {
                radiusText = (TextView)findViewById(R.id.radiusText);
                radiusText.setText( "Radius: " + progress +" meters");
                radius = progress;  
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        }); 
         
        durationBar = (SeekBar)findViewById(R.id.durationBar);
        durationBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                    boolean fromUser) {
                durationText = (TextView)findViewById(R.id.durationText);
                durationText.setText( "Duration: " + progress +" minutes");
                duration = progress;    
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        }); 
         
         
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this Haadds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_announcement, menu);
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