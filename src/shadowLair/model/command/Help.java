// fichier par josué Raad

package shadowLair.model.command;

import static shadowLair.model.command.Command.getCommandFromString;
import static shadowLair.model.command.Command.isACommand;
import static shadowLair.model.utils.Col.GREEN;
import static shadowLair.model.utils.Col.colorize;
import static shadowLair.model.utils.Printer.printErr;
import static shadowLair.model.utils.Printer.printMsg;

public interface Help {

    static void help(String... args) {
        if (args.length == 1)
            help();
        if (args.length == 2)
            help(args[1]);
    }

    static void help(String arg) {
        if (!isACommand(arg)) {
            printErr(arg + " is not a command");
            help("help");
        } else {
            printMsg(colorize(getCommandFromString(arg).getCommandUsage(), GREEN));
        }
    }

    static void help() {
        help("help");
    }
}
