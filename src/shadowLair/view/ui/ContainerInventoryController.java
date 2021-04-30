package shadowLair.view.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import shadowLair.model.entity.Container;
import shadowLair.model.entity.item.Item;

import java.util.Collections;
import java.util.List;

/**
 * This abstract class is a layer between the inventory controller and the entity that owns this inventory
 * It allows the MainController to differenciate the inventories of a chest from an NPC from a being
 * It also allows to have different button layouts with different actions bellow the inventory
 *
 * When this receive an update the buttons are set accordingly
 * and the update passed down to the InventoryController if necessary
 */
public abstract class ContainerInventoryController extends AbstractController {

    /*======= FXML nodes & controllers ========*/

    @FXML protected GridPane buttonArea;
    @FXML private VBox inventory;
    @FXML protected InventoryController inventoryController;

    /*======= AbstractController overrides ========*/

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

    /*======= method to implement ========*/

    abstract public void setSelectedItem(Item item);


}
