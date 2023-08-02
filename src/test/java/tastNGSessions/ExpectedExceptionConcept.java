package tastNGSessions;


import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	String name;
	@Test(expectedExceptions = {ArithmeticException.class,NullPointerException.class} )
	public void searchTest() {
		System.out.println("searchTest");
		int i= 9/0;
		ExpectedExceptionConcept obj = new ExpectedExceptionConcept();
		obj=null;
		//obj.name = "sneha";
		System.out.println(obj);
		System.out.println(i);
	}
	

}
