package com.vtiger.Altern.GenericUtilities;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

/**
 * This file having the genric method to read and write the date from property file.
 * @author sanje
 *
 */
public class PropertyFileUtility {
/**
 * this method reads data from the property file
 * @throws IOException 
 */
	public String getPropertyFileData(String key) throws IOException
	{
	FileInputStream fis =new FileInputStream(IPathConstants.propertyFilePath);
	Properties p=new Properties();
	p.load(fis);
	String Pr = p.getProperty(key);
	return Pr;
	}
	
}


