@JenkinsReport
Feature: Admin Uye Arsivi sayfasina iliskin testler

  Background:
    Given Kullanici Login Sayfasina gider.

  Scenario: Admin Üye Arsivi sayfasina girip uye arsivine iliskin listeyi gorur.

    And kullanici login formu gecerli admin email ve gecerli admin sifre ile doldurur
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then "Admin" Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.
    And "Admin" Hesabim butonunun uzerine gelir
    Then Acilan dropdown menüden üye arşivi tiklanir
    Then Admin Üye arşivine ilişkin listeyi görür


  Scenario: Admin Uye arsivine iliskin listede filtreli arama yapar

    And kullanici login formu gecerli admin email ve gecerli admin sifre ile doldurur
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then "Admin" Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.
    And "Admin" Hesabim butonunun uzerine gelir
    Then Acilan dropdown menüden üye arşivi tiklanir
    When Detayli arama kutusuna “Alican” ismini  yazar
    Then Admin, filtreli arama sonucunda “Alican” ismine ait üyeyi listede görür
    And Kullanıcı "Hesabım" butonunun üzerine gelir ve "Çıkış" butonuna tıklar


  Scenario: Admin, Üye Arşivi listesinden 'Alican' isimli öğrenciyi seçer, profilini görüntüler ve ardından 'Geri Dön' butonuna tıklayarak arşiv listesinin tekrar görüntülenip görüntülenmediğini kontrol eder
    And kullanici login formu gecerli admin email ve gecerli admin sifre ile doldurur
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then "Admin" Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.
    And "Admin" Hesabim butonunun uzerine gelir
    Then Acilan dropdown menüden üye arşivi tiklanir
    When Detayli arama kutusuna “Alican” ismini  yazar
    And Alican isimli profili incele butonuna tiklar
    Then Alican Canan 'a ait profil bilgilerinin gordugunu dogrular
    And  Uye arsivine geri don butonuna tıklar
    Then uye arsivi listesini tekrar gordugunu dogrular


