

Feature: Admin Panel Kurumsal Basvuru Formlarinda Basvuru Goruntuleme ve Tum Basvurulari goruntuleme testi

  Background:
    Given Kullanici Login Sayfasina gider.

  Scenario:TC05-Admin Kurumsal Basvuru Formlarindan "Abdulfettah Şahin" adli basvuru sahibini goruntuler

  When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
  And kullanici login formu gecerli admin email ve gecerli admin sifre ile doldurur
  When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
  Then "Admin" Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.
  And "Admin" Hesabim butonunun uzerine gelir
  Then Acilan dropdown menüden Kurumsal Basvuru Formlari secenegine tiklanir
  When Kurumsal Basvuru Formlari sayfası açılmalıdır.
  Then Kullanici "Basvuru Goruntuleme" secenegini gorur ve tiklar
  And Acilan listeden "Abdulfettah Şahin" adli basvuru sahibine tiklar ve bilgileri gorur
  Then Kullanici "Sirket Basvuru Formu" yazisini gorur
  And Kullanıcı "Hesabım" butonunun üzerine gelir ve "Çıkış" butonuna tıklar



   Scenario:TC05-Admin Kurumsal Basvuru Formlari Tum Basvurular'da Yeni Dunya kurumunun bilgilerini goruntuler

    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    And kullanici login formu gecerli admin email ve gecerli admin sifre ile doldurur
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then "Admin" Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.
    And "Admin" Hesabim butonunun uzerine gelir
    Then Acilan dropdown menüden Kurumsal Basvuru Formlari secenegine tiklanir
    Then Kullanici "Tum Basvurular" secenegine tiklar
    And  Basvuru listesi goruntulenmelidir
    When Kullanıcı Detaylı Arama çubuğuna "Yeni Dunya" yazar ve aratır
    Then Kullanıcı arama sonucunda "Yeni Dunya" kurumunun saat bilgilerini görmelidir.
        ##Kurum Adi, Saat, Tarih, Basvuru Turu, Basvuru Detayi bilgileri gorunmelidir
    When Kullanici "Incele" butonuna tıklar ve kurum bilgilerini görur
    Then Kullanici "Sirket Basvuru Formu" yazisini gorur
    And Kullanıcı "Hesabım" butonunun üzerine gelir ve "Çıkış" butonuna tıklar

