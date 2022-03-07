// fichier par josué Raad

package shadowLair.model.command;

import shadowLair.model.entity.Player;
import shadowLair.model.entity.item.Hand;
import shadowLair.model.entity.item.Item;

import static shadowLair.model.utils.Printer.printMsg;

public interface EquipUnequip {

    static String unequip(Player player) {
        Item equipped = player.getEquipped();
        String message;

        if (equipped.isSame(new Hand())) {
            message = "You are already unequipped";
            printMsg(message);
        } else {
            player.unequip();
            message = "You unequipped : " + equipped.getName();
            printMsg(message);
        }
        return message;
    }

    static String equip(Player player, String arg1) {
        String message;
        if (player.equip(arg1)) {
            message = "You equipped " + arg1;
            printMsg(message);
        } else {
            message = arg1 + " is not equippable";
            printMsg(message);
        }
        return message;
    }
}
