package app;

public class Legume extends Ingredient{

    protected double tauxDeFibres;

    public Legume(int id, String nom, boolean bio, int calories, double tauxDeFibres) {
        super(id, nom, bio, calories);
        this.tauxDeFibres = tauxDeFibres;
    }

    public double getTauxDeFibres() {
        return tauxDeFibres;
    }

    public void setTauxDeFibres(double tauxDeFibres) {
        this.tauxDeFibres = tauxDeFibres;
    }
}
