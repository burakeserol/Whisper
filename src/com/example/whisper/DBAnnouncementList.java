package com.example.whisper;


import java.util.concurrent.ExecutionException;

import com.example.AppLogic.Announcement;
import com.example.ServerAndDB.ReadFromDB;

public class DBAnnouncementList {

	Announcement announcementObj;
	Announcement [] announcementList;
	
	Announcement [] returnAllAnnouncements()
	{
		int size = getSize();
		String id;
		String content;
		int duration;
		int radius;
		String isVisible;
		announcementList = new Announcement[size];
		System.out.println( "sizeofAnnouncementDomain " + size );
				
		for( int i = 0; i < size; i++ )
		{
			
			announcementObj = new Announcement();
			id = getID( i );
			
			System.out.println( "SIZE DAN SONRA FOR DA ");
			
			content = getContent(i);
			duration = getDuration(i);
			radius = getRadius(i);
			isVisible = getIsVisible(i);
			System.out.println( "ID " + id );
			System.out.println( "content " + content );
			System.out.println( "duration " + duration );
			System.out.println( "radius " + radius );
			System.out.println( "isVisible " + isVisible );
			
			announcementObj.setAnnouncementID(id);
			announcementObj.setAnnouncementContent(content);
			announcementObj.setAnnouncementDuration(duration);
			announcementObj.setAnnouncementRadius(radius);
			announcementObj.setIsVisible(isVisible);
			announcementList[i] = announcementObj;
		}	
		return announcementList;
	}
	
	int getSize()
	{
		ReadFromDB rdb = new ReadFromDB();
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
		ReadFromDB rdb = new ReadFromDB();
		try {
			System.out.println("getID" );
			id = rdb.execute(Integer.toString(index), "AnnouncementID").get();
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
		ReadFromDB rdb = new ReadFromDB();
		try {
			content = rdb.execute(Integer.toString(index), "AnnouncementName").get();
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
		ReadFromDB rdb = new ReadFromDB();
		try {
			System.out.println("getDuration" );
			duration = rdb.execute(Integer.toString(index), "AnnouncementDuration").get();
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
		ReadFromDB rdb = new ReadFromDB();
		try {
			System.out.println("getRadius" );
			radius = rdb.execute(Integer.toString(index), "AnnouncementRadius").get();
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
	String getIsVisible( int index )
	{
		String visible = null;
		ReadFromDB rdb = new ReadFromDB();
		try {
			visible = rdb.execute(Integer.toString(index), "SetVisible").get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return visible;
	}

}
