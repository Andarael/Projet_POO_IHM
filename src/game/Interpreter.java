package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static game.EnumCommand.getCommandFromString;
import static game.EnumCommand.isValidCommand;

public class Interpreter {


    public static List<String> interpret() {
        Scanner scanner = new Scanner(System.in);

        List<String> stringList = new ArrayList<>();
        String commandString;
        int args;
        boolean isInvalid = true;

        while (isInvalid) {

            stringList = Arrays.asList(scanner.nextLine().split(" "));

            // vérification que l'on n'a pas reçu une Liste vide
            // Et initialisation des variables pour le test de validité
            if (stringList.size() > 0) {
                commandString = stringList.get(0);
                args = stringList.size() - 1;
                isInvalid = !isValidCommand(getCommandFromString(commandString), args);
            }

            // conversion en majuscules de la lsite des arguments de la commande
            stringList = stringList.stream()
                                   .map(x -> {
                                       x = x.toUpperCase();
                                       return x;
                                   })
                                   .collect(Collectors.toList());

            // si invalide on affiche un msg d'erreur
            if (isInvalid)
                System.out.println(stringList + " Is not a valid command, try 'HELP'");
        }

        return stringList;
    }

    public static void main(String[] args) {
        System.out.println("type a command : ");
        List<String> stringList = new ArrayList<>();
        stringList.add("GO");

        while (!stringList.get(0).equals("QUIT")) {

            stringList = interpret();

            System.out.println(stringList);
            System.out.println("We execute : " + getCommandFromString(stringList.get(0)));
        }


    }

}
