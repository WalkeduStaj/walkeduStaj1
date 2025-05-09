package steps;
import io.cucumber.java.en.*;
import model.LoginBody;
import org.junit.Assert;
import utilities.ValidTestData;

public class SmokeInstructorSteps extends BaseSteps {

    private LoginBody loginBody;

    @Given("Kullanıcı Ana Sayfaya giderSerife")
    public void kullanıcıAnaSayfayaGider() {
        pageManager.smokeInstructorPage.navigateToPage();
    }
    @When("Kullanıcı Ana Sayfadaki  Giriş Yap butonuna tıklarSerife")
    public void kullanıcıAnasayfadakiGirişYapButonunaTıklar() {
        pageManager.smokeInstructorPage.clickGirisYapButton();
    }

    @When("Kullanici Login Sayfasinda Giris Yap butonuna tiklarSerife")
    public void girisYapButonunaTıklar() {
        pageManager.smokeInstructorPage.clickSubmitButton();

    }

    @And("Kullanıcı giris sayfasina gecis yaparSerife")
    public void girisSayfasi() {
        pageManager.smokeInstructorPage.assertUrlGiris();

    }
    @And("Kullanıcı login formunu doldururSerife")
    public void kullanıcıLoginFormunuDoldururSerife() {
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.validInstructorEmail);
        loginBody.setPassword(ValidTestData.validInstructorPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);

    }

    @Then("Kullanıcı başarılı bir şekilde sisteme giriş yaparSerife")
    public void kullanıcıBaşarılıBirŞekildeSistemeGirişYaparSerife() {

        pageManager.navbarPage.isDiplayedHesabimButton();
    }
    @Then("Kullanici Hesabim butonuna tıklarSerife")
    public void kullaniciHesabimButonunaTıklarSerife() {
        pageManager.navbarPage.clickHesabimButton();
    }
    @And("Kullanıcı Çıkış Yap butonuna tıklarSerife")
    public void kullanıcıÇıkışYapButonunaTıklarSerife() {
        pageManager.smokeInstructorPage.clickCikisYapLink();
    }
    @Then("Kullanıcı anasayfadaki  Giriş Yap butonunu goruntulerSerife")
    public void kullanıcıAnasayfadakiGirişYapButonunuGoruntuler() {
        pageManager.smokeInstructorPage.anasayfadakiGirisYapGoruntulenir();
    }
    @When("Kullanici Login Formu icin gecerli email ve {string} girerSerife")
    public void gecersizBirVeBilgisiIleGirisFormunuDoldurur(String gecersizSifre) {
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.validInstructorEmail);
        loginBody.setPassword(gecersizSifre); // burada feature dosyasındaki değeri kullanıyoruz
        pageManager.loginPage.fillPersonalInformation(loginBody);
    }

    @Then("Kullanıcı, şifre hatalıysa  uyarı mesajını görmelidirSerife")
    public void kullanıcıUyarıMesajınıGörmelidir() {
        Assert.assertTrue(pageManager.loginPage.isDisplayedBirseylerTersGitti());
    }


}













