package app;

import app.util.MapUtil;

import java.time.LocalDate;
import java.util.*;

public class Concours {

    protected String nom;
    protected ArrayList<Jury> jury;
    protected HashMap<Chef, Plat> chefs;
    protected LocalDate date;
    protected HashMap<Chef,Integer> notes;
    protected boolean estFinis;

    public Concours(String nom, int annee, int mois, int jours) {
        this.nom = nom;
        this.date = LocalDate.of(annee, mois, jours);
        this.jury = new ArrayList<>();
        this.chefs = new HashMap<>();
        this.notes = new HashMap<>();
        this.estFinis = false;
    }

    public String getNom() {
        return nom;
    }

    public HashMap<Chef, Integer> getNotes() {
        return notes;
    }

    public void setNotes(HashMap<Chef, Integer> notes) {
        this.notes = notes;
    }

    public boolean isEstFinis() {
        return estFinis;
    }

    public void setEstFinis(boolean estFinis) {
        this.estFinis = estFinis;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Jury> getJury() {
        return jury;
    }

    public void setJury(ArrayList<Jury> jury) {
        this.jury = jury;
    }

    public HashMap<Chef, Plat> getChefs() {
        return chefs;
    }

    public void setChefs(HashMap<Chef, Plat> chefs) {
        this.chefs = chefs;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean addJury(Jury jury){
        if(!this.nbJuryOK()){
            this.jury.add(jury);
            System.out.println("Le Jury a été ajouté");
            return true;
        }else{
            System.out.println("Il y a trop de jurys");
            return false;
        }
    }

    public boolean addChef(Chef chef, Plat plat){
        if(chef.getPlats().contains(plat)){
            this.chefs.put(chef, plat);
            System.out.println("Le Chef a été ajouté");
            return true;
        }else{
            System.out.println("Le chef ne connait pas le plat");
            return false;
        }
    }

    public void supJury(Jury jury){
        this.jury.remove(jury);
    }

    public void supChef(Chef chef){
        this.chefs.remove(chef);
    }

    public boolean nbJuryOK(){
        return this.jury.size() == 3;
    }

    public boolean nbChefsOK(){
        return this.chefs.size() >= 5;
    }

    public void note1plat(Chef chef){
        Random random = new Random();
        int i = random.nextInt(10)+1;
        this.notes.put(chef, i);
    }

    public void lancement(){
        if(this.nbJuryOK() && this.nbChefsOK()){
            this.chefs.forEach((chef, plat) -> this.note1plat(chef));
            this.afficherResult();
        }else{
            if(!this.nbJuryOK()){
                System.out.println("Le nombre de jury n'est pas correct");
            }
            if(!this.nbChefsOK()){
                System.out.println("Le nombre de chef n'est pas correct");
            }
        }
    }

    public void afficherResult(){
        MapUtil.sortByDescendingValue(this.notes).forEach((chef, note) -> System.out.println("Le Chef "+chef.getPrenom()+" "+chef.getNom()+
                " a eu la note de "+note));
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
