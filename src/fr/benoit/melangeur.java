package fr.benoit;

import java.util.Random;
import java.util.Scanner;


public class melangeur {

    private static Random rnd = new Random();

    public static void main(String[] args) {


        String phrase = saisirString("Veuillez saisir votre phrase :");
        String[] mots = phrase.split(" ");
        String resultat = "";

        for (int i = 0; i < mots.length; i++) {
            if (i > 0) resultat += " ";
            resultat += melangeMot(mots[i]);
        }

        System.out.println("Phrase : " + resultat);
    }

    /**
     * Mélange les lettres d'un mot (en gardant la première et la dernière)
     *
     * @param mot
     * @return le mot mélangé
     */
    private static String melangeMot(String mot) {
        String resultat = "";

        if (mot.length() <= 2) resultat = mot;
        else {
            String tempMot = mot.substring(1, mot.length() - 1);

            while (tempMot.length() >= 2) {
                int rndValue = 1 + rnd.nextInt(tempMot.length() - 1);
                resultat += tempMot.charAt(rndValue);
                tempMot = tempMot.substring(0, rndValue) + tempMot.substring(rndValue + 1);
            }

            resultat = mot.substring(0, 1) + resultat + tempMot + mot.substring(mot.length() - 1);
        }

        return resultat;
    }


    /**
     * Affiche un message et retourne une saisie de type String
     *
     * @param message à afficher
     * @return La saisie entrée par l'utilisateur
     */
    private static String saisirString(String message) {
        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }


}
