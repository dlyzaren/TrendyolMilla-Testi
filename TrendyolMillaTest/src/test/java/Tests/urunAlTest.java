package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TrendyolPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;
import java.time.Duration;
import java.util.ResourceBundle;

import static utilities.Driver.driver;

//import static utilities.Driver.driver;

/**
 * Trendyol sitesinde bir ürün arama testi.
 * Bu test, Trendyol sitesinde belirli bir ürünü aramak için gerçekleştirilir.
 * İlgili sayfaya gidilir, ürün arama kutusuna belirli bir anahtar kelime yazılır
 * ve sonuçlar arasında istenen ürün bulunur,doğru beden seçilir kontrol edilir.
 */


 public class urunAlTest {
    TrendyolPage trendyolPage = new TrendyolPage();
    static int beklemeSuresi= 1500;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30L));


    @Test(priority = 1)
    public void urunAramaTesti() throws InterruptedException {

    //   Bu test, Trendyol Milla web sitesinde belirli bir ürünü aramak için gerçekleştirilir.
    // - Ana sayfaya gidilir.
    // - Çıkan pop-up reklamı kapatılır.
    // - Arama kutusuna belirli bir anahtar kelime ("Bluz") yazılır.
    //- Enter tuşuna basılarak arama gerçekleştirilir.
    // - Sonuçlar arasında Milla markası seçilir.
    // - Sonuçlar sayfasının URL'si kontrol edilir.

        Driver.getDriver().get(ConfigReader.getProperty("trendyolmillaURL"));
        trendyolPage.carpi.click();
        trendyolPage.aramaKutusu.click();
        trendyolPage.aramaKutusu.sendKeys("Bluz",Keys.ENTER);
        trendyolPage.millaMarkasi.click();
        Thread.sleep(beklemeSuresi);
        ReusableMethods.linkKontrol("https://www.trendyol-milla.com/sr?wc=1019&wb=101476&qt=Bluz&st=Bluz&os=1");

    }

    @Test(priority = 2)
    public void urunSecmeTesti() throws InterruptedException {

    // Trendyol Milla web sitesinde ürün seçme testi.
    // Bu test, Trendyol Milla web sitesinde belirli bir ürünün seçilmesi için gerçekleştirilir.
    // - Belirli bir ürünün bulunduğu sayfaya gidilir.
    // - Ürünün bulunduğu sayfada bulunana kadar sayfa kaydırılır.
    // - Ürünün üzerine tıklanarak detaylarına gidilir.
    // - Yeni sekme açılarak ürün detay sayfasına geçilir.
    // - Ürün detay sayfasının URL'si kontrol edilir.

        ReusableMethods.bulanaKadarIn();
        trendyolPage.bluz.click();
        Thread.sleep(beklemeSuresi);
        ReusableMethods.yeniSekmeyeGec();
        ReusableMethods.linkKontrol("https://www.trendyol-milla.com/trendyolmilla/yesil-sifir-kol-buzgulu-vucuda-oturan-esnek-orme-bluz-twoss24bz00486-p-807163063?boutiqueId=656476&merchantId=968");

    }

    @Test(priority = 3)
    public void sepeteEklemeTesti() throws InterruptedException {
    // Trendyol Milla web sitesinde ürünün sepete eklenmesi testi.
    //Bu test, Trendyol Milla web sitesinde belirli bir ürünün sepete eklenmesi için gerçekleştirilir.
    //- Belirli bir ürünün detay sayfasına gidilir.
    //- Bir beden seçilir.
    //- Ürün sepete eklenir.
    //- Ürünün başarılı bir şekilde sepete eklenip eklenmediği kontrol edilir .

        trendyolPage.bedenSec.click();
        Thread.sleep(beklemeSuresi);
        trendyolPage.sepetEkle.click();
        Thread.sleep(beklemeSuresi);
        ReusableMethods.sepeteEklendiTespit(trendyolPage.sepeteEklendi);
        Thread.sleep(beklemeSuresi);

    }

   @Test(priority = 4)
    public void dogruBedenSecimiTesti(){

    // Trendyol Milla web sitesinde doğru beden seçimi testi.
    // Bu test, Trendyol Milla web sitesinde belirli bir ürünün doğru bedeninin seçilip seçilmediğini kontrol eder.
    // - Sepete git butonuna tıklanır.
    // - Sepetteki ürünler listesi açılır.
    // - Doğru beden seçimi yapıldığı kontrol edilir.

        trendyolPage.siparisiTamamla.click();
        trendyolPage.sepetteCarpi.click();
        ReusableMethods.bedenKontrolu();


   }


    @Test(priority = 5)
    public void uyarıTesti() throws InterruptedException {
    // Trendyol Milla web sitesinde uyarı mesajı testi.
    // Bu test, Trendyol Milla web sitesinde belirli bir işlem sonucunda beklenen uyarı mesajının görüntülenip görüntülenmediğini kontrol eder.
    // - Sepeti onayla butonuna tıklanır.
    // - Gelen uyarı mesajı kontrol edilir.
    // -Sayfa kapatılır

       trendyolPage.sepetiOnaylaButonu.click();
       Thread.sleep(beklemeSuresi);
       String sayfaMesaji =Driver.getDriver().findElement(By.cssSelector(".pb-guest-order-flow-modal-title")).getText();
       String beklenenMesaj = "Trendyol Hesabınız Yok Mu?";
       Assert.assertEquals(beklenenMesaj,sayfaMesaji);
       System.out.println("Beklenen mesaj; " +beklenenMesaj + " Gelen mesaj ; " +sayfaMesaji);
       Driver.quitDriver();


}



}
