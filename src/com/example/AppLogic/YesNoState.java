package com.example.AppLogic;

import java.util.ArrayList;


public class YesNoState implements SurveyVotingState{

	ArrayList<String> resultList = new ArrayList<String>();
	int numberOfYes = 0;
	int numberOfNo = 0;
	String result = "";
	@Override
	public String getResult(ArrayList<Survey> surveyList) {
		for(int i = 0; i < surveyList.size(); i++)
		{
			if(surveyList.get(i).getSurveyVotingType().equals("CheckBox"))
			{
				resultList.add(Double.toString(surveyList.get(i).getSurveyResult()));
			}
		}
		for(int i = 0; i < resultList.size(); i++)
		{
			if(resultList.get(i).equals("Yes"))
				numberOfYes++;
			else
				numberOfNo++;
		}
		result = Integer.toString(numberOfYes);
		result += " / ";
		result += Integer.toString(numberOfNo);
		return null;
	}

	@Override
	public void addSurveyScreen() {
		// TODO Auto-generated method stub
		
	}

}
