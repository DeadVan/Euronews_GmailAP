package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;

import static Utils.RandNumbUtil.randNumb;

public class NewslettersPage extends Form {
    public NewslettersPage() {
        super(By.xpath("//span[contains(@class,'h1 text-secondary')]"), "Our newsletters label");
    }

    private final ILabel newslettersContainer = AqualityServices.getElementFactory().getLabel(By.id("newsletters-form"), "newsletters Container");
    private final ITextBox mailTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Enter your email')]"),"email entry textbox");
    private final IButton submitBtn = getElementFactory().getButton(By.xpath("//input[contains(@value,'Submit')]"),"submit Button");
    static ILink iframeElement = AqualityServices.getElementFactory().getLink(By.className("iframe-preview"),"Iframe of sletter");


    public void selectRandomSletter() {
        List<IButton> previews = newslettersContainer.findChildElements(By.cssSelector("label.btn-tertiary"), ElementType.BUTTON);
        previews.get(randNumb).click();
    }
    public boolean checkIfEmailFormIsOpen(){
        return mailTextBox.state().isDisplayed();
    }

    public NewslettersPage fillMailInfo(final String mail){
        mailTextBox.clearAndType(mail);
        return this;
    }
    public void clickSubmitBtn(){
        submitBtn.clickAndWait();
    }
    public void clickSeePreview(){
        List<ILabel> previewBtn = newslettersContainer.findChildElements(By.xpath("//a[contains(., 'Or see previews')]"), ElementType.LABEL);
        previewBtn.get(randNumb).click();
    }
    public static String getPreviewLink(){
        return iframeElement.getAttribute("src");
    }
}
