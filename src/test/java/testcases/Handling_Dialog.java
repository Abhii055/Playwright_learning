package testcases;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Handling_Dialog {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright pw = Playwright.create();
		ArrayList<String> al = new ArrayList<String>();// storing string to maximize screen
		al.add("--start-maximized");
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(al)); // launching chrome
		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));//this is used to maximize the window no direct methods like maximize in selenium
		
		Page page= context.newPage(); // new page opens up
		page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");// navigate to specific URL
		page.onDialog(dialog ->{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
			dialog.accept();
			System.out.println(dialog.message());
		}
		);
			page.locator("input[Type='submit'][title='Sign in']").click();
	
	}
	

}
