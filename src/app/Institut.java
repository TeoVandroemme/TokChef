package app;

import app.util.MapUtil;

import java.time.LocalDate;
import java.util.*;

public class Institut {

    protected TreeMap<LocalDate,Concours> concoursPrevu;
    protected ArrayList<Concours> concoursPasse;
    protected ArrayList<Jury> jurys;
    protected ArrayList<Chef> chefs;
    protected ArrayList<Padawan> padawans;
    protected ArrayList<Plat> plats;
    protected ArrayList<Ingredient> ingredients;

    public Institut() {
        this.concoursPrevu = new TreeMap<>();
        this.concoursPasse = new ArrayList<>();
        this.jurys = new ArrayList<>();
        this.chefs = new ArrayList<>();
        this.padawans = new ArrayList<>();
        this.plats = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }

    public ArrayList<Plat> getPlats() {
        return plats;
    }

    public void setPlats(ArrayList<Plat> plats) {
        this.plats = plats;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Jury> getJurys() {
        return jurys;
    }

    public void setJurys(ArrayList<Jury> jurys) {
        this.jurys = jurys;
    }

    public ArrayList<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(ArrayList<Chef> chefs) {
        this.chefs = chefs;
    }

    public ArrayList<Padawan> getPadawans() {
        return padawans;
    }

    public void setPadawans(ArrayList<Padawan> padawans) {
        this.padawans = padawans;
    }

    public TreeMap<LocalDate, Concours> getConcoursPrevu() {
        return concoursPrevu;
    }

    public void setConcoursPrevu(TreeMap<LocalDate, Concours> concoursPrevu) {
        this.concoursPrevu = concoursPrevu;
    }

    public ArrayList<Concours> getConcoursPasse() {
        return concoursPasse;
    }

    public void setConcoursPasse(ArrayList<Concours> concoursPasse) {
        this.concoursPasse = concoursPasse;
    }

    public void addJury(Concours concours, Jury jury){
        if(concours.addJury(jury) && !this.jurys.contains(jury)){
            this.jurys.add(jury);
        }
    }

    public void supJury(Concours concours, Jury jury){
        concours.supJury(jury);
        this.jurys.remove(jury);
    }

    public void addChef(Concours concours, Chef chef, Plat plat){
        if(concours.addChef(chef,plat)){
            if(!this.chefs.contains(chef)){
                this.chefs.add(chef);
            }
            for(Plat p : chef.getPlats()){
                if(!this.plats.contains(p)){
                    this.plats.add(p);
                    for(Ingredient i : p.getIngredients()) {
                        if(!this.ingredients.contains(i)){
                            this.ingredients.add(i);
                        }
                    }
                }
            }

        }
    }

    public void supChef(Concours concours, Chef chef){
        concours.supChef(chef);
        this.chefs.remove(chef);
    }

    public void addPadawan(Chef chef, Padawan padawan){
        if(this.chefs.contains(chef)){
            if(chef.addPadawan(padawan)){
                this.padawans.add(padawan);
            }
        }else{
            System.out.println("Ajouter d'abord le chef");
        }
    }

    public void supPadawan(Chef chef, Padawan padawan){
        chef.supPadawan(padawan);
        this.padawans.remove(padawan);
    }

    public void addPlat(Chef chef, Plat plat){
        if(chef.addPlat(plat)){
            this.plats.add(plat);
            for(Ingredient i : plat.getIngredients()) {
                if(!this.ingredients.contains(i)){
                    this.ingredients.add(i);
                }
            }
        }
    }

    public void supPlat(Chef chef, Plat plat){
        chef.supPlat(plat);
        boolean sup = true;
        for(Chef c : this.chefs){
            if(c.getPlats().contains(plat)){
                sup = false;
            }
        }
        if(sup){
            this.plats.remove(plat);
        }
    }

    public void addIngredient(Plat plat, Ingredient ingredient, String consignes, Integer quantite){
        if(plat.addIngredient(ingredient, consignes, quantite) && !this.ingredients.contains(ingredient)){
            this.ingredients.add(ingredient);
        }
    }

    public void supIngredient(Plat plat, Ingredient ingredient){
        plat.supIngredient(ingredient);
        boolean sup = true;
        for(Plat p : this.plats){
            if(p.getIngredients().contains(ingredient)){
                sup = false;
            }
        }
        if(sup){
            this.ingredients.remove(ingredient);
        }
    }

    public void addConcours(Concours concours){
        if(!this.concoursPrevu.containsValue(concours)){
            this.concoursPrevu.put(concours.getDate(), concours);
        }else{
            System.out.println("Le concours est déjà enregistrer");
        }
    }

    public void listeConcoursPrevu(){
        System.out.println("\nAffichage des prochains Concours\n");
        this.concoursPrevu.forEach((date, concours) -> System.out.println("Le concours : "+concours.getNom()+" est prévu pour le "+date));
    }

    public void listeConcoursPasse(){
        System.out.println("\nAffichage des Concours deja passer\n");
        for(Concours c : this.concoursPasse){
            System.out.println("Le concours : "+c.getNom()+" est passer le "+c.getDate());
        }
    }

    public void listeJurys(){
        System.out.println("\nAffichage des Jurys\n");
        for(Jury j : this.jurys){
            System.out.println(j.toString());
        }
    }

    public void listeChefs(){
        System.out.println("\nAffichage des Chefs\n");
        for(Chef c : this.chefs){
            System.out.println(c.toString());
        }
    }

    public void listePadawans(){
        System.out.println("\nAffichage des Padawans\n");
        for(Padawan p : this.padawans){
            System.out.println(p.toString());
        }
    }

    public void listePlaps(){
        System.out.println("\nAffichage des Plats\n");
        for(Plat p : this.plats){
            System.out.println(p.toString());
        }
    }

    public void listePlatsBio(){
        System.out.println("\nAffichage des Plats bio\n");
        for(Plat p : this.plats){
            if(p.estBio()){
                System.out.println(p.toString());
            }
        }
    }

    public void listeIngredient(){
        System.out.println("\nAffichage des Ingredients\n");
        for(Ingredient i : this.ingredients){
            System.out.println(i.toString());
        }
    }

    public void concoursChefPrevu(Chef chef){
        System.out.println("\nAffichage des prochains Concours du Chef : "+chef+"\n");
        this.concoursPrevu.forEach((date,concours) -> {
            if(concours.getChefs().containsKey(chef)){
                System.out.println("Le Chef va participer au concours : "+concours.getNom());
            }
        });
    }

    public void concoursChefPasse(Chef chef){
        System.out.println("\nAffichage des Concours deja passer du Chef : "+chef+"\n");
        for(Concours c : this.concoursPasse){
            if(c.getChefs().containsKey(chef)){
                System.out.println("Le Chef a participer au concours : "+c.getNom());
            }
        }
    }

    public void platChef(Chef chef){
        System.out.println("\nAffichage des Plats du Chef : "+chef+"\n");
        System.out.println("Plats du Chef "+chef.getNom()+chef.getPrenom()+" par nombre de calories");
        SortedMap<Integer,Plat> plats = new TreeMap<>();
        for(Plat p : chef.getPlats()){
            plats.put(p.nbCalories(), p);
        }
        plats.forEach((calories, plat) -> System.out.println(plat.toString()+" : "+calories+" calories"));
    }

    public void lancerConcours(Concours concours){
        if(this.concoursPrevu.containsValue(concours)){
            if(this.concoursPrevu.firstKey().isEqual(concours.getDate())){
                System.out.println("\nLancement du concours\n");
                concours.lancement();
                this.finDeConcours();
                Chef winner = (Chef) MapUtil.sortByDescendingValue(concours.getNotes()).keySet().toArray()[0];
                System.out.println("\nLe vainceur est le Chef : "+winner);
                this.changementPadawan(winner);
                /* gerer etoiles, padawans et fin du concours */
            }else{
                System.out.println("\nCe concours n'est pas le prochain prévu");
            }
        }else{
            if(this.concoursPasse.contains(concours)){
                System.out.println("\nCe concours est déja passer");
            }else{
                System.out.println("\nCe concours n'est pas enregistrer");
            }
        }
    }

    public void finDeConcours(){
        this.concoursPasse.add(this.concoursPrevu.pollFirstEntry().getValue());
    }

    public void changementPadawan(Chef chef){
        Padawan nouveauChef = chef.nouveauChef();
        Chef c = new Chef(nouveauChef.getNom(), nouveauChef.getPrenom(), nouveauChef.getGenre(), nouveauChef.getTelephone(), chef.getSpecialte());
        this.padawans.remove(nouveauChef);
        this.chefs.add(c);
        System.out.println("\nLe Padawan "+nouveauChef+" vient de devenir Chef");
    }
}