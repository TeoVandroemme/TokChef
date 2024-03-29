package app;

import java.util.*;

public class Plat {

    protected String nom;
    protected ArrayList<Ingredient> ingredients;
    protected HashMap<Ingredient, String> consignes;
    protected HashMap<Ingredient, Integer> quantite;

    public Plat(String nom) {
        this.nom = nom;
        this.ingredients = new ArrayList<>();
        this.consignes = new HashMap<>();
        this.quantite = new HashMap<>();
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public HashMap<Ingredient, String> getConsignes() {
        return consignes;
    }

    public void setConsignes(HashMap<Ingredient, String> consignes) {
        this.consignes = consignes;
    }

    public HashMap<Ingredient, Integer> getQuantite() {
        return quantite;
    }

    public void setQuantite(HashMap<Ingredient, Integer> quantite) {
        this.quantite = quantite;
    }

    public boolean addIngredient(Ingredient ingredient, String consignes, Integer quantite){
        if(!(this.ingredients.contains(ingredient))){
            this.ingredients.add(ingredient);
            this.consignes.put(ingredient, consignes);
            this.quantite.put(ingredient, quantite);
            return true;
        }else{
            System.out.println("Le plat contient déjà cet ingredient");
            return false;
        }
    }

    public void supIngredient(Ingredient ingredient){
        this.ingredients.remove(ingredient);
        this.consignes.remove(ingredient);
        this.quantite.remove(ingredient);
    }

    public int nbCalories(){
        int total = 0;
        for(Ingredient i : this.ingredients){
            total += (i.getCalories() * this.quantite.get(i))/100;
        }
        return total;
    }

    public boolean estBio(){
        for(Ingredient ingredient : this.ingredients) if(!ingredient.isBio()) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plat plat = (Plat) o;
        return Objects.equals(ingredients, plat.ingredients) && Objects.equals(consignes, plat.consignes) && Objects.equals(quantite, plat.quantite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients, consignes, quantite);
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
