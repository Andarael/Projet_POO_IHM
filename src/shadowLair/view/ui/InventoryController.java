package shadowLair.view.ui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import shadowLair.model.entity.Container;
import shadowLair.model.entity.item.*;
import shadowLair.model.interfaces.Equipable;
import shadowLair.model.interfaces.Usable;
import shadowLair.model.inventory.Inventory;
import shadowLair.model.utils.StringUtils;

import java.util.List;

import static shadowLair.view.RessourceManager.getRessourceString;

/**
 * This controller is associated with the fxml file for an inventory
 * It can actually display any inventory.
 * It receives the Container from which the inventory is to be displayed
 * from higher up controllers
 *
 * I use a TableView with a custom cellFactory for the item type image
 * The TableView eases the management of the selected item (i just added a listener to the selection change)
 *
 * When an item is selected a notification is sent to the MainController
 * the description is also updated
 */
public class InventoryController extends AbstractController {

    @FXML public Label labelGold;
    @FXML public TextArea descriptionTextArea;
    @FXML public TableView<Item> itemTable;
    @FXML public TableColumn<Item, String> itemNameColumn;
    @FXML public TableColumn<Item, String> itemValueColumn;
    @FXML public TableColumn<Item, String> itemWeightColumn;
    @FXML public TableColumn<Item, ImageView> itemTypeColumn;

    private Item selectedItem = null;

    private Container currentContainer = null;

    @Override
    public void initThis() {
        initTable();
        listenSelectedItemInTable();

        updateThis();
    }

    @Override
    public void updateThis() {
        updateTable();
        updateGold();
        updateDescriptionArea();
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return null;
    }

    private void initTable() {
        itemTable.setPlaceholder(new Label("No Items"));

        itemTypeColumn.setCellValueFactory(this::typeImageViewFactory);
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        itemWeightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
    }

    private void listenSelectedItemInTable() {
        itemTable.getSelectionModel()
                 .selectedItemProperty()
                 .addListener((observable, oldValue, newValue) -> selectedItemListener());
    }

    private void selectedItemListener() {
        selectedItem = itemTable.getSelectionModel().getSelectedItem();

        updateDescriptionArea();

        if (getParentController() instanceof ContainerInventoryController)
            ((ContainerInventoryController) getParentController()).setSelectedItem(selectedItem);
    }


    private void updateDescriptionArea() {

        if (this.selectedItem == null) {
            descriptionTextArea.setText(null);
            return;
        }

        String name = StringUtils.capitalize(StringUtils.readable(selectedItem.getName())) + ", ";
        String description = StringUtils.capitalize(selectedItem.getDescription());
        String modifiers = "";
        String stats = "";

        if (selectedItem instanceof Equipable)
            modifiers += "Equipable ";

        if (selectedItem instanceof Usable) {
            if (modifiers.length() != 0)
                modifiers += "and ";
            modifiers += "Usable ";
        }

        if (modifiers.length() != 0)
            modifiers = "- " + modifiers + "\n";

        if (selectedItem instanceof Bow) {
            Bow bow = (Bow) this.selectedItem;
            int nbArrows = bow.getArrows();
            stats += "- Damages : " + bow.getPowerNoConsume() + "\n";
            stats += StringUtils.pluralize("- Arrow", nbArrows) + " : " + nbArrows + "\n";

        } else if (selectedItem instanceof Weapon) {
            Weapon weapon = (Weapon) selectedItem;
            stats += "- Damages : " + weapon.getPower() + "\n";
        }

        if (selectedItem instanceof Food)
            stats += "- Restoration : " + ((Food) selectedItem).getRestoreValue() + " hp \n";


        descriptionTextArea.setText("- " + name + "\n" + modifiers + stats + "- " + description);
    }

    public Inventory getInventory() {
        if (currentContainer == null)
            return new Inventory();

        return currentContainer.getInventory();
    }

    private void updateGold() {
        Inventory inventory = getInventory();
        int gold = inventory.getGold();
        labelGold.setText(StringUtils.pluralize("gold", gold) + " : " + gold);

    }

    private void updateTable() {
        Inventory inventory = getInventory();
        ObservableList<Item> itemObservableList = FXCollections.observableArrayList(inventory.getItemList());
        itemTable.getItems().clear();
        itemTable.setItems(itemObservableList);
    }

    private ObservableValue<ImageView> typeImageViewFactory(TableColumn.CellDataFeatures<Item, ImageView> cell) {
        String itemType;
        Item item = cell.getValue();

        if (item instanceof Key)
            itemType = "key_" + ((Key) item).getColor().getColorName();
        else
            itemType = item.getClass().getSimpleName().toLowerCase();

        ImageView imageView = new ImageView(new Image(getRessourceString(itemType, ".png")));
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);

        return new SimpleObjectProperty<>(imageView);
    }

    public void setCurrentContainer(Container container) {
        currentContainer = container;
        updateThis();
    }

    public void setSelectedItem(Item item) {
        selectedItem = item;

        updateThis();
    }
}
