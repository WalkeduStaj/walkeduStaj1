@smokeinstructorlogin

Feature: Kullanici olarak basarili bir sekilde login olmak istiyorum

    Background:
      Given Kullanıcı homepagea gider

     # Başarılı login olma
    Scenario: Kullanici Giriş yap butonuna tıklayarak login olur
      Then Kullanici homepagede  Giriş Yap butonuna tıklar
      Then Kullanici Login sayfasina erisir
      And Kullanici dogru sifre ve email girer
      Then Kullanici giris yap butonuna tiklar
      Then Kullanici Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.


    # Hatali email ile login olmama
    Scenario:Kullanici hatali email girerek login olamaz
      Then Kullanici homepagede  Giriş Yap butonuna tıklar
      Then Kullanici Login sayfasina erisir
      And Kullanici yanlis email ve dogru sifre girer
      Then Kullanici giris yap butonuna tiklar
      Then Kullanici login olamaz


      # Hatali sifre ile login olmama
    Scenario:Kullanici hatali sifre girerek login olamaz
      Then Kullanici homepagede  Giriş Yap butonuna tıklar
      Then Kullanici Login sayfasina erisir
      And Kullanici dogru email ve yanlis sifre girer
      Then Kullanici giris yap butonuna tiklar
      Then Kullanici Gecersiz email veya password hatasini goruntuler.



      #Logouttan cikis yapma
    Scenario:Kullanici logout butonuna tiklayak cikis yapar
      Then Kullanici basarili bir sekilde kayit olur
      Then Kullanici Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.
      And Kullanıcı "Hesabım" butonunun üzerine gelir ve "Çıkış" butonuna tıklar
      Then Kullanıcı anasayfadaki  Giriş Yap butonunu goruntuler




#