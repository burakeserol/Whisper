package com.example.AppLogic;

import java.util.ArrayList;


public class CheckBoxState implements SurveyVotingState 
{
	String result = "";
	int numberOftype1 = 0;
	int numberOftype2 = 0;
	ArrayList<String> resultList = new ArrayList<String>();
	@Override
	public void addSurveyScreen() {
		// TODO Auto-generated method stub
		
	}

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
			if(resultList.get(i).equals("Type1"))
				numberOftype1++;
			else
				numberOftype2++;
		}
		result = Integer.toString(numberOftype1);
		result += " / ";
		result += Integer.toString(numberOftype2);
		return result;
	}
}
