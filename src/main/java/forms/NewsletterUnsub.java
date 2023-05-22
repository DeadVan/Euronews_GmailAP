package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class NewsletterUnsub extends Form {
    public NewsletterUnsub() {
        super(By.xpath("//img[contains(@class,'unsubscribe-logo')]"),"euronews logo");
    }
    private final ITextBox emailAddress = getElementFactory().getTextBox(By.xpath("//input[contains(@id,'email')]"),"type email address bar");
    private final IButton confirmUnsubBtn = getElementFactory().getButton(By.xpath("//button[contains(@type,'submit')]"),"Confirm Unsubscription");
    private final ILabel unsubLabel = getElementFactory().getLabel(By.xpath("//strong[normalize-space()='You are unsubscribed.']"),"Unsub Label");

    public NewsletterUnsub fillEmailAddress(final String mail){
        emailAddress.clearAndType(mail);
        return this;
    }
    public void clickConfirmUnsubBtn(){
        confirmUnsubBtn.click();
    }
    public boolean unsubLabelIsdisplayed(){
        return unsubLabel.state().isDisplayed();
    }


}


