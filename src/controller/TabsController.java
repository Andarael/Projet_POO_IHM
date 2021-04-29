package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import model.entity.Container;
import model.entity.Hostile;
import model.entity.Passive;
import model.entity.StaticContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static controller.MainController.player;

// todo check pour la déscativation de loot

public class TabsController extends AbstractController {
    @FXML
    private VBox ChestInv;
    @FXML
    private Tab lootTab;
    @FXML
    private VBox traderInv;
    @FXML
    private Tab tradeTab;
    @FXML
    private VBox playerInv;
    @FXML
    private VBox chestInv;
    @FXML
    private TabPane tradeAndLootTabPane;

    @FXML
    private InventoryListController playerInvController;
    @FXML
    private InventoryListController traderInvController;
    @FXML
    private InventoryListController chestInvController;

    private Container selectedContainer;

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

//        traderInvController.setSelectedItem(null); // todo se décider si on garde ça ou pas ?
//        chestInvController.setSelectedItem(null);
        updateAllChildren();
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
                                             chestInvController));
    }

    private void setTabs(Container chestContainer, Container traderContainer, Tab activeTab) {
        chestInvController.setCurrentContainer(chestContainer);
        traderInvController.setCurrentContainer(traderContainer);
        tradeAndLootTabPane.getSelectionModel().select(activeTab);
    }

    public void setSelectedContainer(Container container) {
        this.selectedContainer = container;
        updateThis();
    }
}
