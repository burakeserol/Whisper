package com.example.ServerAndDB;


import java.util.ArrayList;
import java.util.List;

import android.R.bool;

import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;

public class StoreToAnnouncementDB {
	public void saveAnnouncement(int ID, String content, int duration, int radius, String setVisible)
    {
        try {

             ConnectDB.getAwsSimpleDB().createDomain(new CreateDomainRequest( "AnnouncementInformation"));
             List<ReplaceableAttribute> attribute= new ArrayList<ReplaceableAttribute>(1);
             attribute.add(new ReplaceableAttribute().withName("AnnouncementID").withValue(Integer.toString(ID)));
             attribute.add(new ReplaceableAttribute().withName("AnnouncementName").withValue(content));
             attribute.add(new ReplaceableAttribute().withName("AnnouncementDuration").withValue(Integer.toString(duration)));
             attribute.add(new ReplaceableAttribute().withName("AnnouncementRadius").withValue(Integer.toString(radius)));
             attribute.add(new ReplaceableAttribute().withName("SetVisible").withValue(String.valueOf(setVisible)));
             ConnectDB.awsSimpleDB.putAttributes(new PutAttributesRequest("AnnouncementInformation",Integer.toString(ID), attribute));
            
        } catch (Exception e) {
                //System.out.println(e.getMessage());
        }
    } 
}
