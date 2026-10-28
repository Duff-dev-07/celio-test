Feature: ajout produit au panier

    Scenario: verification fonctionnalite d'ajout de produits dans le panier

        Given utlisateur est sur la page du produit
        When utilisateur clique sur la couleur "GREY LIGHT", la taille "44" et ajouter au panier
        Then le panier affiche "Jean baggy 100% coton - bleu brut" en couleur "GREY LIGHT" et taille "44" 


