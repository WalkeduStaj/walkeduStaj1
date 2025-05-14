@smokeinstructorlogin
Feature: Walkedu Login ve Logout Smoke testleri

    #1-Basarılı giriş senaryosu
  Scenario:Admin Login sayfasına yönlendirilmiş olmalıdır
    Given Kullanici “BASE_URL” ile anasayfaya gider
    When Kullanici Header Giris Yap butonuna tiklar
    Then Kullanici Login sayfasına yönlendirilmiş olduğunu doğrular.

    #2-Basarılı admin login senaryosu
  Scenario:Admin başarılı bir sekilde login olabilmelidir
    Given Kullanici “BASE_URL” ile anasayfaya gider
    When Kullanici Header Giris Yap butonuna tiklar
    And kullanici login formu gecerli admin email ve gecerli admin sifre ile doldurur
    When Login sayfasındaki Giris yap butonuna tiklar.
    Then Admin yönlendirildiği sayfada Hesabim butonunu gordugunu dogrular

    #3-Basarılı cıkıs senaryosu
  Scenario:Admin basarılı bir sekilde logout olabilmelidir
    Given Kullanici “BASE_URL” ile anasayfaya gider
    When Kullanici Header Giris Yap butonuna tiklar
    And kullanici login formu gecerli admin email ve gecerli admin sifre ile doldurur
    When Login sayfasındaki Giris yap butonuna tiklar.
    Then Kullanici Hesabim butonunun üzerine gelir.
    And Kullanıcı Çıkış Yap butonuna tıklar.
    Then Admin anasayfadaki Giris yap butonunu gordugunu dogrular

    #4-Basarısız login senaryosu
  Scenario: Admin yanlış sifre ile login olamamalıdır
    Given Kullanici “BASE_URL” ile anasayfaya gider
    When Kullanici Header Giris Yap butonuna tiklar
    And Kullanici geçerli email ve hatali sifre girer
    When Login sayfasındaki Giris yap butonuna tiklar.
    Then Kullanici geçersiz sifre girildiğine dair mesajı ekranda gordugunu doğrular

    #5-Basarısız login senaryosu2
  Scenario: Admin yanlış email ile login olamamalıdır
    Given Kullanici “BASE_URL” ile anasayfaya gider
    When Kullanici Header Giris Yap butonuna tiklar
    And Kullanici hatali email ve gecerli sifre girer
    When Login sayfasındaki Giris yap butonuna tiklar.
    Then Kullanici Hesabim butonunu göremedigini test eder.


#

