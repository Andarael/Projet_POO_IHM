package shadowLair.view.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import shadowLair.controller.ExecutionController;
import shadowLair.controller.MainController;
import shadowLair.model.entity.Entity;
import shadowLair.model.entity.Player;
import shadowLair.model.entity.item.Item;
import shadowLair.model.entity.item.Key;
import shadowLair.model.entity.place.Place;
import shadowLair.model.interfaces.Equipable;
import shadowLair.model.interfaces.Usable;
import shadowLair.model.interfaces.UsableOnItem;
import shadowLair.model.inventory.Inventory;

import java.util.Objects;


public class PlayerInventoryController extends ContainerInventoryController {

    /*======= FXML Nodes ========*/

    @FXML public Label useOnLabel;
    @FXML public ComboBox<Entity> selectionBox;
    @FXML private Button dropButton;
    @FXML private Button useButton;
    @FXML private Button equipButton;
    @FXML private Button unequipButton;

    /*======= FXML Actions ========*/

    @FXML
    public void unequipAction(ActionEvent actionEvent) {
        ExecutionController.executeUnequip();
    }

    @FXML
    public void equipAction(ActionEvent actionEvent) {
        ExecutionController.executeEquip();
    }

    @FXML
    public void useAction(ActionEvent actionEvent) {
        ExecutionController.executeUse();
    }

    @FXML
    public void dropAction(ActionEvent actionEvent) {
        ExecutionController.executeDrop();
    }

    /*======= inner variables ========*/

    private Place currentPlace = null;
    private Entity entityToUseItemOn = null;

    /*======= AbstractController overrides & initializations ========*/

    @Override
    public void initThis() {
        super.initThis();

        initSelectionBox();
    }

    @Override
    public void updateThis() {
        super.updateThis();
    }

    private void initSelectionBox() {
        selectionBox.setPlaceholder(new Label("Nothing to select"));

        listenSelectedEntityToBeUsedOn();
    }

    private void listenSelectedEntityToBeUsedOn() {
        selectionBox.getSelectionModel()
                    .selectedItemProperty()
                    .addListener((observable, oldValue, newValue) -> selectedEntityToBeUsedOnListener());
    }

    private void selectedEntityToBeUsedOnListener() {
        entityToUseItemOn = selectionBox.getSelectionModel().getSelectedItem();
        MainController.setSelectedEntityToUseItemOn(entityToUseItemOn);
    }

    private void clearSelectionBox() {
        selectionBox.getItems().clear();
    }

    private void addExitsToSelectionBox(Place currentPlace) {
        clearSelectionBox();

        if (currentPlace == null)
            return;

        ObservableList<Entity> entities = FXCollections.observableArrayList(currentPlace.getListExits());

        entities.stream()
                .filter(Objects::nonNull)
                .forEach(entity -> selectionBox.getItems().add(entity));
    }

    private void addItemsToSelectionBox(Inventory inventory) {
        clearSelectionBox();

        if (inventory == null)
            return;

        ObservableList<Entity> itemObservableList = FXCollections.observableArrayList(inventory.getItemList());
        selectionBox.setItems(itemObservableList);
    }


    /*======= updates form higher controllers ========*/

    @Override
    public void setSelectedItem(Item item) {
        if (getRootController() != null)
            MainController.setSelectedItemPlayer(item); // exec only if root is already initialized

        boolean isNull = (item == null);
        boolean isUsable = item instanceof Usable;
        boolean isEquipable = item instanceof Equipable;
        boolean isUsableOnSomething = (item instanceof UsableOnItem) || (item instanceof Key);

        dropButton.setDisable(isNull);
        equipButton.setDisable(isNull);
        useButton.setDisable(isNull);

        useButton.setDisable(!isUsable);
        equipButton.setDisable(!isEquipable);

        selectionBox.setDisable(!isUsableOnSomething);
        useOnLabel.setDisable(!isUsableOnSomething);

        clearSelectionBox();

        if (item instanceof Key)
            addExitsToSelectionBox(currentPlace);

        if (item instanceof UsableOnItem)
            addItemsToSelectionBox(inventoryController.getInventory());
    }

    public void setCurrentPlace(Place currentPlace) {
        inventoryController.setSelectedItem(null);
        this.currentPlace = currentPlace;
        clearSelectionBox();
    }

    public void setPlayer(Player player) {
        inventoryController.setCurrentContainer(player);
    }
}
