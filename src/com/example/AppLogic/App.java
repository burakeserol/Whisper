package com.example.AppLogic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;


public class App 
{
        public static Content createContent(String message, String ID){
    	        
        Content c = new Content();
        
        //MYTest: APA91bFi1uyGRvIsl3-NmtNhhduImW_VJ7uYZqv2c82_C6kuU9Gjlm-pFrQf-HqUgdE3vpCGqZ8FPJdFDbpOqKAVI_8AVHoEdPLh8u8OPBBostD0ILUeqC4SKTP87eR4eFGAlHxsr3V27_cP3PEMbbdRi5cVPj713Q
        c.addRegId(ID);
        c.createData(message, "Test Message");
        
        return c;
    }
}
