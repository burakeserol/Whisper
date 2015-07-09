package com.example.whisper;

import java.util.List;

import android.R.string;

public class OwnerOfActivity implements SubjectActivity {

	private List<ObserverActivity> observers;
	private string message;
	private boolean changed;
		
	@Override
	public void Attach(ObserverActivity o) {
		if (o == null) throw new NullPointerException("Null Observer");
		if(!observers.contains(o)) 
			observers.add(o);
	}

	@Override
	public void Detach(ObserverActivity o) 
	{
		observers.remove(o);
	}

	@Override
	public void Notify() {
		if(!changed)
			return;
		
		this.changed = false;
		for (int i = 0; i < observers.size(); i++ )
		{
			observers.get(i).updateAnnouncementScreen();
			observers.get(i).updateSurveyScreen();
			observers.get(i).updateSendMessageScreen();		
		}
	
	}

	@Override
	public Object getUpdate(ObserverActivity o) {
		return this.message;
    }
	
	public void postMessage(string msg){
        this.message = msg;
        this.changed = true;
        Notify();
    }



}
