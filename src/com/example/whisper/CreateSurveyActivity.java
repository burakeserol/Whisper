package com.example.whisper;


//import android.support.v7.app.ActionBarActivity;
import com.example.ServerAndDB.DatabaseController;
import com.example.ServerAndDB.SurveyCreateDatabase;
import com.example.whisper2.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
 
public class CreateSurveyActivity extends Activity {
     
    private SeekBar radiusBar;
    private SeekBar durationBar;
     
    private TextView radiusText;
    private TextView durationText;
     
    private Button createButton;
     
    private EditText contentOfSurvey;
     
    private RadioGroup radioTypeGroup;
    private RadioButton radioTypeButton;
     
    private int radius;
    private int duration;
     
     
     
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_survey);
         
        radioTypeGroup = (RadioGroup) findViewById(R.id.radioGroup1);
         
        contentOfSurvey = (EditText) findViewById( R.id.contentOfSurvey);
        createButton = (Button) findViewById(R.id.createButton);
         
        createButton.setOnClickListener(new OnClickListener() {
             
            @Override
            public void onClick(View v) {
                 
                int selectedId = radioTypeGroup.getCheckedRadioButtonId();
                 
                radioTypeButton = (RadioButton) findViewById( selectedId);
                 
                System.out.println( "CREATE PRESSED");
                System.out.println( "Content: " + contentOfSurvey.getText());
                System.out.println( "Radius: " + radius);
                System.out.println( "Voting Type: " + radioTypeButton.getText());
                System.out.println( "Duration: " + duration);
                 
                DatabaseController rft = new SurveyCreateDatabase();
                rft.execute( contentOfSurvey.getText().toString(),Integer.toString(radius),radioTypeButton.getText().toString(),Integer.toString(duration));
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
        getMenuInflater().inflate(R.menu.create_survey, menu);
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
