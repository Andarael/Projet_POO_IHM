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
import model.entity.item.Bow;
import model.entity.item.Food;
import model.entity.item.Item;
import model.entity.item.Weapon;
import model.interfaces.Equipable;
import model.interfaces.Usable;
import model.inventory.Inventory;

import java.util.List;

import static controller.RessourceManager.getRessourceString;
import static controller.utils.Utils.*;

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
                 .addListener((observable, oldValue, newValue) -> selectedItemListener());
    }

    private void selectedItemListener() {
        selectedItem = itemTable.getSelectionModel().getSelectedItem();

        updateDescriptionArea();

        if (getParentController() instanceof ContainerInventoryController)
            ((ContainerInventoryController) getParentController()).setSelectedItem(selectedItem);
    }


    private void updateDescriptionArea() {

        // todo pour la bouffe et les clés etc...
        if (this.selectedItem == null) {
            descriptionTextArea.setText(null);
            return;
        }

        String name = capitalize(readable(selectedItem.getName())) + ", ";
        String description = capitalize(selectedItem.getDescription());
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
            modifiers += "\n";

        if (selectedItem instanceof Bow) {
            Bow bow = (Bow) this.selectedItem;
            int nbArrows = bow.getArrows();
            stats += "- Damages : " + bow.getPowerNoConsume() + "\n";
            stats += pluralize("- Arrow", nbArrows) + " : " + nbArrows + "\n";

        } else if(selectedItem instanceof Weapon) {
            Weapon weapon = (Weapon) selectedItem;
            stats += "- Damages : " + weapon.getPower() + "\n";
        }

        if (selectedItem instanceof Food)
            stats += "- Restoration : " + ((Food) selectedItem).getRestoreValue() + " hp \n";


        descriptionTextArea.setText("- " + name + "\n" + "- " + modifiers + stats + "- " +  description);
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
