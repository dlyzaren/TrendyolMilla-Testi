package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static utilities.Driver.driver;

/**
 * Tekrar kullanılabilir yardımcı metotlar içeren bir yardımcı sınıf.
 */

public class ReusableMethods {


    public static  void bulanaKadarIn() {

        JavascriptExecutor jsx = (JavascriptExecutor) Driver.getDriver();
        WebElement element = driver.findElement(By.xpath("//h3[.='TRENDYOLMİLLALacivert Bisiklet Yaka Triko Bluz TWOSS21BZ0370']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'start', behavior: 'smooth'});", element);
    
    }


    public static void sepeteEklendiTespit(String elementId) {

        //Sepete eklendiği bildirilen mesajın görünür olup olmadığını kontrol eder.
        WebElement tespit = driver.findElement(By.cssSelector(".add-to-basket-button-text-success"));

        Assert.assertTrue(tespit.isDisplayed());

        System.out.println("Sayfa mesajınız; " + tespit.getText());

    }
    public static void yeniSekmeyeGec(){

        Set<String> windows; // sekmeleri tutar
        Iterator<String> window; // sekmeler arasında gezmemezi sağlayacak arama yapmamızı sağlar

        String parentId; //iterator için ana sekme
        String chilIdOne;
        windows = driver.getWindowHandles();

        window = windows.iterator();
        parentId = window.next();
        chilIdOne = window.next();
        driver.switchTo().window(chilIdOne);

    }

    public static void bedenKontrolu(){

        //equals ile beden eşit mi diye kontrol eder

        String secilenBedenMesaji = Driver.getDriver().findElement(By.xpath("//p[.='Beden: XL']")).getText();
        String beklenenMesaj = "Beden: XL";
        if(secilenBedenMesaji.equals(beklenenMesaj)){
            System.out.println("Beden secimi dogru --> " +secilenBedenMesaji);
        }
        else {
            System.out.println("Yanlış beden secildi");
        }

    }

    public static void linkKontrol(String beklenenLink) {

        //Bulunan sayfanın linkini alır gitmesi gereken sayfa linki ile karşılaştırır
        String gelenlink = driver.getCurrentUrl();
        Assert.assertEquals(beklenenLink,gelenlink);
        System.out.println("Bu sayfadasınız " + gelenlink);

    }

}
