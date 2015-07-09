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
        //Nasýr: APA91bGgDvdqP26Lhqs2FggfeFYvcYR1JfKNh10eyHj5uhQxDgZPL1wspuaj9U6KpQUQChXn3IymsnEe29YCNCXjYe1tqpvMyFaX8_S1eOulAYLmz9mPOQ7pmot1MTJh9I1bnI097AoRskQm6doC3mNr88flloWcJA
        //Lütfü: APA91bHoxBH3EVWZzGVpJhzjH4XxbM_HrTiyCmS7UWfNJgerbaDVHuv7oReFfkhsl2puuf8mUUYYhn66ZtaXQyPtqYAxmIe9lL3eXbPTK_vApBlPI57ijoNAA9I8OvhRYfv2wgm8EDzwj-0U1JkL6nilrlor9i_iGQ"
        //Oðuzhan:APA91bHkaGV5L-DkPX4EcyyIT5fVD01NX-yvPYmHKjwazvlkx2xOeiHjRU2NiXUstHtShabGSiFl9lQchxGRIZUwymD_fbQ0V8wZOSw066w0K14cOpnyyYusjJ_e0MmSFvk6mY3EhCUUUdF8ElPnifveJbrRBD923w
        //Iþýtan: APA91bHDstsFF4B5J9wNuL1VXgeJqxDLcV4OyOmZjMQIs1MIjnYd9H_NpxKfumemQu-Wnac2wXMOT8ieWBlwEFN60WhUJB32mJb9w6_ppQkevlQTwledvmbRAdKxgMWEzd5ZVTPA8qW4rhLJI08-iCqr4FrQCWRdmg
        //MYTest: APA91bFi1uyGRvIsl3-NmtNhhduImW_VJ7uYZqv2c82_C6kuU9Gjlm-pFrQf-HqUgdE3vpCGqZ8FPJdFDbpOqKAVI_8AVHoEdPLh8u8OPBBostD0ILUeqC4SKTP87eR4eFGAlHxsr3V27_cP3PEMbbdRi5cVPj713Q
        c.addRegId(ID);
        c.createData(message, "Test Message");
        
        return c;
    }
}