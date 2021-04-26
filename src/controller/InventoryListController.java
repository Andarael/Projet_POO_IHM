package controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.entity.Container;
import model.entity.item.Item;
import model.inventory.Inventory;
import model.world.StaticWorld;
import model.world.World;

import static controller.RessourceManager.getRessourceString;

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
        world.getPlayer().addItem(new Item("empapaoutai ? ")); // todo remove

        updateAll();

    }

    public void updateAll() {
        updateTable();
        updateGold();
    }

    private void initTable() {
        itemTypeColumn.setCellValueFactory(this::call);
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

        if (selectedItem == null)
            return;

        descriptionTextArea.setText(selectedItem.getDescription());
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

    private ObservableValue<ImageView> call(TableColumn.CellDataFeatures<Item, ImageView> c) {
        String itemType = c.getValue().getClass().getSimpleName().toLowerCase();
        ImageView imageView = new ImageView(new Image(getRessourceString(itemType, ".png", this)));
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
        return new SimpleObjectProperty<>(imageView);
    }
}
