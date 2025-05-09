package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.URLs;


public class AdminPage extends NavbarPage {


    public static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public final By sonrakiButton = By.xpath("//*[text()='Sonraki']");

    public final By kurumsalBFTumBasvurularButton = By.xpath("//*[text()='Tüm Başvurular']");

    public final By kurumsalBFBasvuruGoruntulemeButton = By.xpath("(//*[text()='Başvuru Görüntüleme'])[2]");

    public final By abdulfettahSahinButton = By.xpath("//*[text()='Abdulfettah Şahin']");

    public final By detayliAramaKutusu = By.xpath("//*[@placeholder='Detaylı Arama']");

    public final By sirketBasvuruFormuYazisi = By.xpath("//*[text()='Şirket Başvuru Formu']");

    public final By cikisButtonHesabim = By.xpath("(//*[text()='Çıkış'])[1]");

    public final By inceleButtonYeniDunya = By.xpath("(//*[text()='İncele'])[3]");

    public final By saatBaslikButton = By.xpath("//*[text()='Saat']");

    public final By uzmanArsivisayfasi = By.xpath("(//*[text()='Uzman Arşivi'])[3]");

    public final By zeynepKalkanUzman = By.xpath("//*[text()='Zeynep Kalkan']");

    public final By filtreleriTemizleButonu = By.xpath("//*[text()=' Filtreleri Temizle']");


    /*
        public final By kurumsalBFTumBasvurularButton = By.xpath("//*[text()='Tüm Başvurular']");
        public final By kurumsalBFBasvuruGoruntulemeButton = By.xpath("(//*[text()='Başvuru Görüntüleme'])[2]");
        public final By abdulfettahSahinButton = By.xpath("//*[text()='Abdulfettah Şahin']");
        public final By detayliAramaKutusu = By.xpath("//*[@placeholder='Detaylı Arama']");
        public final By sirketBasvuruFormuYazisi = By.xpath("//*[text()='Şirket Başvuru Formu']");
        public final By cikisButtonHesabim = By.xpath("(//*[text()='Çıkış'])[1]");
        public final By inceleButtonYeniDunya = By.xpath("(//*[text()='İncele'])[3]");
    */
    public final By alicanCananButton = By.xpath("//*[text()='Alican Canan']");
    public final By profiliInceleButton = By.xpath("//*[text()='Profili İncele']");
    public final By profilDetaylariButonu = By.xpath("//*[text()='Profil Detayları']");
    public final By uyeArsıvıneGeriDonButon = By.xpath("//*[text()='Üye Arşivine Geri Dön']");


    @Override
    public void navigateToPage() {
        driver.get(URLs.BASE_URL.getUrl());
    }

    public boolean isDisplayed(By locator) {
        waitForElementVisible(locator);
        return driver.findElement(locator).isDisplayed();
    }


    public final By homepageGirisYapButon = By.xpath("(//*[text()='Giriş Yap'])[1]");

    public final By kayitOlButon = By.xpath("//*[text()='Kayıt Ol!']");

    public void homepageGirisYap() {
        click(homepageGirisYapButon);
    }

    public final By basarisizPasswordText= By.xpath("(//*[@class='text-red'])[3]");
    public final By cikisButton = By.xpath("//*[text()='Çıkış']");
}




