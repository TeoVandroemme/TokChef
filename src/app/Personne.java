package app;

public class Personne {

    protected String nom;
    protected String prenom;
    protected Genre genre;
    protected String telephone;

    public Personne(String nom, String prenom, Genre genre, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    @Override
    public String toString() {
        return this.nom+" "+this.prenom;
    }
}
