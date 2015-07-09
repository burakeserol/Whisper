package com.example.AppLogic;

import java.util.ArrayList;


public class OneToTenState implements SurveyVotingState{

	@Override
	public String getResult(ArrayList<Survey> surveyList) {
		int numberOfResults = surveyList.size();
		Double results = 0.0;
		for(int i = 0; i < surveyList.size(); i++)
		{
			if(surveyList.get(i).getSurveyVotingType().equals("1to10"))
			{
				results += surveyList.get(i).getSurveyResult();
				numberOfResults++;
			}
		}
		results = results / numberOfResults;
		return Double.toString(results);
	}

	@Override
	public void addSurveyScreen() {
		// TODO Auto-generated method stub
		
	}

}
