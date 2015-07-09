package com.example.ServerAndDB;


import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.SelectRequest;
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

public class ReadSurveysFromDB extends DatabaseController{
	
	private Exception exception;
	

	@Override
	protected String doInBackground(String... params ) {
		/* params[0] : index or size
		 * params[1] : column name
		 */
		try {
			String rdb = null;
			String rowNumber = params[0];
	        String columnName = params[1];
	        
	        System.out.println("Scolumnname" + columnName + " Srownum " + params[0]);
	        
	    	SelectRequest selectRequest=  new SelectRequest("select * from SurveyInformation").withConsistentRead(true);
	        
	        List<com.amazonaws.services.simpledb.model.Item> items  = ConnectDB.getAwsSimpleDB().select(selectRequest).getItems();
	        
	        try
	        {
	        	System.out.println( "STRY");
	        	com.amazonaws.services.simpledb.model.Item temp1;
	        	int size = items.size();
	        	System.out.println( rowNumber );
	        	System.out.println( "Ssize "+ size);
		        if( rowNumber.equals("size"))
		        {
		        	System.out.println( "IF size return ");
		        	return Integer.toString(size);
		        }
		        else
		        {	        
		            temp1= ((com.amazonaws.services.simpledb.model.Item)items.get( Integer.parseInt(rowNumber ) ));
		            
		            System.out.println( "i:" + rowNumber +"items"+ items.get( Integer.parseInt(rowNumber )));
		            
		            List<com.amazonaws.services.simpledb.model.Attribute> tempAttribute= temp1.getAttributes();
		            
		            for(int j=0; j< tempAttribute.size();j++)
		            {
		                if(tempAttribute.get(j).getName().equals(columnName))
		                {
		                    rdb=tempAttribute.get(j).getValue();
		                    System.out.println(rdb);
		                }
		            }
		            return rdb;
		        }
	        }
	        catch( Exception eex)
	        {
	            throw new Exception("FIRST EXCEPTION", eex);
	        }					
		} 
		catch( Exception e){
			this.exception = e;
			return null;
		}
	}
}

