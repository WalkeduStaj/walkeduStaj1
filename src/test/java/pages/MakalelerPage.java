package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class MakalelerPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(MakalelerPage.class);

    private final By makaleHeadText = By.xpath("//h1[contains(text(),'Makaleler')]");

    public final By makaleLink = By.xpath("//a[text()='Makaleler']");
    public final By kategoriSecinizMakale = By.xpath("//button[@role='combobox' and contains(., 'Kategori Seçiniz')]");
    public final By oyunTerapisiMakaleClick = By.xpath("//div[@role='option' and normalize-space()='Oyun Terapisi']\n");
    public final By kategoriTuruOyunTerapisi = By.xpath("//table//tr[td[text()='Oyun Terapisi']]");
    public final By makalelerFiltreTemizle = By.xpath("//button[text()='Filtreleri Temizle']\n");
    public final By makaleler10Tane = By.xpath("(//table/tbody/tr)[10]/td[1]");
    public final By makalelerDuzenle = By.xpath("//div[starts-with(@id, 'radix-') and contains(@id, '-content-Makaleler')]//table/tbody/tr[1]/td[6]/button");
    public final By makalelerDuzenleSayfasi = By.xpath("/html/body/section/article/div[2]/h2\n");
    public final By makalelerSilButon = By.xpath("//table//tr[1]//td[last()]//button\n");
    public final By makalelerOnayliyorumButon = By.xpath("//div[@role='dialog']//button[contains(text(), 'Onaylıyorum')]");
    public final By makaleSilPopupContainer = By.xpath("//div[@role='dialog' and contains(@class, 'fixed')]\n");


    public MakalelerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void navigateToPage() {//login olmadanki durumlarda kullanabilirim
//        driver.get(URLs.LOGIN_URL.getUrl());
//        waitForPageLoad();
//        logger.info("Kullanici makaleler sayfasina ulasir.");
    }


    public boolean isAtMakalelerPage() {//direkt locati displayed içine kullanamayız web elementine cevirmek lazım.
        waitForElementVisible(makaleHeadText);
        try {
            return driver.findElement(makaleHeadText).isDisplayed();
        } catch (Exception e) {
            logger.error("Makaleler sayfasi yüklenemedi.", e);
            return false;
        }
    }

    public void clickMakalelerButton() {
        logger.info("Makaleler butonuna tıklar");
        clickWithJS(makaleLink);
    }

    public void clickMakaleKategoriSecimi() {
        logger.info("Kategori secim dropdowna tıklar");

        // Sayfa yüklendi mi? Başlık geldi mi? Önce onu kontrol et
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Makaleler')]")));

        // Sonra dropdown araması
        By dropdownLocator = By.xpath("//*[contains(text(),'Kategori Seçiniz')]");

        wait.until(ExpectedConditions.presenceOfElementLocated(dropdownLocator));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        clickWithJS(dropdown);

        // Test amaçlı bekleme (geçici)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), 'Oyun Terapisi')]"));
        System.out.println("GELEN SEÇENEK SAYISI: " + elements.size());
    }

    public void clickOyunTerapisi() {
        logger.info("Dropdown kontrol testi");

        // Sadece seçenekleri kontrol et ve tıkla
        List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//*[contains(text(), 'Oyun Terapisi')]")
        ));

        System.out.println("GELEN DROPDOWN SEÇENEK SAYISI: " + options.size());

        for (WebElement e : options) {
            System.out.println("Seçenek: '" + e.getText().trim() + "', Görünür mü: " + e.isDisplayed());
            if (e.getText().trim().equalsIgnoreCase("Oyun Terapisi") && e.isDisplayed()) {
                clickWithJS(e); // veya e.click();
                System.out.println("Oyun Terapisi seçeneğine tıklandı.");
                return;
            }
        }

    }



    public boolean makalelerOyunTerapisi() {
        logger.info("Kategori secimden sonra listede oyun terapisi makalelerini gorur");
        waitForElementVisible(kategoriTuruOyunTerapisi);
        return driver.findElement(kategoriTuruOyunTerapisi).isDisplayed();
    }

    public void clickMakaleFiltreTemizle() {
        logger.info("filtre temizle butonu tıklar");
        clickWithJS(makalelerFiltreTemizle);
    }

    public boolean makaleler10Tane() {
        logger.info("Kategori secimden sonra listede oyun terapisi makalelerini gorur");
        waitForElementVisible(makaleler10Tane);
        return driver.findElement(makaleler10Tane).isDisplayed();
    }

    public void clickMakaleDuzenle() {
        logger.info("makaleler listesinde düzenle butona tıklar");
        //  waitForElementVisible(oyunTerapisiMakaleClick);
        clickWithJS(makalelerDuzenle);
    }

    public boolean makaleDuzenleSayfasindayim() {
        logger.info("makale düzenle sayfasindaki makale düzenle header görülür");
        waitForElementVisible(makalelerDuzenleSayfasi);
        return driver.findElement(makalelerDuzenleSayfasi).isDisplayed();

    }

    public void clickMakaleSil() {
        logger.info("makaleler listesinde sil butona tıklar");
        //  waitForElementVisible();
        clickWithJS(makalelerSilButon);
    }

    public void clickMakaleSilOnay() {
        logger.info("makaleler listesinde silme islemini onayliyoruma tıklar");
        // 1. Popup açıldığından emin ol (opsiyonel ama önerilir)
        waitForElementVisible(makaleSilPopupContainer);

        // 2. Onaylıyorum butonuna tıkla
        waitForElementVisible(makalelerOnayliyorumButon);
        clickWithJS(makalelerOnayliyorumButon);
    }

//    public final By adminPaneliButton = By.xpath("//a[text()='Admin Paneli']");
//    public final By odemelerButton = By.xpath("//a[text()='Ödemeler']");
//    public void clickAdminPaneliButton() {
//        logger.info("Admin Paneli butonuna tıklar");
//        driver.findElement(adminPaneliButton).click();
//    }
//
//    public void clickOdemelerButton() {
//        logger.info("Ödemeler butonuna tıklar");
//        driver.findElement(odemelerButton).click();
//    }
}
