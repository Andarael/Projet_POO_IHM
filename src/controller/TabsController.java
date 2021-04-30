package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import model.entity.*;
import model.entity.item.Item;
import model.entity.place.Place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabsController extends AbstractController {

    @FXML private VBox ChestInv;
    @FXML private Tab lootTab;
    @FXML private VBox traderInv;
    @FXML private Tab tradeTab;
    @FXML private VBox playerInv;
    @FXML private VBox lootInv;
    @FXML private TabPane tradeAndLootTabPane;

    @FXML private PlayerInventoryController playerInvController;
    @FXML private TraderInventoryController traderInvController;
    @FXML private LootInventoryController lootInvController;

    private Container selectedContainer;

    private Player player;

    @Override
    public void initThis() {
        playerInvController.setCurrentContainer(player);

        updateThis();
    }

    @Override
    public void updateThis() {

        if (selectedContainer == null ||
            selectedContainer == player ||
            selectedContainer instanceof Hostile) {
            setInvisibleTabsOnTheRight(true);
        } else {
            setInvisibleTabsOnTheRight(false);
            boolean isPassive = selectedContainer instanceof Passive;
            boolean isChest = selectedContainer instanceof StaticContainer;
            tradeTab.setDisable(isChest);
            lootTab.setDisable(isPassive);

            if (isPassive)
                setTabs(null, selectedContainer, tradeTab);

            else if (isChest)
                setTabs(selectedContainer, null, lootTab);

            else
                setTabs(null, null, null);
        }

        lootInvController.updateThis();
        traderInvController.updateThis();

        // System.out.println(lootTab.isDisabled());
        // javafx dit que le loot tab est disable. Alors qu'il ne l'est clairement pas dans l'interface ... s
    }

    private void setInvisibleTabsOnTheRight(boolean b) {
        tradeAndLootTabPane.setDisable(b);
        tradeAndLootTabPane.setOpacity(b ? 0 : 1);
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return new ArrayList<>(Arrays.asList(playerInvController,
                                             traderInvController,
                                             lootInvController));
    }

    private void setTabs(Container chestContainer, Container traderContainer, Tab activeTab) {
        lootInvController.setCurrentContainer(chestContainer);
        traderInvController.setCurrentContainer(traderContainer);
        tradeAndLootTabPane.getSelectionModel().select(activeTab);
    }

    public void updateSelectedContainer(Container container) {
        this.selectedContainer = container;
        traderInvController.setSelectedItem(null);
        updateThis();
    }

    public void setPlayer(Player player) {
        this.player = player;
        playerInvController.setPlayer(player);
        playerInvController.updateThis();
    }

    public void setCurrentPlace(Place currentPlace) {
        playerInvController.setCurrentPlace(currentPlace);
    }

    public void setSelectedItemPlayer(Item item) {
        traderInvController.setSelectedItemPlayer(item);
    }
}
