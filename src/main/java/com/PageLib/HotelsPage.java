package com.PageLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestMain;

public class HotelsPage extends TestMain{
	@FindBy(xpath = "//table[@width = '492']/tbody/tr/td/img[@width = '492']")
	WebElement UnderConstructionLabel;

	@FindBy(xpath = "//Table[@width = '492']/tbody/tr[3]/td/p/font/b/font[2]")
	WebElement BodyInfo;

	@FindBy(xpath = "//img[@height= '23']")
	WebElement BackToHomeBtn;

	@FindBy(linkText = "Home")
	WebElement HomeLink;

	public HotelsPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean underConstructionLabelIsPresent() {
		return UnderConstructionLabel.isDisplayed();
	}

	public void clickBackToHomeBtn() {
		BackToHomeBtn.click();
	}
	public void clickHomeLink() {
		HomeLink.click();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	public String  validateBodyText() {
		return BodyInfo.getText();
	}
}
