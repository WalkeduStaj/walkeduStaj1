package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.LoginBody;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPage;
import pages.NavbarPage;
import utilities.ValidTestData;

import java.util.List;


public class AdminSmoke_ruya extends BaseSteps {
    private LoginBody loginBody;
    NavbarPage navbarPage;
    AdminPage adminPage;

    @Given("Kullanici “BASE_URL” ile anasayfaya gider")
    public void kullanici_base_url_ile_anasayfaya_gider() {
        pageManager.smokePage.navigateToPage();
    }

    @When("Kullanici Header Giris Yap butonuna tiklar")
    public void kullanici_header_giris_yap_butonuna_tiklar() {
        pageManager.smokePage.clickGirisYapButton();

    }

    @Then("Kullanici Login sayfasına yönlendirilmiş olduğunu doğrular.")
    public void kullanici_login_sayfasına_yönlendirilmiş_olduğunu_doğrular() {
        pageManager.smokePage.assertUrlGiris();
    }

//---------------------------------------------------------

    @When("Login sayfasındaki Giris yap butonuna tiklar.")
    public void loginSayfasındakiGirisYapButonunaTiklar() {
        pageManager.loginPage.clickSubmitButton();
    }


    @Then("Admin yönlendirildiği sayfada Hesabim butonunu gordugunu dogrular")
    public void adminYönlendirildiğiSayfadaHesabimButonunuGordugunuDogrular() {
        pageManager.navbarPage.isDiplayedHesabimButton();

    }
    //     ------------------------------------------
    /*@And("Kullanıcı Çıkış Yap butonuna tıklar")
    public void kullanıcıÇıkışYapButonunaTıklar() {
        pageManager.smokePage.clickCikisYapLink();
    }*/ //-->smokeStepte var zaten

    @Then("Admin anasayfadaki Giris yap butonunu gordugunu dogrular")
    public void adminAnasayfadakiGirisYapButonunuGordugunuDogrular() {

        pageManager.smokePage.anasayfadakiGirisYapGoruntulenir();
    }


    @Then("Kullanici geçersiz sifre girildiğine dair mesajı ekranda gordugunu doğrular")
    public void kullaniciGeçersizSifreGirildiğineDairMesajıEkrandaGordugunuDoğrular() {
        Assert.assertTrue(pageManager.adminPage.isDisplayed(pageManager.adminPage.basarisizPasswordText));
    }

    @And("Kullanici geçerli email ve hatali sifre girer")
    public void kullaniciGeçerliEmailVeHataliSifreGirer() {
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.adminEmail);
        loginBody.setPassword(ValidTestData.gecersizAdminPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);
    }

    @And("Kullanici hatali email ve gecerli sifre girer")
    public void kullaniciHataliEmailVeGecerliSifreGirer() {

        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.gecersizAdminEmail);
        loginBody.setPassword(ValidTestData.adminPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);
    }


    @Then("Kullanici Hesabim butonunu göremedigini test eder.")
    public void kullaniciHesabimButonunuGöremediginiTestEder() {
        List<WebElement> hesabimButonListesi = driver.findElements(By.xpath("(//button[@data-state='closed'])[1]"));

        if (hesabimButonListesi.isEmpty()) {
            System.out.println("Negatif test geçti: 'Hesabım' butonu hatalı giriş sonrası görünmüyor.");
        } else {
            Assert.fail("'Hesabım' butonu hatalı girişe rağmen görünüyor!");
        }
    }

    @Then("Kullanici Hesabim butonunun üzerine gelir.")
    public void kullaniciHesabimButonununÜzerineGelir() throws InterruptedException {
        Thread.sleep(2000);
        pageManager.navbarPage.moveToHesabimButton();
    }
    @And("Kullanıcı Çıkış Yap butonuna tıklar.")
    public void kullanıcıÇıkışYapButonunaTıklar() throws InterruptedException {
        Thread.sleep(2000);

        pageManager.adminPage.clickWithJS(pageManager.adminPage.cikisButton);
    }


}
