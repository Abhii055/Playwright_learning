package testcases;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class open_in_incognito {///chromium opens in incognito by default and when we pass chrome and edge by using setChannel function then it opens in open enviroment.

	public static void main(String[] args) throws InterruptedException{
	Playwright pw =  Playwright.create();
	
	ArrayList<String> al = new ArrayList<String>();
	al.add("--start-maximized");
	
	Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(al));
	
	
	BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));//this is used to maximize the window no direct methods like maximize in selenium
	
	Page page= context.newPage();
	page.navigate("https://rc.truvideo.com/crud/repair-order");
	 String str2= page.title();
     System.out.println("Page Title2: " + str2);
     
     page.navigate("https://www.battlegroundsmobileindia.com/");
     Thread.sleep(3000);
     String str1 =page.title();
     System.out.println("Page Title 1: "+str1);
     
     page.goBack();
     
     page.navigate("https://www.facebook.com/");
     Thread.sleep(3000);
     String str3 =page.title();
     System.out.println("Page Title 3: "+str3);
     page.goBack();
     Thread.sleep(4000);
     page.goBack();
     Thread.sleep(500);
     page.goForward();
     
	
	}

}
