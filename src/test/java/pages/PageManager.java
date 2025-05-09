package pages;

import org.openqa.selenium.WebDriver;

public class PageManager {//bu sayfalara ulasmak icin.instance tutan . her sayfada üstünde new vs yazmayalım diye
    public LoginPage loginPage;
    public NavbarPage navbarPage;
    public EgitmenlerPage egitmenlerPage;
    public MakalelerPage makalelerPage;
    public AdminPage adminPage;
    public KisiselBilgilerPage kisiselBilgilerPage;



    public static SmokePage smokePage;
    public SmokeInstructorPage smokeInstructorPage;


    public PageManager(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.navbarPage = new NavbarPage(driver);
        this.egitmenlerPage = new EgitmenlerPage(driver);
        this.makalelerPage = new MakalelerPage(driver);
        this.adminPage = new AdminPage(driver);
        this.kisiselBilgilerPage = new KisiselBilgilerPage(driver);
        this.smokeInstructorPage = new SmokeInstructorPage(driver);
        this.smokePage = new SmokePage(driver);
        this.smokeInstructorPage = new SmokeInstructorPage(driver);

    }
}
