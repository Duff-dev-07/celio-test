package Pages;

import Helper.Config;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class JeansPage {
    @FindBy(xpath ="/html/body/main/div/section/div[3]/div[1]/div[4]/ol/li/div[2]/h5/a")
    List<WebElement> products;

    @FindBy(xpath = "/html/body/main/div/section/div[2]/div/div[5]/div[2]/div/div/h1")
    WebElement product_name;

    public JeansPage() {
        PageFactory.initElements(Config.driver, this);
    }

    public void click_on_product(String product_name) {
        try {
            for(WebElement product:products) {
                if(product.getText().contains(product_name)) {
                    product.click();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void check_product_name(String product) {
        Assert.assertEquals(product_name.getText(), product);
    }
}
