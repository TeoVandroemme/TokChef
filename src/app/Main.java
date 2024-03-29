package app;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Création des Jurys
        Jury jury1 = new Jury("Jean", "Dupont", Genre.MASCULIN, "0102030405");
        Jury jury2 = new Jury("Jeanne", "Dubois", Genre.FEMININ, "0504030201");
        Jury jury3 = new Jury("blabla", "bloblo", Genre.AUTRES, "0908070605");

        // Création des Chefs
        Chef chef1 = new Chef("chef1", "nom1", Genre.MASCULIN, "123654789", "Patissier");
        Chef chef2 = new Chef("chef2", "nom2", Genre.FEMININ, "123654789", "Cuisinier");
        Chef chef3 = new Chef("chef3", "nom3", Genre.AUTRES, "123654789", "Distance");
        Chef chef4 = new Chef("chef4", "nom4", Genre.FEMININ, "123654789", "Cuisinier");
        Chef chef5 = new Chef("chef5", "nom5", Genre.MASCULIN, "123654789", "Patissier");

        // Création des Padawans
        Padawan padawan1 = new Padawan("padawan1", "nom1", Genre.MASCULIN, "123654789", chef1);
        Padawan padawan2 = new Padawan("padawan2", "nom2", Genre.MASCULIN, "123654789", chef2);
        Padawan padawan3 = new Padawan("padawan3", "nom3", Genre.MASCULIN, "123654789", chef3);
        Padawan padawan4 = new Padawan("padawan4", "nom4", Genre.MASCULIN, "123654789", chef4);
        Padawan padawan5 = new Padawan("padawan5", "nom5", Genre.MASCULIN, "123654789", chef5);

        // Création des Ingredients (catégorie autres)
        Ingredient ingredient1 = new Ingredient(1, "ingredient1", false, 50);
        Ingredient ingredient2 = new Ingredient(2, "ingredient2", true, 150);
        Ingredient ingredient3 = new Ingredient(3, "ingredient3", false, 250);

        // Création des Epices
        Epice epice1 = new Epice(4, "epice1", true);
        Epice epice2 = new Epice(5, "epice2", false);
        Epice epice3 = new Epice(6, "epice3", true);

        // Création des Viandes
        Viande viande1 = new Viande(7, "viande1", false, 350, 0.15);
        Viande viande2 = new Viande(8, "viande2", true, 450, 0.25);
        Viande viande3 = new Viande(9, "viande3", false, 550, 0.35);

        // Création des Legumes
        Legume legume1 = new Legume(10, "legume1", true, 10, 0.05);
        Legume legume2 = new Legume(11, "legume2", false, 20, 0.10);
        Legume legume3 = new Legume(12, "legume3", true, 30, 0.20);

        // Création des Plats
        Plat plat1 = new Plat("plat1");
        Plat plat2 = new Plat("plat2");
        Plat plat3 = new Plat("plat3");
        Plat plat4 = new Plat("plat4");
        Plat plat5 = new Plat("plat5");

        // Création des Concours
        Concours concours1 = new Concours( "concours1", 2022, 10, 20);
        Concours concours2 = new Concours( "concours2", 2022, 11, 21);

        // Création d'un Institut, qui gere les concours
        Institut institut1 = new Institut();

        // Ajout des concours
        institut1.addConcours(concours1);
        institut1.addConcours(concours2);

        // Ajout des Jurys
        institut1.addJury(concours1, jury1);
        institut1.addJury(concours1, jury2);
        institut1.addJury(concours1, jury3);

        // Ajout des Jurys
        institut1.addJury(concours2, jury1);
        institut1.addJury(concours2, jury2);
        institut1.addJury(concours2, jury3);

        // Ajout des Ingredients
        plat1.addIngredient(ingredient1, "consigne1", 100);
        plat1.addIngredient(epice1, "consigne2", 5);
        plat1.addIngredient(viande1, "consigne3", 150);
        plat1.addIngredient(legume1, "consigne4", 200);

        // Ajout des Ingredients
        plat2.addIngredient(ingredient2, "consigne1", 100);
        plat2.addIngredient(epice2, "consigne2", 5);
        plat2.addIngredient(viande2, "consigne3", 150);
        plat2.addIngredient(legume2, "consigne4", 200);

        // Ajout des Ingredients
        plat3.addIngredient(ingredient3, "consigne1", 100);
        plat3.addIngredient(epice3, "consigne2", 5);
        plat3.addIngredient(viande3, "consigne3", 150);
        plat3.addIngredient(legume3, "consigne4", 200);

        // Ajout des Ingredients
        plat4.addIngredient(ingredient2, "consigne1", 100);
        plat4.addIngredient(epice1, "consigne2", 5);
        plat4.addIngredient(viande2, "consigne3", 150);
        plat4.addIngredient(legume1, "consigne4", 200);

        // Ajout des Ingredients
        plat5.addIngredient(ingredient2, "consigne1", 100);
        plat5.addIngredient(epice3, "consigne2", 5);
        plat5.addIngredient(viande2, "consigne3", 150);
        plat5.addIngredient(legume3, "consigne4", 200);

        // Ajout des Plats
        chef1.addPlat(plat1);
        chef1.addPlat(plat2);
        chef2.addPlat(plat2);
        chef3.addPlat(plat3);
        chef4.addPlat(plat4);
        chef5.addPlat(plat5);

        // Ajout des Chefs
        institut1.addChef(concours1, chef1, plat1);
        institut1.addChef(concours1, chef2, plat2);
        institut1.addChef(concours1, chef3, plat3);
        institut1.addChef(concours1, chef4, plat4);
        institut1.addChef(concours1, chef5, plat5);

        // Ajout des Chefs
        institut1.addChef(concours2, chef1, plat2);
        institut1.addChef(concours2, chef2, plat2);
        institut1.addChef(concours2, chef3, plat3);
        institut1.addChef(concours2, chef4, plat4);
        institut1.addChef(concours2, chef5, plat5);

        // Ajout des Padawans
        institut1.addPadawan(chef1, padawan1);
        institut1.addPadawan(chef2, padawan2);
        institut1.addPadawan(chef3, padawan3);
        institut1.addPadawan(chef4, padawan4);
        institut1.addPadawan(chef5, padawan5);

        // Affichage des prochains concours
        institut1.listeConcoursPrevu();

        // Affichage des prochains concours du chefs 1
        institut1.concoursChefPrevu(chef1);

        // Lancement Concours pas le prochian chronologiquement
        institut1.lancerConcours(concours2);

        // Lancement Concours est le prochian chronologiquement
        institut1.lancerConcours(concours1);

        // Lancement Concours est le prochian chronologiquement
        institut1.lancerConcours(concours2);

        // Lancement Concours est deja passer
        institut1.lancerConcours(concours1);

        // Affichage des Concours deja passer
        institut1.listeConcoursPasse();

        // Affichage des Jurys
        institut1.listeJurys();

        // Affichage des Chefs
        institut1.listeChefs();

        // Affichage des Padawans
        institut1.listePadawans();

        // Affichage des Plats
        institut1.listePlaps();

        // Affichage des Plats bio
        institut1.listePlatsBio();

        // Affichage des Ingredients
        institut1.listeIngredient();

        // Affichage des Concours deja passer du Chef 2
        institut1.concoursChefPasse(chef2);

        // Affichage des Plats du Chef 1 par nombre de calories
        institut1.platChef(chef1);
    }
}
