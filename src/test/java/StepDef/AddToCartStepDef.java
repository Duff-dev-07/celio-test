package StepDef;

import Helper.Config;
import Helper.Utlis;
import Pages.ProductPage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AddToCartStepDef {
    @Given("utlisateur est sur la page du produit")
    public void utlisateur_est_sur_la_page_du_produit() throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getenv("HELIUM_BINARY"));
        Config.driver = new ChromeDriver(options);

        Config.driver.get(Utlis.getProperty("produit"));
        Config.maxwin();
    }

    @When("utilisateur clique sur la couleur {string}, la taille {string} et ajouter au panier")
    public void utilisateur_clique_sur_la_couleur_la_taille_et_ajouter_au_panier(String color, String size) throws Exception {
        ProductPage product = new ProductPage();
        product.select_color_and_size(color, size);
        product.open_cart();
    }

    @Then("le panier affiche {string} en couleur {string} et taille {string}")
    public void le_panier_affiche_en_couleur_et_taille(String name, String color, String size) {
        ProductPage product = new ProductPage();
        product.check_product_in_cart(name, size, color);
    }
}
