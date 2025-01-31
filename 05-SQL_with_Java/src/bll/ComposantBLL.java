package bll;

import bo.Composant;
import dal.ComposantDAO;
import exceptions.ComposantException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class ComposantBLL {

    private static List<String> listeTypes = Arrays.asList("RAM", "DD", "CPU", "GPU", "ALIM");

    public List<Composant> select(){

        ComposantDAO dao = new ComposantDAO();
        return dao.select();


    }

    public void insert(String nom, String type, LocalDate dateSortie) throws ComposantException {

        Composant composant = new Composant(nom, type, dateSortie);

        checkComposant(composant);

        ComposantDAO dao = new ComposantDAO();
        dao.insert(composant);

    }

    public void update(Composant composant) throws ComposantException{

        checkComposant(composant);

        ComposantDAO dao = new ComposantDAO();
        dao.update(composant);
    }

    public void delete(int id) {
        ComposantDAO dao = new ComposantDAO();
        dao.delete(id);
    }

    public void checkComposant(Composant composant) throws ComposantException {

        if(composant.getNom() == null || composant.getType() == null || composant.getDateSortie() == null){
            throw new ComposantException("Aucun des champs renseignés ne peut être vide !");
        }

        if(composant.getNom().length() > 50 || composant.getNom().length() < 2 ){
            throw new ComposantException("Le nom doit faire entre 2 et 50 caractères !");
        }

        if(!listeTypes.contains(composant.getType())){
            throw new ComposantException("Type de composant invalide !");
        }

        if(composant.getDateSortie().isBefore(LocalDate.of(1970, 1, 1))
                || composant.getDateSortie().isAfter(LocalDate.now())){
            throw new ComposantException("La date de sortie doit être comprise entre le 01/01/1970 et aujourd'hui !");
        }

    }

    public boolean composantPresent(){
        ComposantDAO dao = new ComposantDAO();
        return dao.composantPresent();
    }


}
