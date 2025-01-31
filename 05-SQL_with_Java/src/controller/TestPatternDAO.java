package controller;

import bll.ComposantBLL;
import bo.Composant;
import exceptions.ComposantException;

import java.time.LocalDate;
import java.util.List;

public class TestPatternDAO {

    public static void main(String[] args) throws ComposantException {

        ComposantBLL composantBLL = new ComposantBLL();

        composantBLL.insert("composant3", "GPU", LocalDate.now());
        List<Composant> composants = composantBLL.select();

        for (Composant composant : composants){
            System.out.println(composant);
        }

        Composant first = composants.getFirst();
        first.setNom("changé");
        first.setType("aussi");
        first.setDateSortie(LocalDate.of(1992, 9, 13));
        composantBLL.update(first);

        composantBLL.delete(5);

        composants = composantBLL.select();

        for (Composant composant : composants){
            System.out.println(composant);
        }




    }

}
