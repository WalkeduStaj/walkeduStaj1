@smokeinstructor
Feature: Kullanıcı Login & Logout Olabilme Dogrulama Islemi

  Background:
    Given Kullanıcı Ana Sayfaya giderSerife
    When Kullanıcı Ana Sayfadaki  Giriş Yap butonuna tıklarSerife


  Scenario: Kullanıcı sisteme basarili giriş ve çıkış yapar
    And Kullanıcı login formunu doldururSerife
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklarSerife
    Then Kullanıcı başarılı bir şekilde sisteme giriş yaparSerife
    When Kullanici Hesabim butonuna tıklarSerife
    And Kullanıcı Çıkış Yap butonuna tıklarSerife
    Then Kullanıcı anasayfadaki  Giriş Yap butonunu goruntulerSerife

  Scenario Outline: Geçersiz şifre ile giriş denemesinde hata mesajının gösterilmesi
    When Kullanici Login Formu icin gecerli email ve "<gecersizSifre>" girerSerife
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklarSerife
    Then Kullanıcı, şifre hatalıysa  uyarı mesajını görmelidirSerife

    Examples:
      | gecersizSifre |
      | Walkedu24     |
      | Walkedu 24    |
      | Walkedu.      |
      | Walkedu.2     |


