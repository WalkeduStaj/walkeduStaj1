package steps;
import io.cucumber.java.en.*;
import model.LoginBody;
import utilities.ValidTestData;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;

public class KisiselBilgilerSteps extends BaseSteps{
    LoginBody loginBody;
    // Page sınıfımızı burada kullanıyoruz

    @Given("Kullanici Login Sayfasina gider")
    public void kullaniciLoginSayfasinaGider() {
        pageManager.loginPage.navigateToPage();
    }
    
    @And("Kullanici login formunu gecerli verilerle doldurur")
    public void kullaniciLoginFormunuGecerliEmailVeSifreIleDoldurur() {
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.validInstructorEmail);
        loginBody.setPassword(ValidTestData.validInstructorPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);
    }

    @When("Kullanici Login Sayfasinda Giris Yap butonuna tiklar")
    public void kullaniciLoginSayfasindaGirisYapButonunaTiklar() {
        pageManager.loginPage.clickSubmitButton();
    }

    @And("Kişisel Bilgiler menüsünü tıklar")
    public void kişiselBilgilerMenüsünüTıklar() {
        pageManager.kisiselBilgilerPage.clickKisiselBilgilerMenu();
    }

    @When("Kullanici unvan dropdownu tiklar")
    public void kullaniciUnvanDropdownuTiklar() {
        pageManager.kisiselBilgilerPage.clickUnvanDrop();
    }

    @And("Kullanici unvanini secer")
    public void kullaniciUnvaniniSecer() {
        pageManager.kisiselBilgilerPage.clickDocDr();
    }

    @When("Kullanici cinsiyet dropdownu tiklar")
    public void kullaniciCinsiyetDropdownuTiklar() {
        pageManager.kisiselBilgilerPage.genderClickDrop();
        
    }

    @And("Kullanici cinsiyetini secer")
    public void kullaniciCinsiyetiniSecer() {
        pageManager.kisiselBilgilerPage.clickKadin();
    }


    @When("Kullanici kisinin bilgilerini dinamik olarak doldurur")
    public void kullaniciBilgileriniDinamikOlarakDoldurur(DataTable table) {
        // DataTable'dan başlıkları çıkartıyoruz ve yalnızca veri satırlarını alıyoruz
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        // Debug: DataTable'daki verileri kontrol et
        for (Map<String, String> row : rows) {
            String fieldName = row.get("Field");
            String value = row.get("Value");
            System.out.println("Field: " + fieldName + ", Value: " + value);
        }

        // Verilerle işlem yapıyoruz
        for (Map<String, String> row : rows) {
            String fieldName = row.get("Field");
            String value = row.get("Value");
            pageManager.kisiselBilgilerPage.fillField(fieldName, value);
        }
    }
    @And("doldurulan bilgiler Bilgileri Güncelle butonuna basarak güncellenir")
    public void doldurulanBilgilerBilgileriGüncelleButonunaBasarakGüncellenir() {
        pageManager.kisiselBilgilerPage.clickGuncelleButton();
    }

}
