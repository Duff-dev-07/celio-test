package Pages;

import Helper.Config;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    @FindBy(xpath = "/html/body/main/div/header/div[2]/div/div/div/div[1]/div/div[1]/nav/ul/li/a/span[1]")
    List<WebElement> menus;

    @FindBy(xpath = "/html/body/main/div/header/div[2]/div/div/div/div[1]/div/div[1]/nav/ul/li[4]/ul/li/div/div/div[1]/ul[3]/li/a/span")
    List<WebElement> sub_menus;

    @FindBy(xpath = "/html/body/main/div/div[2]/div/ul/li[3]/strong")
    WebElement page_title;

    public HomePage() {
        PageFactory.initElements(Config.driver, this);
    }

    public void accessPage(String menuTitle, String sub_menuTitle) {
        try {
            for(WebElement menu:menus) {
                if(menu.getText().contains(menuTitle)) {
                    Actions actions = new Actions(Config.driver);
                    actions.moveToElement(menu).perform();

                    Config.attent(2);

                    for(WebElement sub_menu:sub_menus) {
                        if(sub_menu.getText().contains(sub_menuTitle)) {
                            sub_menu.click();
                        }
                    }

                }
            }

            Thread.sleep(10000);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void checkPage(String page_name) {
        Config.attent(2);
        Assert.assertEquals(page_title.getText(), page_name);
    }


}
