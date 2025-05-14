
@JenkinsReport

Feature: Admin Panel Uzman Arsivinde Uzman goruntuleme testi

  Background:
    Given Kullanici Login Sayfasina gider.

  Scenario:TC01-Admin Uzman Arsivinde "Zeynep Kalkan" adli uzmanin bilgilerini goruntuler.

    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    And kullanici login formu gecerli admin email ve gecerli admin sifre ile doldurur
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then "Admin" Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.
    And "Admin" Hesabim butonunun uzerine gelir
    Then Acilan dropdown menüden "Uzman Arsivi" secenegine tiklanir
    And  Uzman Arşivi sayfası açılmalıdır.
    And  Kullanici Detayli Arama cubugunu gorur ve tiklar
    Then Detayli Arama cubuguna "Zeynep Kalkan" yazar ve ilgili bilgilere ulasir
    When  Kullanici "Filtreleri Temizle" secegine tiklar
    And Kullanıcı "Hesabım" butonunun üzerine gelir ve "Çıkış" butonuna tıklar
