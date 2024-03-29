package app;

public class Padawan extends Personne{
    protected Chef chef;

    public Padawan(String nom, String prenom, Genre genre, String telephone, Chef chef) {
        super(nom, prenom, genre, telephone);
        this.chef = chef;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }
}
