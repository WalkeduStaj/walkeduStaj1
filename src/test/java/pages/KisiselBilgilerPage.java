package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.URLs;
public class KisiselBilgilerPage extends BasePage {
    public KisiselBilgilerPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void navigateToPage() {
        driver.get(URLs.LOGIN_URL.getUrl());
    }
    public final By unvanDropdown = By.xpath("//label[text()='Ünvan']");
    public final By genderMenuDrop = By.xpath("//label[text()='Cinsiyet']");
    public final By adSoyadLocator = By.xpath("//input[@id='name']");
    public final By yasInput = By.xpath("//input[@id='age']");
    public final By emailLocator = By.xpath("//input[@id='email']");
    public final By telefonLocator = By.xpath("//input[@id='tel']");

    private By kisiselbilgilerlink = By.xpath("//a[text()='Kişisel Bilgiler']");
    private By güncelleButon = By.xpath("/html/body/div[2]/div[3]/div/div[2]/form[2]/button");
    private By docdr = By.xpath("/html/body/div[2]/div[3]/div/div[2]/form[2]/div/div[1]/select/option[1]");
    private By kadin =By.xpath("/html/body/div[2]/div[3]/div/div[2]/form[2]/div/div[4]/button/span");
    public void clickUnvanDrop(){
        clickWithJS(unvanDropdown);
    }
    public void clickDocDr(){
        clickWithJS(docdr);
    }
    public void genderClickDrop(){
        clickWithJS(genderMenuDrop);
    }
    public void clickKadin(){
        clickWithJS(kadin);
    }
    public void clickKisiselBilgilerMenu() {

        clickWithJS(kisiselbilgilerlink);
    }
    public void clickGuncelleButton() {
        clickWithJS(güncelleButon);
    }
    public void fillField(String fieldName, String value) {
        // getFieldLocator metodu ile doğru locator'ı al
        By locator = getFieldLocator(fieldName);

        // WebElement bul ve değeri gir
        WebElement inputField = driver.findElement(locator);
        inputField.clear();  // Önceki değeri temizle
        inputField.sendKeys(value);  // Yeni değeri yaz
    }
    public By getFieldLocator(String fieldName) {
        switch (fieldName.toLowerCase()) {  // Field'ı küçük harfe dönüştürüyoruz
            case "adsoyad":
                return adSoyadLocator;  // AdSoyad input locator'ı
            case "yas":
                return yasInput;  // Yas input locator'ı
            case "e-posta":
                return emailLocator;  // Eposta input locator'ı
            case "telefon":
                return telefonLocator;  // Telefon input locator'ı
            default:
                throw new IllegalArgumentException("Geçersiz alan adı: " + fieldName);  // Hatalı input kontrolü
        }
    }
}
