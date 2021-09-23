package Practice;

import com.vtiger.Altern.GenericUtilities.JSONFileUtility;

public class Demo {
	public static void main(String[] args) throws Throwable {
	JSONFileUtility j =new JSONFileUtility();
	String browser = j.readData("browser");
	String url = j.readData("url");
	String username = j.readData("username");
	String password = j.readData("password");
System.out.println(browser+"\n"+url+"\n"+username+"\n"+password);
		
	}

}
