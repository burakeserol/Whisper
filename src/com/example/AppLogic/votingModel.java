package com.example.AppLogic;

import java.util.ArrayList;


public class votingModel implements SurveyVotingState{

	private SurveyVotingState surveyVotingState;
	
	public void setState( SurveyVotingState state)
	{
		this.surveyVotingState = state;
	}
	
	public SurveyVotingState getState()
	{
		return this.surveyVotingState;
	}
	
	@Override
	public String getResult(ArrayList<Survey> surveyList) {
		this.surveyVotingState.getResult(surveyList);
		return null;
	}

	@Override
	public void addSurveyScreen() {
		// TODO Auto-generated method stub
		
	}

}
