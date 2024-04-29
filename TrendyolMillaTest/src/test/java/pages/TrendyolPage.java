package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

/**
 * Trendyol web sayfasındaki elementlere erişim sağlamak için kullanılan elementler bu sayfada yer alır .
 */
public class TrendyolPage {
    public TrendyolPage(){
        PageFactory.initElements(Driver.getDriver(),this); //oop concept

    }
    @FindBy(id = "Combined-Shape")
    public WebElement carpi;

    @FindBy(xpath = "//*[@class='V8wbcUhU']")
    public WebElement  aramaKutusu;

    @FindBy(css = ".cyrzo7gC")
    public String  enterTusu;


    @FindBy(xpath = "//div[@class='aggrgtn-cntnr-wrppr']/div[2]//div[2]//div[@class='chckbox']")
    public WebElement millaMarkasi;


    @FindBy(xpath = "//h3[.='TRENDYOLMİLLALacivert Bisiklet Yaka Triko Bluz TWOSS21BZ0370']")
    public WebElement bluz;
    @FindBy(xpath = "//div[.='XL']")
    public WebElement bedenSec;

    @FindBy(css = ".add-to-basket-button-text")
    public WebElement sepetEkle;
    @FindBy(xpath = ".add-to-basket-button-text-success")
    public String sepeteEklendi;

    @FindBy(xpath = "//p[.='Sepetim']" )
    public String sepetimButonu;
    @FindBy(css = ".CompleteOrder")
    public WebElement siparisiTamamla;

    @FindBy(css = ".ty-cross")
    public WebElement sepetteCarpi;
    @FindBy(xpath = "//div[@class='pb-summary']/div[4]/a[.='Sepeti Onayla']")
    public WebElement sepetiOnaylaButonu;

}