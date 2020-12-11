package command;

import entity.Being;
import entity.Container;
import entity.Passive;
import entity.Player;
import entity.item.Item;
import entity.place.Place;

import static utils.Printer.printErr;
import static utils.Printer.printMsg;

public interface Trade {
    static void sell(Player player, Place currentPlace, String npcName, String itemName) {

        Container buyer = currentPlace.getContainerByName(npcName);

        if (buyer == null) {
            printErr(npcName + " is not here");
            return;
        }

        if (!(buyer instanceof Passive)) {
            printErr("You can't buy from " + npcName);
            return;
        }

        trade((Being) buyer, player, itemName);
    }

    static void buy(Player player, Place currentPlace, String npcName, String itemName) {

        Container seller = currentPlace.getContainerByName(npcName);

        if (seller == null) {
            printErr(npcName + " is not here");
            return;
        }

        if (!(seller instanceof Passive)) {
            printErr("You can't sell to " + npcName);
            return;
        }

        trade(player, (Being) seller, itemName);
    }

    static void trade(Being buyer, Being seller, String itemName) {

        Item item = seller.getItem(itemName);

        if (item == null) {
            printErr(seller.getName() + " don't have " + itemName);
            return;
        }

        int itemValue = item.getValue();

        if (!buyer.canPay(itemValue)) {
            printMsg(buyer.getName() + " don't have enough gold to buy " + item.getName());
            return;
        }

        if (!buyer.canAddItem(item)) {
            printMsg(buyer.getName() +
                     " can't add" +
                     item.getName() +
                     "to its inventory, it weigts too much ");
        }

        buyer.removeGold(itemValue);
        seller.addGold(itemValue);

        printMsg(buyer.getName() +
                 " bought " +
                 item.getName() +
                 " from " +
                 seller.getName() +
                 " for " +
                 itemValue +
                 " gold(s)");
    }
}
