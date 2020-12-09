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

        List<String> inputTabStr = new ArrayList<>();
        String commandString;
        int args;
        boolean isInvalid = true;

        while (isInvalid) {

            if (scanner.hasNext())
                inputTabStr = Arrays.asList(scanner.nextLine().split(" "));

            if (inputTabStr.size() > 0) {
                commandString = inputTabStr.get(0);
                args = inputTabStr.size() - 1;
                isInvalid = !isValidCommand(getCommandFromString(commandString), args);
            }

            inputTabStr = inputTabStr.stream()
                                     .map(x -> {
                                         x = x.toUpperCase();
                                         return x;
                                     }).collect(Collectors.toList());

            if (isInvalid) {
                System.out.println(inputTabStr +
                                   " Is not a valid command, try to type HELP");
            }
        }

        return inputTabStr;

        // return inputTabStr;
    }

    public static void main(String[] args) {
        System.out.println("type a command : ");
        List<String> strTab = new ArrayList<>();
        strTab.add("GO");

        while (!strTab.get(0).equals("QUIT")) {

            strTab = interpret();

            System.out.println(strTab);
        }


    }

}
