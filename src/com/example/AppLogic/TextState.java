package com.example.AppLogic;

import java.util.ArrayList;


public class TextState implements SurveyVotingState{

	String result = "";
	@Override
	public String getResult(ArrayList<Survey> surveyList) {
		
		for(int i = 0; i < surveyList.size(); i++)
		{
			if(surveyList.get(i).getSurveyVotingType().equals("CheckBox"))
			{
				result += Double.toString(surveyList.get(i).getSurveyResult());
				result += " / ";
			}
		}
		
		return result;
	}

	@Override
	public void addSurveyScreen() {
		// TODO Auto-generated method stub
		
	}

}
