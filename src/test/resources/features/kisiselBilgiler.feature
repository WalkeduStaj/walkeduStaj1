@kisiselBilgiler
Feature: Walkedu Instructor Kişisel Bilgiler Formu

  Background:
    Given Kullanici Login Sayfasina gider
    And Kullanici login formunu gecerli verilerle doldurur
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then Kullanici Hesabim butonuna tıklar.
    And Kişisel Bilgiler menüsünü tıklar

    Scenario: Unvani tiklayabilir
      When Kullanici unvan dropdownu tiklar
      And Kullanici unvanini secer

  Scenario: Cinsiyet seçimi yapılabilir
    When Kullanici cinsiyet dropdownu tiklar
    And Kullanici cinsiyetini secer


  Scenario: Kişisel bilgiler alanları dinamik olarak doldurulabilir
    When Kullanici kisinin bilgilerini dinamik olarak doldurur
      | Field    | Value                        |
      | AdSoyad  | Nihal KIŞLAR                 |
      | Yas      | 29                           |
      | E-posta   | sadikislar@itopiatech.com.tr |
      | Telefon  | +905555555567                |
    And doldurulan bilgiler Bilgileri Güncelle butonuna basarak güncellenir
