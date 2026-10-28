package Pages;

import Helper.Config;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {
    @FindBy(xpath ="/html/body/main/div/section/div[2]/div/div[5]/div[2]/div/div/div[2]/form/div[2]/div/div/div[1]/div/div")
    List<WebElement> product_colors;

    @FindBy(xpath = "/html/body/main/div/section/div[2]/div/div[5]/div[2]/div/div/div[2]/form/div[2]/div/div/div[2]/div/div")
    List<WebElement> product_sizes;

    @FindBy(xpath = "/html/body/main/div/section/div[2]/div/div[5]/div[2]/div/div/div[2]/form/div[3]/div[4]/div[2]/div[2]/button")
    WebElement add_to_cart_btn;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div[2]/div/div[4]/button")
    WebElement view_cart_btn;

    @FindBy(xpath = "/html/body/main/div/section/div[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/div/strong/a")
    WebElement product_name_in_cart;

    @FindBy(xpath = "/html/body/main/div/section/div[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/div/dl/dd[1]")
    WebElement product_color_in_cart;

    @FindBy(xpath = "/html/body/main/div/section/div[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/div/dl/dd[2]")
    WebElement product_size_in_cart;

    public ProductPage() {
        PageFactory.initElements(Config.driver, this);
    }

    public void select_color_and_size(String product_color, String product_size) throws Exception {
        try {
            for(WebElement color:product_colors) {
                if(product_color.equalsIgnoreCase(color.getDomAttribute("option-label"))) {
                    color.click();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            for(WebElement size:product_sizes) {
                if(size.getText().contains(product_size)) {
                    size.click();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        Config.attent(2);

        add_to_cart_btn.click();
    }

    public void open_cart() {
        Config.attent(3);
        view_cart_btn.click();
    }

    public void check_product_in_cart(String product_name, String product_size, String product_color) {
        Assert.assertTrue(product_name_in_cart.getText().contains(product_name));
        Assert.assertEquals(product_size_in_cart.getText(), product_size);
        Assert.assertEquals(product_color_in_cart.getText(), product_color);
    }
}
