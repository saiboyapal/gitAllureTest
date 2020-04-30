package com.crm.qa.pages;

import com.crm.qa.base.Testbase;

import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Testbase {
	WebDriver driver;
	
    //WebElements
    @FindBy(xpath="//span[@class='user-display']")
    WebElement usernameLabel;

    @FindBy(xpath="//span[text()='Calendar']")
    WebElement calendarLink;

    @FindBy(xpath="//span[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath="//span[contains(text(),'Companies')]")
    WebElement companiesLink;

    @FindBy(xpath="//span[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath="//span[contains(text(),'Tasks')]")
    WebElement tasksLink;


    //initialize the page elements
    public HomePage (WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    @Step("Getting login page title step ....")
    public String homePageTitle() {
        return driver.getTitle();
    }

    @Step("Getting username on loginpage step ....")
    public String getUsername() {
        return usernameLabel.getText();
    }

    @Step("Clicking deals link step ....")
    public DealsPage ckickDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    @Step("Clicking contacts link step ....")
    public ContactsPage cickContactsLink() {
        contactsLink.click();
        return new ContactsPage(driver);
    }
}
