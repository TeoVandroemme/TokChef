package app;

import java.util.ArrayList;

public class Jury extends Personne{
    protected int nb_jury;
    protected ArrayList<Concours> concours;

    public Jury(String nom, String prenom, Genre genre, String telephone) {
        super(nom, prenom, genre, telephone);
        this.nb_jury = 0;
        this.concours = new ArrayList<>();
    }

    public int getNb_jury() {
        return nb_jury;
    }

    public void setNb_jury(int nb_jury) {
        this.nb_jury = nb_jury;
    }

    public ArrayList<Concours> getConcours() {
        return concours;
    }

    public void setConcours(ArrayList<Concours> concours) {
        this.concours = concours;
    }

    public void addConcours(Concours concours){
        this.concours.add(concours);
        this.nb_jury++;
    }
}
