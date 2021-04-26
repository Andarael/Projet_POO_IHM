package controller;

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
import model.entity.Container;
import model.entity.item.Item;
import model.interfaces.Equipable;
import model.interfaces.Usable;
import model.inventory.Inventory;
import model.world.StaticWorld;
import model.world.World;

import static controller.RessourceManager.getRessourceString;
import static controller.utils.Utils.capitalize;
import static controller.utils.Utils.readable;
import static model.world.WorldContains.getItem;

public class InventoryListController {

    @FXML
    public Label labelGold;
    @FXML
    public TextArea descriptionTextArea;
    @FXML
    public TableView<Item> itemTable;
    @FXML
    public TableColumn<Item, String> itemNameColumn;
    @FXML
    public TableColumn<Item, String> itemValueColumn;
    @FXML
    public TableColumn<Item, String> itemWeightColumn;
    @FXML
    public TableColumn<Item, ImageView> itemTypeColumn;

    World world = StaticWorld.world;
    public Container currentContainer = world.getPlayer();

    // todo add gold display from the list
    // todo description (equipable, restoration, damages)
    // todo retour à la ligne dans la description
    // todo récupérer le nom du container à afficher

    @FXML
    public void initialize() {
        initTable();
        listenSelectedItemInTable();
        world.getPlayer().addItem(new Item("empapaoutai OUTAIOUTAI PAPAOUTAI? ")); // todo remove

        updateAll();

    }

    public void updateAll() {
        if (currentContainer == null)
            return;

        updateTable();
        updateGold();
    }

    private void initTable() {
        itemTypeColumn.setCellValueFactory(this::typeImageViewFactory);
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        itemWeightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
    }

    private void listenSelectedItemInTable() {
        itemTable.getSelectionModel()
                 .selectedItemProperty()
                 .addListener((observable, oldValue, newValue) -> updateDescriptionArea());
    }

    private Inventory getInventory() {
        return currentContainer.getInventory();
    }

    private void updateDescriptionArea() {
        Item selectedItem = itemTable.getSelectionModel().getSelectedItem();

        if (selectedItem == null || getItem(world, selectedItem.getName()) == null)
            return;

        String name = capitalize(readable(selectedItem.getName())) + ", ";
        String description = capitalize(selectedItem.getDescription());
        String modifiers = "";

        if (selectedItem instanceof Equipable)
            modifiers += "Equipable ";

        if (selectedItem instanceof Usable) {
            if (modifiers.length() != 0)
                modifiers += "and ";
            modifiers += "Usable ";
        }


        if (modifiers.length() != 0)
            modifiers += " : \n";


        descriptionTextArea.setText(name + modifiers + description);
    }

    private void updateGold() {
        Inventory inventory = getInventory();
        int gold = inventory.getGold();
        if (gold == 1)
            labelGold.setText("Gold : 1 ");
        else
            labelGold.setText("Golds : " + gold);
    }

    private void updateTable() {
        Inventory inventory = getInventory();

        ObservableList<Item> itemObservableList = FXCollections.observableArrayList(inventory.getItemList());

        itemTable.getItems().clear();
        itemTable.setItems(itemObservableList);
    }

    private ObservableValue<ImageView> typeImageViewFactory(TableColumn.CellDataFeatures<Item, ImageView> cell) {
        String itemType = cell.getValue().getClass().getSimpleName().toLowerCase();
        ImageView imageView = new ImageView(new Image(getRessourceString(itemType, ".png", this)));
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
        return new SimpleObjectProperty<>(imageView);
    }
}
