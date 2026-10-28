package StepDef;

import Helper.Config;
import Helper.Utlis;
import Pages.JeansPage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class JeansPageStepDef {
    @Given("utlisateur est sur la page Jeans")
    public void utlisateur_est_sur_la_page_chemises_blouses() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getenv("HELIUM_BINARY"));
        Config.driver = new ChromeDriver(options);

        Config.driver.get(Utlis.getProperty("jeansPage"));
        Config.maxwin();
    }

    @When("utilisateur clique sur le produit {string}")
    public void utilisateur_clique_sur_le_produit(String product_name) {
        JeansPage product = new JeansPage();
        product.click_on_product(product_name);
    }

    @Then("la page du produit {string} est affiche")
    public void la_page_du_produit_est_affiche(String product_name) {
        JeansPage product = new JeansPage();
        product.check_product_name(product_name);
        Config.driver.quit();
    }

}
