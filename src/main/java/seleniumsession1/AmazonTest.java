package seleniumsession1;

public class AmazonTest {

	public static void main(String[] args) {
		BrowserUtil brutil = new BrowserUtil();
		brutil.launchBrowser("chrome");
		brutil.enterurl("https://www.amazon.com");
		
		
		
		String actTitle = brutil.getpagetitle();
		System.out.println(actTitle);
		if (actTitle.contains("Amazon")) {
			System.out.println("correct title");
		} else {
			System.out.println("in-correct title");

		}

		String actUrl = brutil.getpageurl();
		System.out.println(actUrl);
		if (actUrl.contains("amazon")) {
			System.out.println("correct url");
		} else {
			System.out.println("in-correct url");

		}

		brutil.closebrowser();

	}

}
