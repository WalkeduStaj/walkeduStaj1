package pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

/**
 * Page Object Model for the Contact page.
 * Handles all interactions with the contact form and its elements.
 */
public class NavbarPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(NavbarPage.class);

    // Form field locators
    /** Locator for Hesabim button */
    public final By hesabimButton = By.xpath("(//button[@data-state=\"closed\"])[1]");

    public final By uyeArsivi = By.xpath( "//*[text()='Üye Arşivi']");

    public final By kurumsalBasvuruFormlari= By.xpath("//*[text()='Kurumsal Başvuru Formları']");

    public final By uzmanArsiviButton= By.xpath("(//*[text()='Uzman Arşivi'])[1]");

    public final By kurumsalBFTumBasvurularButton= By.xpath("//*[text()='Tüm Başvurular']");

    public final By kurumsalBFBasvuruGoruntulemeButton= By.xpath("(//*[text()='Başvuru Görüntüleme'])[2]");

    public final By abdulfettahSahinButton= By.xpath("//*[text()='Abdulfettah Şahin']");

    public final By detayliAramaKurumsalBF= By.xpath("//*[@placeholder='Detaylı Arama']");

    public final By sirketBasvuruFormuYazisi= By.xpath("//*[text()='Şirket Başvuru Formu']");

    public final By cikisButtonHesabim= By.xpath("(//*[text()='Çıkış'])[1]");

    public final By inceleButtonYeniDunya= By.xpath("(//*[text()='İncele'])[3]");

    /**
     * Constructor for NavbarPage.
     * @param driver WebDriver instance to be used
     */
    public NavbarPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to the contact page.
     * Waits for the page to load completely.
     */
    @Override
    public void navigateToPage() {
        waitForPageLoad();
    }

    /**
     * Check the Hesabim Button is displayed
     */
    public boolean isDiplayedHesabimButton() {
        waitForElementVisible(hesabimButton);
        return driver.findElement(hesabimButton).isDisplayed();
    }
    public void moveToHesabimButton() {
        logger.info("Clicking hesabim button");
        WebElement element= driver.findElement(hesabimButton);
        moveToElement(element);
    }

    public void clickHesabimButton() {
        logger.info("Clicking hesabim button");
        clickWithJS(hesabimButton);
    }

}