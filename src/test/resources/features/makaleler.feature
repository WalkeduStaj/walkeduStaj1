@AdminInstructorlogin
Feature: Admin / Instructor Paneli Makaleler Sayfasi

  Kullanici olarak
  Walkedu sitesinde hesabım butonunun üzerine gelerek
  ilgili sayfalara ulaşmak istiyorum.

  Background:
    Given Kullanici Login Sayfasina gider.
    And intructor admin login formunu doldurur
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then Kullanici Hesabim butonuna tıklar.
    When Kullanici Makaleler seçeneğine tıklar

  @AdminInstructorMakalelereGidis
  Scenario: Makaleler sayfasına gidiş
    Then Kullanici makaleler basligini gorur.

  Scenario: Kullanici kategori filtresi uygular
    When Kullanici Kategori Seçiniz dropdownina tiklar
    And Kullanici oyun terapisi linkine tiklar.
    Then Sadece Oyun Terapisi kategorisine ait makaleler görünür


  Scenario: Kullanici filtreleri temizler
    When Kullanici Filtreleri Temizle butonuna tıklar
    Then Tüm makaleler tekrar listelenir

  Scenario: Kullanici makale düzenle butonuna tıklar
    When Kullanici sectigi makalenin Düzenle butonuna tıklar
    Then Kullanici makale düzenleme sayfasına gider

  Scenario: Kullanici makale sil butonuna tıklar
    When Kullanici sectigi makalenin Sil butonuna tıklar
    Then Kullaniciya silme işlemi için onay popup'ı gösterilir