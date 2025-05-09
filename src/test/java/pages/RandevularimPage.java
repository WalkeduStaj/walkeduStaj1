package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandevularimPage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(RandevularimPage.class);

    public final By randevularimLink = By.xpath("//a[text()='Randevularım']");
    /**
     * Constructor for BasePage.
     * Initializes WebDriver, WebDriverWait, and JavaScriptExecutorHelper.
     *
     * @param driver WebDriver instance to be used
     */
    public RandevularimPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void navigateToPage() {

    }

}
