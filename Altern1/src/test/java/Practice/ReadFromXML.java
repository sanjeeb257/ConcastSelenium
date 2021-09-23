package Practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
 public class ReadFromXML
 {
@Test

public void readdatafromXML(XmlTest xmlobj)
{
	System.out.println(xmlobj.getParameter("Browser"));
}
 }


