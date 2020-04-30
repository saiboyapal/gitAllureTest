package com.crm.qa.pages;

import com.crm.qa.base.Testbase;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Testbase {
	WebDriver driver;
	
    //Webelements
    @FindBy(xpath="//span[contains(text(),'Log In')]")
    WebElement loginBtn;

    @FindBy(xpath="//a[@title='free crm home']")
    WebElement crmLogo;

    @FindBy(name="email")
    WebElement eMail;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//div[text()='Login']")
    WebElement signInBtn;


    //initialize the page elements
    public LoginPage(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Getting login page title step...")
    public String loginPageTitle() {
        return driver.getTitle();
    }

    @Step("Getting CRM logo step...")
    public boolean crmLogDisplayed() {
        return crmLogo.isDisplayed();
    }

    @Step("Login Action with Username : {0} and password : {1} step...")
    public HomePage login(String eMailID, String pwd){
        loginBtn.click();
        eMail.sendKeys(eMailID);
        password.sendKeys(pwd);
        signInBtn.click();
        return new HomePage(driver);
    }

}
