package com.example.whisper;

public interface SubjectActivity {
	
	//methods register or unregister
	public void Attach(ObserverActivity o);
	public void Detach(ObserverActivity o);
	
	//public void notify observers related to change
	public void Notify();
	
	//method gets updates from subject
	public Object getUpdate(ObserverActivity o);
}
