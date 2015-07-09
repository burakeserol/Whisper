package com.example.whisper;

import com.example.whisper2.R;


public class User implements ObserverActivity {

	SeeAnnouncementActivity anouncementActivity;
	SeeSurveyActivity surveyActivity;
	ScanActivity messageActivity;
	
	@Override
	public void updateSurveyScreen() {
		
		surveyActivity.finish();
		if(surveyActivity.getCallingActivity().toString().equals("Type1"))
			surveyActivity.setContentView(R.layout.seeSurvey1);
		else if( surveyActivity.getCallingActivity().toString().equals("Type2"))
			surveyActivity.setContentView(R.layout.seeSurvey2);
		else
			surveyActivity.setContentView(R.layout.seeSurvey3);
	}

	@Override
	public void updateSendMessageScreen() {
		
		messageActivity.setContentView(R.layout.activity_main);
		messageActivity.update();
	}

	@Override
	public void updateAnnouncementScreen() {
		
		anouncementActivity.finish();
		anouncementActivity.setContentView(R.layout.seeAnnouncement);
		
	}
	
}
