package com.example.AppLogic;

public class WhisperUser {
	String userID;
	String PhoneNumber;
	String userName;
	int numberOfAnnouncements;
	int numberOfMessageReceived;
	int numberOfMessageSend;
	int numberOfSurveys;
	
	
	void Announcement( String id, String phoneNum,  String name,  int annNum, int receivedMessNum, int sendedMessNum, int surveyNum)
	{
		userID = id;
		PhoneNumber = phoneNum;
		userName = name;
		numberOfAnnouncements = annNum;
		numberOfMessageReceived = receivedMessNum;
		numberOfMessageSend = sendedMessNum;
		numberOfSurveys = surveyNum;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getPhoneNumber() {
		return PhoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getNumberOfAnnouncements() {
		return numberOfAnnouncements;
	}


	public void setNumberOfAnnouncements(int numberOfAnnouncements) {
		this.numberOfAnnouncements = numberOfAnnouncements;
	}


	public int getNumberOfMessageReceived() {
		return numberOfMessageReceived;
	}


	public void setNumberOfMessageReceived(int numberOfMessageReceived) {
		this.numberOfMessageReceived = numberOfMessageReceived;
	}


	public int getNumberOfMessageSend() {
		return numberOfMessageSend;
	}


	public void setNumberOfMessageSend(int numberOfMessageSend) {
		this.numberOfMessageSend = numberOfMessageSend;
	}


	public int getNumberOfSurveys() {
		return numberOfSurveys;
	}


	public void setNumberOfSurveys(int numberOfSurveys) {
		this.numberOfSurveys = numberOfSurveys;
	}

}
