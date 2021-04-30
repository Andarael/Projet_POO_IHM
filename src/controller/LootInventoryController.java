package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.entity.item.Item;

public class LootInventoryController extends ContainerInventoryController {

    private Item selectedItemLoot;

    @FXML
    public void takeSelectedItem(ActionEvent actionEvent) {
        MainController.executeTake();
    }

    @FXML
    public void sellSelectedItem(ActionEvent actionEvent) {
        MainController.executeSell();
    }

    @FXML
    public void takeItem(ActionEvent actionEvent) {
        MainController.executeTake();
    }

    @Override
    public void setSelectedItem(Item item) {
        selectedItemLoot = item;

        MainController.setSelectedItemLoot(selectedItemLoot);

        setButtonState();
    }

    private void setButtonState() {
        buttonArea.setDisable(selectedItemLoot == null);
    }
}
