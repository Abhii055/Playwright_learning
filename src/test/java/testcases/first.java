package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class first {

    public static void main(String[] args) throws InterruptedException {
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	double height = screenSize.getHeight();
    	double width =screenSize.getWidth();
        
        Playwright playwright = Playwright.create();
        
        
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width,(int)height));
        System.out.println(height+","+width);
        Page page = context.newPage();
        
        page.navigate("https://rc.truvideo.com");
        
        String title = page.title();
        System.out.println("Page Title: " + title);
        
        Thread.sleep(5000);
        
        page.close();
        browser.close();
        playwright.close();
    }
}

//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//double width = screenSize.getWidth();
//double height = screenSize.getHeight();
//
//System.out.println(width+"---"+height);
//
//Playwright playwright = Playwright.create();
//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
//
////Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
//BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
//Page page = browserContext.newPage();
//page.navigate("http://way2automation.com");
//System.out.println(page.title());
//Thread.sleep(2000);
////page.close();
////playwright.close();