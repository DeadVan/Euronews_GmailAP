package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    public MainPage() {
        super(By.xpath("//a[@aria-label='Euronews Logo']//h1//*[name()='svg']"), "euronews logo");
    }

    private final IButton acceptCoockiesBtn = getElementFactory().getButton(By.id("didomi-notice-agree-button"),"accept coockies button");
    private final IButton NewslettersBtn = getElementFactory().getButton(By.xpath("//span[contains(@class,'u-margin-start-1')][normalize-space()='Newsletters']"),"Newsletters Button");

    public void clickAcceptBtn(){
        acceptCoockiesBtn.click();
    }
    public void clickNewslettersBtn(){
        NewslettersBtn.click();
    }


}
