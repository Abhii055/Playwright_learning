package testcases;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Handling_CheckBox {

	public static void main(String[] args) {
		
		ArrayList<String> al=new ArrayList<String>();
		al.add("--start-maximized");
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(al));
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page= context.newPage();
		page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		
		Locator Checkboxes = page.locator("[type='checkbox']");
		int total_checkbox=0;
		for(int i =0; i<=Checkboxes.count()-1;i++) {
			if((i!=4)&&(i!=7)) {
			Checkboxes.nth(i).click();
			}
			total_checkbox=Checkboxes.count();
		}
	System.out.println(total_checkbox);
	}

}
