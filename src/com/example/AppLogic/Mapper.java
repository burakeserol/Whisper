package com.example.AppLogic;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class Mapper {
	
	public void writeValue( OutputStream out, Content content)
	{
		String temp = "{\"registration_ids\":[\"";
		temp += content.registration_ids.get(0);
		temp += "\"],\"data\":{\"message\":\"";
		temp += content.data.get("message");
		temp += "\",\"title\":\"";
		temp += content.data.get("title");
		temp += "\"}}";
		try {
			out.write(temp.getBytes(Charset.forName("UTF-8")));
		} catch (IOException e) {
			System.err.println("IOException in Mapper");
		}
	}
}
