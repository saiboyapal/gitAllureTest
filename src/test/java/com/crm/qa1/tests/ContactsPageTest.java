package com.crm.qa1.tests;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
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
public class ContactsPageTest extends Testbase{
    LoginPage loginPage;
    HomePage homePage;
    DealsPage dealsPage;
    ContactsPage contactsPage;

    public ContactsPageTest() {
            super();
    }

    @BeforeTest
    public void setUp(){
        System.out.println("this is before method");
        initialization();
        loginPage = new LoginPage(driver);
        homePage = loginPage.login(prop.getProperty("emailID"),prop.getProperty("password"));
        contactsPage = homePage.cickContactsLink();
    }

    @Test(priority = 1, description = "Validate Contacts page header")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testcase Description: Validate contacts header test")
    @Story("check contacts header")
    public void validateHeaderTest(){
        String sHeader = contactsPage.getHeader();
        Assert.assertEquals(sHeader,"Contacts");
    }

    @Test(priority = 3, description = "Validate Contacts table")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testcase Description: Validate contacts label test")
    @Story("check contacts table")
    public void validateContactsTable(){
        contactsPage.getTableData();
        Assert.assertTrue(contactsPage.tableVisible());
    }
    
    @AfterTest
    public void tearDown(){
		driver.quit();
    }

}
