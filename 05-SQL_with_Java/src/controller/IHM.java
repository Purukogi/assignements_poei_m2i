package controller;

import bll.ComposantBLL;
import exceptions.ComposantException;
import jdk.jfr.Category;


import java.lang.management.PlatformLoggingMXBean;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class IHM {

    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws ComposantException {

        IHM ihm = new IHM();

        int choix;
        do{
            System.out.println("""
                    Que voulez-vous faire ?\
                    
                    \t 1 - Créer un composant\
                    
                    \t 2 - Consulter les composants\
                    
                    \t 3 - Supprimer un composant\
                    
                    \t 4 - Quitter""");
            choix = ihm.scan.nextInt();

            ihm.afficherSousMenu(choix);

        }while (choix != 4);
        ihm.scan.close();
    }

    public void afficherSousMenu(int choix) throws ComposantException {
        switch (choix) {
            case 1 -> afficherMenuCreation();
            case 2 -> consulterComposants();
            case 3 -> {
                if (composantsPresents()) {
                    afficherMenuSuppression();
                }else{
                    System.out.println("Pas de composants dans la BDD !\n");}
            }
            case 4 -> System.out.println("Au revoir !");
            default -> System.out.println("Saisie invalide !");
        }
    }

    public void consulterComposants(){
        ComposantBLL bll = new ComposantBLL();
        System.out.println(bll.select());
    }

    public boolean composantsPresents(){
        ComposantBLL bll = new ComposantBLL();
        return bll.composantPresent();
    }

    public void afficherMenuSuppression(){
        ComposantBLL bll = new ComposantBLL();
        System.out.println("ID du composant à supprimer ?");
        int choix = scan.nextInt();
        bll.delete(choix);
    }

    public void afficherMenuCreation() throws ComposantException {
        String nom, type, dateSortie;
        ComposantBLL dll = new ComposantBLL();

        System.out.println("Nom du composant ?");
        scan.nextLine();
        nom = scan.nextLine();
        System.out.println("Type du composant ?");
        type = scan.nextLine();
        System.out.println("Date de sortie ? (jj/mm/aaaa)");
        dateSortie = scan.nextLine();
        try {
            LocalDate date = LocalDate.parse(dateSortie, DateTimeFormatter.ofPattern("dd/MM/uuuu"));
            dll.insert(nom, type, date);
            System.out.println("Composant créé avec succès !");
        }catch (DateTimeParseException e){
            throw new ComposantException("La date doit être au format jj/mm/aaaa");
        }

    }

}
