package command;

import entity.Player;
import entity.item.Hand;
import entity.item.Item;

import static utils.Printer.printMsg;

public interface EquipUnequip {

    static void unequip(Player player) {
        Item equipped = player.getEquipped();

        if (equipped.isSame(new Hand())) {
            printMsg("You are already unequipped");
        } else {
            player.unequip();
            printMsg("You unequipped : " + equipped.getName());
        }

    }

    static void equip(Player player, String arg1) {
        if (player.equip(arg1))
            printMsg("You equipped " + arg1);
        else
            printMsg(arg1 + " is not equippable");
    }
}
