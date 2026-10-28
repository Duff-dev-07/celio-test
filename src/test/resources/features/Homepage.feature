Feature: Page d'accueil Celio

    Scenario: verification des menus de la page d'accueil

        Given utlisateur est sur la page d'accueil 
        When utilisateur survole le menu "Collection" puis clique sur le sous menu "Jeans"
        Then la page "Jeans" est affiche 




