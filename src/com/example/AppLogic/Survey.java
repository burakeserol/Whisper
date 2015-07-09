package com.example.AppLogic;


public class Survey {
	String surveyContent;
	String surveyID;
	int surveyDuration;
	int surveyRadius;
	double surveyResult;
	String surveyVotingType;
	
	
	void Survey( String ID, String content, int duration, int radius , double result, String votingType )
	{
		surveyContent = content;
		surveyID = ID;
		surveyDuration = duration;
		surveyRadius = radius;
		surveyResult = result;
		surveyVotingType = votingType;
	}


	public String getSurveyContent() {
		return surveyContent;
	}


	public void setSurveyContent(String surveyContent) {
		this.surveyContent = surveyContent;
	}


	public String getSurveyID() {
		return surveyID;
	}


	public void setSurveyID(String surveyID) {
		this.surveyID = surveyID;
	}


	public int getSurveyDuration() {
		return surveyDuration;
	}


	public void setSurveyDuration(int surveyDuration) {
		this.surveyDuration = surveyDuration;
	}


	public int getSurveyRadius() {
		return surveyRadius;
	}


	public void setSurveyRadius(int surveyRadius) {
		this.surveyRadius = surveyRadius;
	}


	public double getSurveyResult() {
		return surveyResult;
	}


	public void setSurveyResult(double surveyResult) {
		this.surveyResult = surveyResult;
	}


	public String getSurveyVotingType() {
		return surveyVotingType;
	}


	public void setSurveyVotingType(String surveyVotingType) {
		this.surveyVotingType = surveyVotingType;
	}

}

