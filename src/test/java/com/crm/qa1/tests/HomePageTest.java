package com.crm.qa1.tests;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(com.crm.qa.listeners.AllureTestListener.class)
public class HomePageTest extends Testbase {
    LoginPage loginPage;
    HomePage homePage;
    DealsPage dealsPage;

    public HomePageTest() {
        super();
    }

    @BeforeTest
    public void setUp1(){
        System.out.println("this is before test");
        initialization();
        loginPage = new LoginPage(driver);
        homePage = loginPage.login(prop.getProperty("emailID"),prop.getProperty("password"));
    }

    @Test(priority = 1, description = "Validate HomePage title")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testcase Description: Validate Homepage title test")
    @Story("check Homepage title")
    public void validateHomePageTitleTest(){
        String sTitle = homePage.homePageTitle();
        Assert.assertEquals( sTitle,"Cogmento CRM");
    }

    @Test(priority = 2, description = "Validate username label")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testcase Description: Validate username label test")
    @Story("check username on Homepage")
    public void validateUsernameTest(){
        String sUserName = homePage.getUsername();
        Assert.assertEquals( sUserName,prop.getProperty("username"));
    }

    @Test(priority = 3, description = "Validate deals link")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testcase Description: Validate deals link feature")
    @Story("check deals link feature")
    public void validateDealsLinkTest(){
        dealsPage = homePage.ckickDealsLink();
    }
    
    
    @AfterTest
    public void tearDown(){
		driver.quit();
    }

}


