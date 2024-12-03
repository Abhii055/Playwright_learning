package testcases;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.TypeOptions;
import com.microsoft.playwright.Playwright;

public class truvideoLogin {

	public static void main(String[] args) throws InterruptedException {
		Playwright pw =Playwright.create();  // created playwright object
		
		
		ArrayList<String> al = new ArrayList<String>();// storing string to maximize screen
		al.add("--start-maximized");
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(al)); // launching chrome
		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));//this is used to maximize the window no direct methods like maximize in selenium
		
		Page page= context.newPage(); // new page opens up
		page.navigate("https://rc.truvideo.com");// navigate to specific URL
		
//		page.type("//input[@name='j_username']","abhinav.dwivedi@5exceptions.com",new TypeOptions().setDelay(100));
		page.locator("//input[@name='j_username']").type("abhinav.dwivedi@5exceptions.com");
		page.type("//input[@name='j_password']", "AbhinavYamaha", new TypeOptions().setDelay(100));
		
		page.locator("//input[@value=\"Log In\"]").click();
		Thread.sleep(3000);
		page.locator("//a[@href='/crud/repair-order']").click();
		Thread.sleep(5000);
		page.locator("//button[@id='repair-order-add']").click();
		Thread.sleep(5000);
		page.locator("(//div[@class='selected-flag'])[1]").click();
		Thread.sleep(2000);
//		page.locator("(//li[@data-country-code='ca'])[1]").click();
	// document.querySelector("#iti-item-ca")	

		boolean canadaFound = false;
		List<ElementHandle> values2 = page.querySelectorAll("//ul[@id='country-listbox']/li");
				
				System.out.println(values2.size());
			
				for (ElementHandle val : values2) {
				    String countryName = val.innerText().trim();
				    String coString = countryName.replaceAll("\\+\\d+", "").trim();
				    

				    if (coString.equalsIgnoreCase("Canada")) {
				        System.out.println("Canada found. Scrolling into view and clicking...");
				        
				        
				        if (val.isVisible()) {
				            val.click();
				            canadaFound = true;
				            break;
				        } else {
				            System.out.println("Element for Canada is not visible.");
				        }
				    }
				}

				// Handle case where Canada is not found
				if (!canadaFound) {
				    System.out.println("Canada not found in the list.");
				}
				

	}}


