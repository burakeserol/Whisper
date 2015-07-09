package com.example.ServerAndDB;


import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.DeleteAttributesRequest;
import com.amazonaws.services.simpledb.model.GetAttributesRequest;
import com.amazonaws.services.simpledb.model.GetAttributesResult;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.SelectRequest;
import com.amazonaws.services.simpledb.model.SelectResult;
import com.amazonaws.services.simpledb.util.SimpleDBUtils;

import android.os.AsyncTask;
import android.text.style.RelativeSizeSpan;

public class AnnouncementCreateDatabase extends DatabaseController 
{

	private Exception exception;

	@Override
	protected String doInBackground(String... params) {
		try {
			/*
			 * params[0] = content of announcement
			 * params[1] = radius
			 * params[2] = duration
			 * params[3] = visibility
			 */
		
	    	AWSCredentials credentials = new BasicAWSCredentials( "AKIAICVRAR3V4MOWNCNA", "xW922TvEQSEn/bEkcWSD0YR2/l85FzEp7Yf7ekv4");
	    	AmazonSimpleDBClient sdbClient = new AmazonSimpleDBClient( credentials);
	    	try{
	    		sdbClient.createDomain( new CreateDomainRequest("AnnouncementInformation"));
	    	}catch (RuntimeException e){
	    		System.out.println("CATCHTEYIM");
	    		System.out.println( e.toString());
	    	}
	    	
	    	//EKLENENEN YERLER BAÞLANGIÇ
	    	System.out.println("GET STARTED");
	    	SelectRequest slctRequest = new SelectRequest("select AnnouncementID from AnnouncementInformation where AnnouncementID is not null order by AnnouncementID desc limit 1").withConsistentRead(true);
	    	SelectResult slctResult = sdbClient.select( slctRequest);
	    	System.out.println("GET BITTI: " + slctResult.toString());
	    	System.out.println("SUBSTRING11: " + slctResult.toString().substring(16, 17));
	    	System.out.println("SUBSTRING22: " + slctResult.toString().substring(61, 65));
	    	
	    	int itemNameInt = Integer.parseInt(slctResult.toString().substring(16, 17));
	    	itemNameInt++;
	    	String itemNameStr = Integer.toString(itemNameInt);
	    	
	    	int announcementIDInt = Integer.parseInt(slctResult.toString().substring(61, 65));
	    	announcementIDInt++;
	    	String announcementIDstr = Integer.toString(announcementIDInt);
	    	//EKLENEN YERLER BÝTÝÞ
	    	
	    	ReplaceableAttribute announcementID = new ReplaceableAttribute( "AnnouncementID", announcementIDstr, Boolean.TRUE);//deðiþiklik yapýlan satýr 1
	    	ReplaceableAttribute announcementContent = new ReplaceableAttribute( "AnnouncementName", params[0], Boolean.TRUE);
	    	ReplaceableAttribute announcementDuration = new ReplaceableAttribute( "AnnouncementDuration", params[2], Boolean.TRUE);
	    	ReplaceableAttribute announcementRadius = new ReplaceableAttribute( "AnnouncementRadius", params[1], Boolean.TRUE);
	    	ReplaceableAttribute announceVisibility = new ReplaceableAttribute( "SetVisible", params[3], Boolean.TRUE);
	    	
	    	List attrs = new ArrayList(5);
	    	attrs.add( announcementID);
	    	attrs.add( announcementContent);
	    	attrs.add( announcementDuration);
	    	attrs.add( announcementRadius);
	    	attrs.add( announceVisibility);
	    	
	    	PutAttributesRequest par = new PutAttributesRequest( "AnnouncementInformation", itemNameStr, attrs);//deðiþiklik yapýlan satýr 2
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
