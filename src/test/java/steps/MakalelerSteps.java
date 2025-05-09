package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.LoginBody;
import utilities.ValidTestData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MakalelerSteps extends BaseSteps {

    private LoginBody loginBody;

    @And("intructor admin login formunu doldurur")
    public void intructorAdminLoginFormunuDoldurur() {
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.validInstructorAdminEmail);
        loginBody.setPassword(ValidTestData.validInstructorAdminPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);
    }


    @When("Kullanici Makaleler seçeneğine tıklar")
    public void kullaniciSecenegineTiklar() {
        pageManager.makalelerPage.clickMakalelerButton();

    }

    @Then("Kullanici makaleler sayfasında olduğunu doğrular")
    public void kullaniciMakalelerSayfasindaOldugunuDogrular() {
        assertTrue(pageManager.makalelerPage.isAtMakalelerPage());
    }


    @Then("Kullanici makaleler basligini gorur.")
    public void kullaniciBasliginiGorur() {
        assertTrue(pageManager.makalelerPage.isAtMakalelerPage());
    }


    @When("Kullanici Kategori Seçiniz dropdownina tiklar")
    public void kullaniciKategoriSecinizDropdowninaTiklar() {
        pageManager.makalelerPage.clickMakaleKategoriSecimi();
    }

    @And("Kullanici oyun terapisi linkine tiklar.")
    public void kullaniciOyunTerapisiLinkineTiklar() {
        pageManager.makalelerPage.clickOyunTerapisi();
    }

    @Then("Sadece Oyun Terapisi kategorisine ait makaleler görünür")
    public void sadeceOyunTerapisiKategorisineAitMakalelerGörünür() {
        assertTrue(pageManager.makalelerPage.makalelerOyunTerapisi());
    }


    @When("Kullanici Filtreleri Temizle butonuna tıklar")
    public void kullaniciFiltreleriTemizleButonunaTıklar() {
        pageManager.makalelerPage.clickMakaleFiltreTemizle();
    }

    @Then("Tüm makaleler tekrar listelenir")
    public void tümMakalelerTekrarListelenir() {
        pageManager.makalelerPage.makaleler10Tane();
    }

    @When("Kullanici sectigi makalenin Düzenle butonuna tıklar")
    public void kullaniciSectigiMakaleninDüzenleButonunaTıklar() {
        pageManager.makalelerPage.clickMakaleDuzenle();

    }

    @Then("Kullanici makale düzenleme sayfasına gider")
    public void kullaniciMakaleDüzenlemeSayfasınaGider() {
        assertTrue(pageManager.makalelerPage.makaleDuzenleSayfasindayim());
    }

    @When("Kullanici sectigi makalenin Sil butonuna tıklar")
    public void kullaniciSectigiMakaleninSilButonunaTıklar() {
        pageManager.makalelerPage.clickMakaleSil();
    }

    @Then("Kullaniciya silme işlemi için onay popup'ı gösterilir")
    public void kullaniciyaSilmeIşlemiIçinOnayPopupIGösterilir() {
        pageManager.makalelerPage.clickMakaleSilOnay();
    }



}
