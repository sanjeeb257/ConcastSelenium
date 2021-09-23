package com.vtiger.Altern.GenericUtilities;


import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

/**
 * This class contains json scripts to retrive the data from json file
 * @author sanje
 *
 */

public class JSONFileUtility {
	/**
	 * This file reads the data from json file 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readData(String key) throws Throwable
	{
		//read the data from json file 
		FileReader file = new FileReader("./commenData.json/");
		//convert the json file into java object 
		JSONParser jobj=new JSONParser();
		
		Object jvobj = jobj.parse(file);
		//typecast java ob to hashmap
		HashMap map= (HashMap)jvobj;
		String p = map.get(key).toString();
		//return the value 
		return p;
		
		
		
		
	}

}
