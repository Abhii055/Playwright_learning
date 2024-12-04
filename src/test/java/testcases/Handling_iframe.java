package testcases;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle.ClickOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Handling_iframe {

	public static void  main(String[] args) throws InterruptedException {
Playwright pw =Playwright.create();  // created playwright object
		
		
		ArrayList<String> al = new ArrayList<String>();// storing string to maximize screen
		al.add("--start-maximized");
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(al)); // launching chrome
		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));//this is used to maximize the window no direct methods like maximize in selenium
		
		Page page= context.newPage(); // new page opens up
		System.out.println("Open");
		page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		page.waitForTimeout(30000);// navigate to specific URL
		System.out.println("Open");
		Thread.sleep(2000);
		FrameLocator frame= page.frameLocator("iframe#iframeResult");
		Thread.sleep(4000);
		System.out.println("HEll");
		frame.locator("button:has-text('Try it')").click(); 
		System.out.println("sumbit");
//		frame.locator("button[onClick='myFunction()']").click();
	}
}
