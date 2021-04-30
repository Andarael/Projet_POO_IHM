package view.ui;

import controller.ExecutionController;
import controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.entity.item.Item;

public class LootInventoryController extends ContainerInventoryController {

    private Item selectedItemLoot;

    @FXML
    public void takeSelectedItem(ActionEvent actionEvent) {
        ExecutionController.executeTake();
    }

    @FXML
    public void sellSelectedItem(ActionEvent actionEvent) {
        ExecutionController.executeSell();
    }

    @FXML
    public void takeItem(ActionEvent actionEvent) {
        ExecutionController.executeTake();
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
