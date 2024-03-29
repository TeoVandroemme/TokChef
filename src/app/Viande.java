package app;

public class Viande extends Ingredient{

    protected double tauxDeGras;

    public Viande(int id, String nom, boolean bio, int calories, double tauxDeGras) {
        super(id, nom, bio, calories);
        this.tauxDeGras = tauxDeGras;
    }

    public double getTauxDeGras() {
        return tauxDeGras;
    }

    public void setTauxDeGras(double tauxDeGras) {
        this.tauxDeGras = tauxDeGras;
    }
}
