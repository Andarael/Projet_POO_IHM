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

import java.util.List;

import static controller.RessourceManager.getRessourceString;
import static controller.utils.Utils.*;

public class InventoryListController extends AbstractController {

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

    private Item selectedItem = null;

    private Container currentContainer = null;

    // todo add gold display from the list
    // todo description (equipable, restoration, damages)
    // todo retour à la ligne dans la description
    // todo récupérer le nom du container à afficher
    // todo Afficher les clés de la bonne couleur

    // todo plein de trucs pour le bon MVC
    // todo on peut faire en sorte que au niveau du dessus, on écoute le changement d'item sélectionné
    // et en fonction du ctrller dans lequel on est on met à jour la var correspondante dans le MainController

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
                 .addListener((observable, oldValue, newValue) -> updateSelectedItem());
    }

    private void updateSelectedItem() {
        selectedItem = itemTable.getSelectionModel().getSelectedItem();
        // getParentController().setSelectedItem(selectedItem); // todo
        updateDescriptionArea();


        // todo mej de l'item select dans MainController
        // todo update actions (use etc..)
    }

    private void updateDescriptionArea() {

        if (this.selectedItem == null /*|| getItem(world, selectedItem.getName()) == null*/) {
            descriptionTextArea.setText(null);
            return;
        }

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

    public Inventory getInventory() {
        if (currentContainer == null)
            return new Inventory();

        return currentContainer.getInventory();
    }

    private void updateGold() {
        Inventory inventory = getInventory();
        int gold = inventory.getGold();
        labelGold.setText(pluralize("gold", gold));
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

        // todo ça me semble bien ici pour colorier les icons des clés
    }

    public void setCurrentContainer(Container currentContainer) {
        this.currentContainer = currentContainer;
        updateThis();
    }

    public void setSelectedItem(Item item) {
        this.selectedItem = item;

        updateThis();
    }
}
