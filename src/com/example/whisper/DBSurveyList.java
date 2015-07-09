package com.example.whisper;


import java.util.concurrent.ExecutionException;

import com.example.AppLogic.Survey;
import com.example.ServerAndDB.ReadSurveysFromDB;

public class DBSurveyList {

	Survey surveyObj;
	Survey [] surveyList;
	
	Survey [] returnAllSurveys()
	{
		int size = getSize();
		String id;
		String content;
		int duration;
		int radius;
		double result;
		String votingType;
		surveyList = new Survey[size];
		System.out.println( "sizeofSurveyDomain " + size );
				
		for( int i = 0; i < size; i++ )
		{
			
			surveyObj = new Survey();
			id = getID( i );
			
			System.out.println( "Survey for loop ");
			
			content = getContent(i);
			duration = getDuration(i);
			radius = getRadius(i);
			result = getResult(i);
			votingType = getVotingType(i);
			System.out.println( "ID " + id );
			System.out.println( "content " + content );
			System.out.println( "duration " + duration );
			System.out.println( "radius " + radius );
			System.out.println( "result " + result );
			System.out.println( "votingType " + votingType );
			
			surveyObj.setSurveyID(id);
			surveyObj.setSurveyContent(content);
			surveyObj.setSurveyDuration(duration);
			surveyObj.setSurveyRadius(radius);
			surveyObj.setSurveyResult(result);
			surveyObj.setSurveyVotingType(votingType);
			surveyList[i] = surveyObj;
		}	
		return surveyList;
	}
	
	int getSize()
	{
		ReadSurveysFromDB rdb = new ReadSurveysFromDB();
		String size = null;
		try {
			System.out.println( " trygetsize");
			size = rdb.execute("size", "0").get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( " s" + size );
		return Integer.parseInt(size);
	}
	
	String getID( int index )
	{
		String id = null;
		ReadSurveysFromDB rdb = new ReadSurveysFromDB();
		try {
			System.out.println("getID" );
			id = rdb.execute(Integer.toString(index), "SurveyID").get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ID" + id );
		return id;
	}
	
	String getContent( int index )
	{
		String content = null;
		ReadSurveysFromDB rdb = new ReadSurveysFromDB();
		try {
			content = rdb.execute(Integer.toString(index), "SurveyName").get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
	
	int getDuration( int index )
	{
		String duration = null;
		ReadSurveysFromDB rdb = new ReadSurveysFromDB();
		try {
			System.out.println("getDuration" );
			duration = rdb.execute(Integer.toString(index), "SurveyDuration").get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("duration" + duration );
		return Integer.parseInt(duration);
	}
	
	int getRadius( int index )
	{
		String radius = null;
		ReadSurveysFromDB rdb = new ReadSurveysFromDB();
		try {
			System.out.println("getRadius" );
			radius = rdb.execute(Integer.toString(index), "SurveyRadius").get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("radius" + radius );
		return Integer.parseInt(radius);
	}
	
	double getResult( int index )
	{
		String result = null;
		ReadSurveysFromDB rdb = new ReadSurveysFromDB();
		try {
			System.out.println("getResult" );
			result = rdb.execute(Integer.toString(index), "SurveyResult").get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("result" + result );
		return Double.parseDouble(result);
	}
	
	String getVotingType( int index )
	{
		String votingType = null;
		ReadSurveysFromDB rdb = new ReadSurveysFromDB();
		try {
			votingType = rdb.execute(Integer.toString(index), "SurveyVotingType").get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return votingType;
	}

}
