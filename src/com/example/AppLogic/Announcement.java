package com.example.AppLogic;


public class Announcement {
	String announcementContent;
	String announcementID;
	int announcementDuration;
	int announcementRadius;
	String isVisible;
	
	
	void Announcement( String ID, String content, int duration, int radius , String visible)
	{
		announcementContent = content;
		announcementID = ID;
		announcementDuration = duration;
		announcementRadius = radius;
		isVisible = visible;
	}
	public String getAnnouncementContent() {
		return announcementContent;
	}
	public void setAnnouncementContent(String announcementContent) {
		this.announcementContent = announcementContent;
	}
	public String getAnnouncementID() {
		return announcementID;
	}
	public void setAnnouncementID(String announcementID) {
		this.announcementID = announcementID;
	}
	public int getAnnouncementDuration() {
		return announcementDuration;
	}
	public void setAnnouncementDuration(int announcementDuration) {
		this.announcementDuration = announcementDuration;
	}
	public int getAnnouncementRadius() {
		return announcementRadius;
	}
	public void setAnnouncementRadius(int announcementRadius) {
		this.announcementRadius = announcementRadius;
	}
	public String getIsVisible() {
		return isVisible;
	}
	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}
	

}
