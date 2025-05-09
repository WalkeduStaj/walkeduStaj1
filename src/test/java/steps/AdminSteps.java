package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.LoginBody;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ValidTestData;

import java.time.Duration;

public class AdminSteps extends BaseSteps{

    LoginBody loginBody;
    Actions actions = new Actions(driver);
    @And("kullanici login formu gecerli admin email ve gecerli admin sifre ile doldurur")
    public void kullaniciLoginFormuGecerliAdminEmailVeGecerliAdminSifreIleDoldurur() {
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.adminEmail);
        loginBody.setPassword(ValidTestData.adminPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);
    }
    @Then("{string} Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.")
    public void profiliniGoruntuleyebilecegiHesabimButonunuNavbardaGoruntuler(String arg0) {
        Assert.assertTrue(pageManager.navbarPage.isDiplayedHesabimButton());
    }
    @And("{string} Hesabim butonunun uzerine gelir")
    public void hesabimButonununUzerineGelir(String arg0) {
        pageManager.navbarPage.moveToHesabimButton();
    }
    @Then("Acilan dropdown menüden üye arşivi tiklanir")
    public void acilan_dropdown_menüden_üye_arşivi_tiklanir() {
        pageManager.adminPage.clickWithJS(pageManager.adminPage.uyeArsivi);
    }
    @Then("Admin Üye arşivine ilişkin listeyi görür")
    public void admin_üye_arşivine_ilişkin_listeyi_görür() {
        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.sonrakiButton));
    }

    @When("Detayli arama kutusuna “Alican” ismini  yazar")
    public void detayliAramaKutusunaAlicanIsminiYazar() {
        // pageManager.adminPage.clickWithJS(pageManager.adminPage.detayliAramaKutusu);
        pageManager.adminPage.sendKeys(pageManager.adminPage.detayliAramaKutusu, "Alican");
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Then("Admin, filtreli arama sonucunda “Alican” ismine ait üyeyi listede görür")
    public void adminFiltreliAramaSonucundaAlicanIsmineAitÜyeyiListedeGörür() {
        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.alicanCananButton));

    }

    @And("Kullanıcı {string} butonunun üzerine gelir ve {string} butonuna tıklar")
    public void kullanıcıButonununÜzerineGelirVeButonunaTıklar(String arg0, String arg1) {
        pageManager.navbarPage.moveToHesabimButton();
        pageManager.adminPage.clickWithJS(pageManager.adminPage.cikisButtonHesabim);
    }

    @And("Alican isimli profili incele butonuna tiklar")
    public void alicanIsimliProfiliInceleButonunaTiklar() {
        pageManager.adminPage.clickWithJS(pageManager.adminPage.profiliInceleButton);

    }


    @Then("Alican Canan 'a ait profil bilgilerinin gordugunu dogrular")
    public void alicanCananAAitProfilBilgilerininGordugunuDogrular() {
        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.profilDetaylariButonu));
    }

    @And("Uye arsivine geri don butonuna tıklar")
    public void uyeArsivineGeriDonButonunaTıklar() {
        pageManager.adminPage.clickWithJS(pageManager.adminPage.uyeArsıvıneGeriDonButon);
    }

    @Then("uye arsivi listesini tekrar gordugunu dogrular")
    public void uyeArsiviListesiniTekrarGordugunuDogrular() {
        pageManager.navbarPage.scrollToElementByText("p","Sonraki");
        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.sonrakiButton));

    }


    @Then("Acilan dropdown menüden Kurumsal Basvuru Formlari secenegine tiklanir")
    public void acilan_dropdown_menüden_kurumsal_basvuru_formlari_secenegine_tiklanir() {

        pageManager.adminPage.clickWithJS(pageManager.adminPage.kurumsalBasvuruFormlari);
        //pageManager.adminPage.click(pageManager.adminPage.kurumsalBFTumBasvurularButton);
    }

    @When("Kurumsal Basvuru Formlari sayfası açılmalıdır.")
    public void kurumsal_basvuru_formlari_sayfası_açılmalıdır() {

        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.kurumsalBFTumBasvurularButton));

    }

    @Then("Kullanici {string} secenegini gorur ve tiklar")
    public void kullanici_secenegini_gorur_ve_tiklar(String string) {

        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.kurumsalBFBasvuruGoruntulemeButton));
        pageManager.adminPage.clickWithJS(pageManager.adminPage.kurumsalBFBasvuruGoruntulemeButton);

    }

    @Then("Acilan listeden {string} adli basvuru sahibine tiklar ve bilgileri gorur")
    public void acilan_listeden_adli_basvuru_sahibine_tiklar_ve_bilgileri_gorur(String string) {

        pageManager.adminPage.sendKeys(pageManager.adminPage.detayliAramaKutusu, "Abdulfettah Şahin");
        pageManager.adminPage.clickWithJS(pageManager.adminPage.abdulfettahSahinButton);

    }

    @Then("Kullanici {string} yazisini gorur")
    public void kullanici_yazisini_gorur(String string) {

        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.sirketBasvuruFormuYazisi));
    }


    @Then("Kullanici {string} secenegine tiklar")
    public void kullaniciSecenegineTiklar(String arg0) {

        // dinammik yaptigim halde basvuru goruntulemeye gitti, SOR
        pageManager.adminPage.clickWithJS(pageManager.adminPage.kurumsalBFTumBasvurularButton);
    }

    @Then("Basvuru listesi goruntulenmelidir")
    public void basvuru_listesi_goruntulenmelidir() {

        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.sonrakiButton));
    }
    @When("Kullanıcı Detaylı Arama çubuğuna {string} yazar ve aratır")
    public void kullanıcı_detaylı_arama_çubuğuna_yazar_ve_aratır(String string) {

        pageManager.navbarPage.sendKeys(pageManager.adminPage.detayliAramaKutusu,"Yeni Dünya");
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Then("Kullanıcı arama sonucunda {string} kurumunun saat bilgilerini görmelidir.")
    public void kullanıcıAramaSonucundaKurumununBilgileriniGörmelidir(String arg0) {

        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.saatBaslikButton));
    }

    @When("Kullanici {string} butonuna tıklar ve kurum bilgilerini görur")
    public void kullanici_butonuna_tıklar_ve_kurum_bilgilerini_görur(String string) {

        pageManager.adminPage.clickWithJS(pageManager.adminPage.inceleButtonYeniDunya);
        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.sirketBasvuruFormuYazisi));
    }

    @Then("Acilan dropdown menüden {string} secenegine tiklanir")
    public void acilan_dropdown_menüden_secenegine_tiklanir(String string) {

        pageManager.adminPage.clickWithJS(pageManager.adminPage.uzmanArsiviButton);

    }
    @Then("Uzman Arşivi sayfası açılmalıdır.")
    public void uzman_arşivi_sayfası_açılmalıdır() {

        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.uzmanArsivisayfasi));

    }
    @Then("Kullanici Detayli Arama cubugunu gorur ve tiklar")
    public void kullanici_detayli_arama_cubugunu_gorur_ve_tiklar() {

        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.detayliAramaKutusu));
        pageManager.adminPage.clickWithJS(pageManager.adminPage.detayliAramaKutusu);

    }
    @Then("Detayli Arama cubuguna {string} yazar ve ilgili bilgilere ulasir")
    public void detayli_arama_cubuguna_yazar_ve_ilgili_bilgilere_ulasir(String string) {

        pageManager.navbarPage.sendKeys(pageManager.adminPage.detayliAramaKutusu,"Zeynep Kalkan");
        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.zeynepKalkanUzman));

    }
    @When("Kullanici {string} secegine tiklar")
    public void kullanici_secegine_tiklar(String string) {
        pageManager.adminPage.clickWithJS(pageManager.adminPage.filtreleriTemizleButonu);

    }

    @Given("Kullanıcı anasayfaya gider")
    public void kullanıcıAnasayfayaGider() {
    }
}



