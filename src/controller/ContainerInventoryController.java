package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.entity.Container;
import model.entity.item.Item;

import java.util.Collections;
import java.util.List;

public abstract class ContainerInventoryController extends AbstractController {


    @FXML protected GridPane buttonArea;
    @FXML protected InventoryController inventoryController;
    @FXML private VBox inventory;

    @Override
    public void initThis() {
        setSelectedItem(null);
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return Collections.singletonList(inventoryController);
    }

    @Override
    public void updateThis() {
        inventoryController.updateThis();
    }

    public void setCurrentContainer(Container container) {
        inventoryController.setCurrentContainer(container);
    }

    abstract public void setSelectedItem(Item item);


}
