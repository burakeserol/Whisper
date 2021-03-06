package com.example.whisper;


import java.util.*;

import com.example.AppLogic.Announcement;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MyAnnouncementsActivity extends ListActivity {
	
	ArrayList<String> list= new ArrayList<String>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		Announcement [] annList;
		DBAnnouncementList readed = new DBAnnouncementList();
		annList = readed.returnAllAnnouncements();
		list.add( "DENEME " );
		for( int i = 0; i < 3; i++)
		{
			list.add(annList[i].getAnnouncementContent());
		}
		ArrayAdapter adap = new ArrayAdapter<String>(MyAnnouncementsActivity.this, android.R.layout.simple_list_item_1, list);
		setListAdapter(adap);	
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String selectedMenuItem = list.get(position);
		
		try {
			Class menuClass = Class.forName( "com.example.profilemenu.CreateAnnouncementActivity" );
//			Intent menuIntent = new Intent( MyAnnouncementsActivity.this, menuClass );
//			startActivity( menuIntent );
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void setListAdapter(ListAdapter adapter) {
		// TODO Auto-generated method stub
		super.setListAdapter(adapter);
	}

	@Override
	public ListAdapter getListAdapter() {
		// TODO Auto-generated method stub
		return super.getListAdapter();
	}
	
	public void updateList(String newItem)
	{
		ArrayAdapter adapter = (ArrayAdapter) this.getListAdapter();
		adapter.add(newItem);
		setListAdapter(adapter);
		//this.notifyAll();
		
	}

}

