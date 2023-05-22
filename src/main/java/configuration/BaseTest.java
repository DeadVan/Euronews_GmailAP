package configuration;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import forms.GmailSubConfirmedPage;
import forms.MainPage;
import forms.NewsletterUnsub;
import forms.NewslettersPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import static Utils.SettingsReader.readUrlJson;

public class BaseTest{
    Browser browser = AqualityServices.getBrowser();
    public Browser browser1 = AqualityServices.getBrowser();
    public Browser browser2 = AqualityServices.getBrowser();
    public static MainPage mainPage = new MainPage();
    public static NewslettersPage newslettersPage = new NewslettersPage();
    public static GmailSubConfirmedPage confirmedPage = new GmailSubConfirmedPage();
    public static NewsletterUnsub newsletterUnsub = new NewsletterUnsub();



    @BeforeMethod
    public void setup(){
        browser.maximize();
        browser.goTo(readUrlJson("url"));
        browser.waitForPageToLoad();
    }

    @AfterTest
    public void closeDriver(){
        browser.quit();
    }
}
