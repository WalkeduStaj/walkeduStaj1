@smokeinstructorlogin
Feature: Walkedu Login Yönlendirme ve Doğrulama Testi
  Kullanıcı olarak ana sayfadan giriş yap butonuna tıkladığımda doğru şekilde login sayfasına yönlendirilmek istiyorum.

  Background:
    Given Kullanıcı ana sayfaya gider

  # Başarılı giriş senaryosu
  Scenario: Giriş yap butonuna tıklanınca login sayfasına yönlendirilmelidir
    When Kullanıcı anasayfadaki  Giriş Yap butonuna tıklar
    Then Kullanıcı login sayfasına yönlendirilmiş olmalıdır
    And URL "giris" içermelidir
    And Sayfa başlığı login içermelidir

  # Başarılı login senaryosu
  Scenario: Kullanıcı başarılı bir şekilde login olmalıdır
    When Kullanıcı anasayfadaki  Giriş Yap butonuna tıklar
    And kullanıcı login formunu doldurur
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then Kullanici Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.

  # Kullanıcı çıkışı yapmalıdır
  Scenario: Kullanıcı çıkış yaptıktan sonra Hesabım butonunu görmemelidir
    Given Kullanıcı başarılı bir şekilde giriş yapmış olmalıdır
    Then Kullanici Hesabim butonuna tıklar.
    And Kullanıcı Çıkış Yap butonuna tıklar
    Then Kullanıcı anasayfadaki  Giriş Yap butonunu goruntuler

  # Hatalı giriş senaryosu
  Scenario Outline: Hatalı bilgilerle giriş yapılmaya çalışıldığında hata mesajı görüntülenmelidir
    When Kullanıcı anasayfadaki  Giriş Yap butonuna tıklar
    When kullanici Login Formu icin gecerli email ve "<gecersiz sifre>" girer
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then Kullanici Gecersiz email veya password hatasini goruntuler.

    Examples:
      |gecersiz sifre  |
      |Walkedu24       |
      |Walkedu 24      |
      |Walkedu.        |