@JenkinsReport
Feature: Admin / Instructor Paneli Randevularim

  Kullanici olarak
  Walkedu sitesinde hesabım butonunun üzerine gelerek
  ilgili sayfalara ulaşmak istiyorum.

  Background:
    Given Kullanici Login Sayfasina gider.
    And intructor admin login formunu doldurur
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then Kullanici Hesabim butonuna tıklar.
    When Kullanici Randevular seçeneğine tıklar


  Scenario: randevularrim sayfasına gidiş
    Then Kullanici randevularim basligini gorur.


