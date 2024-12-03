package testcases;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Maximize_fun {

	public static void main(String[] args) throws InterruptedException {
				
		Playwright pw = Playwright.create();
		
		ArrayList<String> al=new ArrayList<>();
		al.add("--start-maximized");
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setArgs(al));
			
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		
		Page page = context.newPage();
		
page.navigate("https://rc.truvideo.com");
        
        String title = page.title();
        System.out.println("Page Title: " + title);
        
        Thread.sleep(5000);
        
        page.close();
        browser.close();
        pw.close();
	}

}
