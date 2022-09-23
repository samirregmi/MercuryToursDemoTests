package com.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class BugTrackers   {
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 20; i++) {
			changeColor("rgb(211,33,45)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].style.border = '3px solid red'", element);
	}

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("alert('" + message + "')");

	}

	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click();", element);
	}

	public static void refresBrowserByJS(WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("history.go(0)");
	}

	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String pagetitle = jse.executeScript("return document.title;").toString();
		return pagetitle;
	}

	public static String getInnerTextOfThePage(WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String pagetext = jse.executeScript("return document.documentElement.innerText;").toString();
		return pagetext;
	}

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
