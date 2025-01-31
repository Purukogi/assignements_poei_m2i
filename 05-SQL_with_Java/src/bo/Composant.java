package bo;

import java.time.LocalDate;

public class Composant {

    private int id;
    private String nom;
    private String type;
    private LocalDate dateSortie;

    public Composant(int id, String nom, String type, LocalDate dateSortie) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.dateSortie = dateSortie;
    }

    public Composant(String nom, String type, LocalDate dateSortie) {
        this.nom = nom;
        this.type = type;
        this.dateSortie = dateSortie;
    }

    public Composant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Override
    public String toString() {
        return id + ", Nom : " + nom + ", Type : " + type + ", Sorti le : " + dateSortie;
    }
}
