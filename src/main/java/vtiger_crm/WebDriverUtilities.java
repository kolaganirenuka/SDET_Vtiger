package vtiger_crm;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class WebDriverUtilities {
	public void pageloadtimeouts(WebDriver driver) {

 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
	public void selectfromdd(WebElement element,int Index) {
		Select sel=new Select(element);
		sel.selectByIndex(Index);
	}
	public void selectfromdd(String text, WebElement element) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void selectfromdd(WebElement element, String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
}
	public void actionelement(WebDriver driver, WebElement target) {
		Actions action=new Actions(driver);
		action.moveToElement(target).build().perform();
	}
	public void windowhandles(WebDriver driver, String title) {
		Set<String> allwin = driver.getWindowHandles();
		for (String string : allwin) {
			String currenttitle = driver.switchTo().window(string).getTitle();
			if(currenttitle.contains(title)) {
				break;
			}
		}
	}
}
