package com.example.AppLogic;

import java.util.ArrayList;


public interface SurveyVotingState {

	public String getResult(ArrayList<Survey> surveyList);
	
	public void addSurveyScreen();
}
