import configuration.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Utils.SettingsReader.readDataJson;
import static forms.GmailQuickstart.*;
import static forms.SletterGetReq.getSletterUnsubLink;


public class EuronewsTest extends BaseTest {
    @Test
    public void euronewsGmailApiTest() {
        mainPage.clickAcceptBtn();
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main Form did not open");
        mainPage.clickNewslettersBtn();
        Assert.assertTrue(newslettersPage.state().isDisplayed(),"Newsletters form did not open");
        newslettersPage.selectRandomSletter();
        Assert.assertTrue(newslettersPage.checkIfEmailFormIsOpen(),"email form did not open");
        newslettersPage.fillMailInfo(readDataJson("mail"));
        newslettersPage.clickSubmitBtn();
        Assert.assertTrue(isMailExist(readDataJson("euronewMail")),"email subscription did not recieve");
        browser1.goTo(getGmailLink(readDataJson("mailSubj")));
        Assert.assertTrue(confirmedPage.state().isDisplayed(),"Subscription confirmation page did't open");
        confirmedPage.clickbackToSiteBtn();
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main Form did not open");
        mainPage.clickNewslettersBtn();
        newslettersPage.clickSeePreview();
        browser2.goTo(getSletterUnsubLink());
        newsletterUnsub.fillEmailAddress(readDataJson("mail"));
        newsletterUnsub.clickConfirmUnsubBtn();
        Assert.assertTrue(newsletterUnsub.unsubLabelIsdisplayed(),"Didn't display unsub label");
        Assert.assertFalse(isMailExistSubj(readDataJson("mailSubjCancel")),"Info about subscription cancelation is Recieved!");
    }
}
