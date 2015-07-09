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

public class ReportBugDatabase extends DatabaseController
{

	private Exception exception;

	@Override
	protected String doInBackground(String... params) {
		try {
			/*
			 * params[0] = content of bug
			 */
		
	    	AWSCredentials credentials = new BasicAWSCredentials( "AKIAICVRAR3V4MOWNCNA", "xW922TvEQSEn/bEkcWSD0YR2/l85FzEp7Yf7ekv4");
	    	AmazonSimpleDBClient sdbClient = new AmazonSimpleDBClient( credentials);
	    	try{
	    		sdbClient.createDomain( new CreateDomainRequest("BugInformation"));
	    	}catch (RuntimeException e){
	    		System.out.println("CATCHTEYIM");
	    		System.out.println( e.toString());
	    	}
	    	
	    
	    	ReplaceableAttribute bugContent = new ReplaceableAttribute( "Information", params[0], Boolean.TRUE);
	    	
	    	List attrs = new ArrayList(1);
	    	attrs.add( bugContent);
	    	
	    	PutAttributesRequest par = new PutAttributesRequest( "BugInformation", "3", attrs);
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