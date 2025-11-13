package com.XIPerformer.util;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.JsonParser;

public class json_data {
	public JSONObject testdata=null;
	public JSONArray jsonarray;
	
	
public JSONObject getdatafile(String filename,int i) {
	
	String datafilepath = "./JSON Test Data/testdata.json";
	try {
		FileReader fi = new FileReader(datafilepath);
		JSONParser parser = new JSONParser();
	Object obj =parser.parse(new InputStreamReader(new FileInputStream(datafilepath), StandardCharsets.UTF_8));
	JSONArray jsonobj = (JSONArray)obj;
	 testdata = (JSONObject) jsonobj.get(i);
		
	} catch (Exception e) {
		System.out.println();
	}
	return(testdata);
	
}
	
	
	
	

}
