package command;

import java.util.List;

import static command.Command.getCommandFromString;
import static command.Command.isACommand;
import static utils.Col.GREEN;
import static utils.Col.colorize;
import static utils.Printer.printErr;
import static utils.Printer.printMsg;

public interface Help {

    static void help(String ... args) {
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
