package app;

import java.util.*;

public class Chef extends Personne{

    protected int etoiles;
    protected String specialte;
    protected ArrayList<Plat> plats;
    protected LinkedList<Padawan> padawans;

    public Chef(String nom, String prenom, Genre genre, String telephone, String specialte) {
        super(nom, prenom, genre, telephone);
        this.etoiles = 0;
        this.specialte = specialte;
        this.plats = new ArrayList<>();
        this.padawans = new LinkedList<>();
    }

    public LinkedList<Padawan> getPadawans() {
        return padawans;
    }

    public void setPadawans(LinkedList<Padawan> padawans) {
        this.padawans = padawans;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }

    public ArrayList<Plat> getPlats() {
        return plats;
    }

    public void setPlats(ArrayList<Plat> plats) {
        this.plats = plats;
    }

    public String getSpecialte() {
        return specialte;
    }

    public void setSpecialte(String specialte) {
        this.specialte = specialte;
    }

    public boolean addPlat(Plat plat){
        if(!(this.plats.contains(plat))){
            this.plats.add(plat);
            return true;
        }else{
            System.out.println("Le chef connait déjà ce plat");
            return false;
        }
    }

    public void supPlat(Plat plat){
        this.plats.remove(plat);
    }

    public boolean addPadawan(Padawan padawan){
        if(!this.padawans.contains(padawan)){
            if(padawan.getChef()!=null){
                padawan.getChef().supPadawan(padawan);
            }
            padawan.setChef(this);
            this.padawans.add(padawan);

            return true;
        }else{
            System.out.println("Le chef possède déjà ce Padewan");
            return false;
        }
    }

    public void supPadawan(Padawan padawan){
        this.padawans.remove(padawan);
        padawan.setChef(null);
    }

    public Padawan nouveauChef(){

        Padawan p = this.padawans.poll();

        return p;
    }
}
