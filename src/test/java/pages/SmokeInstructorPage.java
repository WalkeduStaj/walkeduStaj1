package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.URLs;

import java.time.Duration;

public class SmokeInstructorPage extends BasePage{
    /**
     * Constructor for BasePage.
     * Initializes WebDriver, WebDriverWait, and JavaScriptExecutorHelper.
     *
     * @param driver WebDriver instance to be used
     */
    public SmokeInstructorPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void navigateToPage() {
        driver.get(URLs.BASE_URL.getUrl());
        waitForPageLoad();
        logger.info("Kullanici ana sayfaya ulasir.");
    }
    private static final Logger logger = LoggerFactory.getLogger(SmokeInstructorPage.class);
    //private final By anaSayfadakiGirisYapButon = By.xpath("/html/body/nav/nav/div[1]/div/div[3]/div/a[1]/button");
    private final By anaSayfadakiGirisYapButon = By.xpath("//nav//button[contains(text(), 'Giriş Yap')]");
    private final By submitButton = By.cssSelector("button[type='submit']");

    private final By cikisYapLink = By.xpath("//p[contains(@class, 'text-rose-700') and span[text()='Çıkış']]");

    public void clickGirisYapButton() {
        logger.info("giris yap butonuna tıklar");
        clickWithJS(anaSayfadakiGirisYapButon);
    }

    public boolean anasayfadakiGirisYapGoruntulenir() {
        waitForPageLoad();
        return driver.findElement(anaSayfadakiGirisYapButon).isDisplayed();
    }

    public void assertUrlGiris() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/giris"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login sayfasına yönlendirilmedi. Mevcut URL: " + currentUrl,
                currentUrl.contains("/giris"));
    }
    public void clickSubmitButton() {
        logger.info("Clicking submit button");
        clickWithJS(submitButton);
        waitForPageLoad();
    }
    public void clickCikisYapLink() {
        logger.info("cikis yap butonuna tıklar");
        clickWithJS(cikisYapLink);
    }
}
