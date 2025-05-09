package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import model.LoginBody;
import org.junit.Assert;
import pages.*;
import utilities.ValidTestData;

public class AdminStep_Yelda extends BaseSteps{

    private LoginBody loginBody;
    AdminPage adminPage = new AdminPage(driver);
    NavbarPage navbarPage = new NavbarPage(driver);

    @Given("Kullanıcı homepagea gider")
    public void kullanıcıHomepageaGider() {

        pageManager.loginPage.navigateToPage();
    }

    @Then("Kullanici homepagede  Giriş Yap butonuna tıklar")
    public void kullanici_homepagede_giriş_yap_butonuna_tıklar() {

        pageManager.smokePage.clickGirisYapButton();

    }
    @Then("Kullanici Login sayfasina erisir")
    public void kullanici_login_sayfasina_erisir() {

        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.kayitOlButon));
    }

    @Then("Kullanici dogru sifre ve email girer")
    public void kullanici_dogru_sifre_ve_email_girer() {

        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.adminEmail);
        loginBody.setPassword(ValidTestData.adminPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);

    }

    @Then("Kullanici giris yap butonuna tiklar")
    public void kullanici_giris_yap_butonuna_tiklar() {

        pageManager.loginPage.clickSubmitButton();

    }

    @And("Kullanici yanlis email ve dogru sifre girer")
    public void kullaniciYanlisEmailVeDogruSifreGirer() {
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.gecersizAdminMail);
        loginBody.setPassword(ValidTestData.adminPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);
    }

    @And("Kullanici dogru email ve yanlis sifre girer")
    public void kullaniciDogruEmailVeYanlisSifreGirer() {

        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.adminEmail);
        loginBody.setPassword(ValidTestData.gecersizAdminSifre);
        pageManager.loginPage.fillPersonalInformation(loginBody);
    }
    @Then("Kullanici login olamaz")
    public void kullaniciLoginOlamaz() {

        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.kayitOlButon));
    }

    @Then("Kullanici basarili bir sekilde kayit olur")
    public void kullaniciBasariliBirSekildeKayitOlur() {

        pageManager.smokePage.clickGirisYapButton();
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.adminEmail);
        loginBody.setPassword(ValidTestData.adminPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);
        pageManager.loginPage.clickSubmitButton();


    }


}
