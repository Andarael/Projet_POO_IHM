// fichier par josué  et Thibaut

package shadowLair.model.command;

import shadowLair.model.entity.Being;
import shadowLair.model.entity.Container;
import shadowLair.model.entity.Passive;
import shadowLair.model.entity.Player;
import shadowLair.model.entity.item.Item;
import shadowLair.model.entity.place.Place;

import static shadowLair.model.utils.Printer.printErr;
import static shadowLair.model.utils.Printer.printMsg;

public interface Trade {
    static String sell(Player player, Place currentPlace, String npcName, String itemName) {

        Container buyer = currentPlace.getContainerByName(npcName);

        if (buyer == null) {
            return printErr(npcName + " is not here");
        }

        if (!(buyer instanceof Passive)) {
            return printErr("You can't buy from " + npcName);
        }

        return trade((Being) buyer, player, itemName);
    }

    static String buy(Player player, Place currentPlace, String npcName, String itemName) {

        Container seller = currentPlace.getContainerByName(npcName);

        if (seller == null) {
            return printErr(npcName + " is not here");
        }

        if (!(seller instanceof Passive)) {
            return printErr("You can't sell to " + npcName);
        }

        return trade(player, (Being) seller, itemName);
    }

    static String trade(Being buyer, Being seller, String itemName) {

        Item item = seller.getItem(itemName);

        if (item == null) {
            return printErr(seller.getName() + " don't have " + itemName);
        }

        int itemValue = item.getValue();

        if (!buyer.canPay(itemValue)) {
            return printMsg(buyer.getName() + " don't have enough gold to buy " + item.getName());
        }

        if (!buyer.canAddItem(item)) {
            return printMsg(buyer.getName() +
                            " can't add" +
                            item.getName() +
                            "to its inventory, it weights too much ");
        }

        buyer.removeGold(itemValue);
        seller.addGold(itemValue);
        seller.removeItem(item);
        buyer.addItem(item);

        return printMsg(buyer.getName() +
                        " bought " +
                        item.getName() +
                        " from " +
                        seller.getName() +
                        " for " +
                        itemValue +
                        " gold(s)");
    }
}
