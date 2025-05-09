package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.LoginBody;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.PageManager;
import utilities.ValidTestData;

public class SmokeSteps extends BaseSteps {
    private LoginBody loginBody;

    @Given("Kullanıcı ana sayfaya gider")
    public void kullanıcıAnaSayfayaGider() {
        pageManager.smokePage.navigateToPage();
    }

    @When("Kullanıcı anasayfadaki  Giriş Yap butonuna tıklar")
    public void kullanıcıAnasayfadakiGirişYapButonunaTıklar() {
        pageManager.smokePage.clickGirisYapButton();
    }

    @Then("Kullanıcı login sayfasına yönlendirilmiş olmalıdır")
    public void kullanıcıLoginSayfasınaYönlendirilmişOlmalıdır() {
        PageManager.smokePage.assertUrlGiris();
    }

    @And("URL {string} içermelidir")
    public void urlIçermelidir(String expectedPart) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("URL '" + expectedPart + "' içermiyor. Gerçek URL: " + currentUrl,
                currentUrl.contains(expectedPart));

    }


    @And("Sayfa başlığı login içermelidir")
    public void sayfaBaşlığıLoginIçermelidir() {
        pageManager.smokePage.headerGirisYap();
    }


    @And("kullanıcı login formunu doldurur")
    public void kullanıcıLoginFormunuDoldurur() {
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.validInstructorAdminEmail);
        loginBody.setPassword(ValidTestData.validInstructorAdminPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);
    }

    @And("Kullanıcı Çıkış Yap butonuna tıklar")
    public void kullanıcıÇıkışYapButonunaTıklar() {
        pageManager.smokePage.clickCikisYapLink();
    }

    @Then("Kullanıcı anasayfadaki  Giriş Yap butonunu goruntuler")
    public void kullanıcıAnasayfadakiGirişYapButonunuGoruntuler() {
        pageManager.smokePage.anasayfadakiGirisYapGoruntulenir();
    }

    @Given("Kullanıcı başarılı bir şekilde giriş yapmış olmalıdır")
    public void kullanıcıBaşarılıBirŞekildeGirişYapmışOlmalıdır() {
        pageManager.smokePage.clickGirisYapButton();
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.validInstructorAdminEmail);
        loginBody.setPassword(ValidTestData.validInstructorAdminPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);
        pageManager.loginPage.clickSubmitButton();
    }

    @When("kullanici Login Formu icin gecersiz  {string} ve {string} girer")
    public void kullaniciLoginFormuIcinGecersizVeGirer(String email, String password) {
        loginBody = new LoginBody();
        loginBody.setEmail(email);
        loginBody.setPassword(password);
        pageManager.loginPage.fillPersonalInformation(loginBody);
    }

}
