package com.example.whisper;

public interface ObserverActivity {

	//method to update the observer which is used by subjectActivity in notify
	public void updateSurveyScreen();
	
	public void updateSendMessageScreen();
	
	public void updateAnnouncementScreen();
}
