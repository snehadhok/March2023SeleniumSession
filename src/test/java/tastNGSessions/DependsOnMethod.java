package tastNGSessions;

import org.testng.annotations.Test;

public class DependsOnMethod {
	@Test
	public static void loginTest(){
		System.out.println("login to app");
		int i = 9/0;
		System.out.println(i);
	}
	@Test(dependsOnMethods = "loginTest")
	public static void appSearchTest() {
		System.out.println("searchTest");
	}
	@Test(dependsOnMethods = "appSearchTest")
	public static void selectProductTest() {
	System.out.println("selectProductTest");	
	}

	//CRUD - ADD/GET/Update/Delete
	
	//login--> homepage--> search --> cart ---> payment -- test
	//login--> homepage--> search2 --> cart ---> payment -- test

	
	


}
