package StepDef;

import Helper.Config;
import Helper.Utlis;
import Pages.HomePage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class HomepageStepDef {


    @Given("utlisateur est sur la page d'accueil")
    public void utlisateur_est_sur_la_page_d_accueil() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getenv("HELIUM_BINARY"));
        Config.driver = new ChromeDriver(options);

        Config.driver.get(Utlis.getProperty("homePage"));
        Config.maxwin();
    }

    @When("utilisateur survole le menu {string} puis clique sur le sous menu {string}")
    public void utilisateur_survole_le_menu_puis_clique_sur_le_sous_menu(String menu_name, String sub_menu_name) {
        HomePage home = new HomePage();
        home.accessPage(menu_name, sub_menu_name);
    }

    @Then("la page {string} est affiche")
    public void la_page_est_affiche(String page_name) {
        HomePage home = new HomePage();
        home.checkPage(page_name);
        Config.driver.quit();
    }
}
