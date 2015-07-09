package com.example.ServerAndDB;


import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.DeleteAttributesRequest;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.SelectRequest;
import com.amazonaws.services.simpledb.model.SelectResult;
import com.amazonaws.services.simpledb.util.SimpleDBUtils;

import android.os.AsyncTask;
import android.text.style.RelativeSizeSpan;

public class SurveyCreateDatabase extends DatabaseController 
{

	private Exception exception;

	@Override
	protected String doInBackground(String... params) {
		try {
			/*
			 * params[0] = content of survey
			 * params[1] = radius
			 * params[2] = voting type
			 * params[3] = duration
			 */
		
	    	AWSCredentials credentials = new BasicAWSCredentials( "AKIAICVRAR3V4MOWNCNA", "xW922TvEQSEn/bEkcWSD0YR2/l85FzEp7Yf7ekv4");
	    	AmazonSimpleDBClient sdbClient = new AmazonSimpleDBClient( credentials);
	    	try{
	    		sdbClient.createDomain( new CreateDomainRequest("SurveyInformation"));
	    	}catch (RuntimeException e){
	    		System.out.println("CATCHTEYIM");
	    		System.out.println( e.toString());
	    	}
	    	
	    	//EKLENENE YERLER BAÞLANGIÇ
	    	System.out.println("GET STARTED");
	    	SelectRequest slctRequest = new SelectRequest("select SurveyID from SurveyInformation where SurveyID is not null order by SurveyID desc limit 1").withConsistentRead(true);
	    	SelectResult slctResult = sdbClient.select( slctRequest);
	    	System.out.println("GET BITTI: " + slctResult.toString());
	    	System.out.println("SUBSTRING11: " + slctResult.toString().substring(16, 17));
	    	System.out.println("SUBSTRING22: " + slctResult.toString().substring(55, 59));
	    	
	    	int itemNameInt = Integer.parseInt(slctResult.toString().substring(16, 17));
	    	itemNameInt++;
	    	String itemNameStr = Integer.toString(itemNameInt);
	    	
	    	int surveyIDInt = Integer.parseInt(slctResult.toString().substring(55, 59));
	    	surveyIDInt++;
	    	String surveyIDstr = Integer.toString(surveyIDInt);
	    	//EKLENEN YER BÝTÝÞ

	    	ReplaceableAttribute surveyID = new ReplaceableAttribute( "SurveyID", surveyIDstr, Boolean.TRUE);//deðiþiklik yapýlan satýr 1
	    	ReplaceableAttribute surveyContent = new ReplaceableAttribute( "SurveyName", params[0], Boolean.TRUE);
	    	ReplaceableAttribute surveyDuration = new ReplaceableAttribute( "SurveyDuration", params[3], Boolean.TRUE);
	    	ReplaceableAttribute surveyRadius = new ReplaceableAttribute( "SurveyRadius", params[1], Boolean.TRUE);
	    	ReplaceableAttribute surveyResult = new ReplaceableAttribute( "SurveyResult", "N/A", Boolean.TRUE);
	    	ReplaceableAttribute surveyVotingType = new ReplaceableAttribute( "SurveyVotingType", params[2], Boolean.TRUE);
	    	
	    	List attrs = new ArrayList(6);
	    	attrs.add( surveyID);
	    	attrs.add( surveyContent);
	    	attrs.add( surveyDuration);
	    	attrs.add( surveyRadius);
	    	attrs.add( surveyResult);
	    	attrs.add( surveyVotingType);
	    	
	    	PutAttributesRequest par = new PutAttributesRequest( "SurveyInformation", itemNameStr, attrs);//deðiþiklik yapýlan satýr 2
	    	sdbClient.putAttributes( par);
	    	System.out.println("PARDOMAIN: " + par.getDomainName());
	    	
	    	////////
			
			
			
		} catch( Exception e){
			this.exception = e;
			return null;
		}
		return null;
	}

}
