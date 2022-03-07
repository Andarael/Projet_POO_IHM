// Fichier par Josué et Thibaut

package shadowLair.model.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static shadowLair.model.command.Command.getCommandFromString;
import static shadowLair.model.command.Command.isValidCommand;
import static shadowLair.model.utils.Printer.printErr;

public class Inputer {

    /**
     * Get a command input from the user
     * If the command is not valid a message is displayed and the user must try again
     * Only a valid command can exit this methode
     *
     * @return a list of Strings containing a valid command and its arguments
     */
    public static List<String> getUserInput() {
        Scanner scanner = new Scanner(System.in);

        List<String> stringList = new ArrayList<>();
        String commandString;
        Command command;
        int args;
        boolean isInvalid = true;

        while (isInvalid) {
            stringList = Arrays.asList(scanner.nextLine().split(" "));

            // vérification que l'on n'a pas reçu une Liste vide
            if (stringList.size() > 0) {
                commandString = stringList.get(0);
                args = stringList.size() - 1;

                command = getCommandFromString(commandString);
                if (command == null) {
                    printErr(commandString + " is not a valid command, try 'help'");
                    continue;
                }

                // test d'invalidité
                isInvalid = !isValidCommand(command, args);


                // conversion en majuscules de la liste des arguments de la commande
                stringList = stringList.stream()
                                       .map(x -> {
                                           x = x.toUpperCase();
                                           return x;
                                       })
                                       .collect(Collectors.toList());

                // si invalide on affiche un msg d'erreur
                // et on reprend à la prochaine itération de la boucle
                if (isInvalid)
                    printErr(stringList +
                             " Is not a valid format for command '" +
                             commandString +
                             "' , try 'HELP " + commandString + "'");

            }
        }

        return stringList;
    }

    public static void main(String[] args) {
        System.out.println("type a command : ");
        List<String> stringList = new ArrayList<>();
        stringList.add("GO");

        while (!stringList.get(0).equalsIgnoreCase("QUIT")) {

            stringList = getUserInput();

            System.out.println(stringList);
            System.out.println("We execute : " + getCommandFromString(stringList.get(0)));
        }
    }

}
