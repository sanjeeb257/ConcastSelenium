package com.vtiger.Altern.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * Its contain geniric methods pertainning to java
 * @author sanjeeeb
 *
 */

public class JavaUtility {
/**
 * This method generate random numbers
 */
	public int getRandomNum()
	{
		Random rn=new Random();
		int randomnum = rn.nextInt();
		return randomnum;	
	}
	
	public String getDate()
	{
		Date d=new Date();
		String date = d.toString().replace(":", "-");
		return date;
		
	}
	
}
