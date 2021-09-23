package Practice;

public class Test {
		
		private static Test t=null;
		
		private Test()
		{
			
		}
	
		 
		 public static Test getTest()
		 {
			 if(t==null)
			 {
				 t=new Test();
			 }
			 return t;
		 }
		 
		 public static void main(String[] args)
		 {
			 Test t=Test.getTest();
			 Test t2=Test.getTest();
			 Test t3=Test.getTest();
			 Test t4=Test.getTest();
			 
			 System.out.println(t==t2);
			 System.out.println(t3==t2);
			 System.out.println(t4==t2);
		 }
		 
		 
	}


