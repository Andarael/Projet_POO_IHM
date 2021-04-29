package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.entity.Player;
import model.entity.item.Item;

import java.util.Collections;
import java.util.List;

public class ContainerInventoryController extends AbstractController {


    @FXML private VBox inventory;
    @FXML private GridPane buttonArea;

    @FXML protected InventoryController inventoryController;

    @Override
    public void initThis() { setSelectedItem(null); }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return Collections.singletonList(inventoryController);
    }

    @Override
    public void updateThis() {
        inventoryController.updateThis();
    }

    public void setCurrentContainer(Player player) {
        inventoryController.setCurrentContainer(player);
    }

    public void setSelectedItem(Item item) {
        buttonArea.setDisable(item == null);
        inventoryController.setSelectedItem(item);
        System.out.println("lolilol");
    }


}
