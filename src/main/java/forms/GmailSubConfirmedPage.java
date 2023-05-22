package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GmailSubConfirmedPage extends Form {

    public GmailSubConfirmedPage() {
        super(By.xpath("//img[@alt='newsletter checked icon']"), "Acceptation icon");
    }
    private final IButton backToSiteBtn = getElementFactory().getButton(By.xpath("//a[@aria-label='Back to the site']"),"Back to the site Button");

    public void clickbackToSiteBtn(){
        backToSiteBtn.click();
    }
}
