package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.entity.item.Item;

public class TraderInventoryController extends ContainerInventoryController {


    @FXML private Button buyButton;
    @FXML private Button sellButton;

    private Item selectedItemPlayer;
    private Item selectedItemTrader;

    public void setSelectedItemPlayer(Item item) {
        this.selectedItemPlayer = item;
        setButtonState();
    }

    @FXML
    public void buySelectedItem(ActionEvent actionEvent) {
        MainController.executeBuy();
    }

    @FXML
    public void sellSelectedItem(ActionEvent actionEvent) {
        MainController.executeSell();
    }

    @Override
    public void setSelectedItem(Item item) {
        selectedItemTrader = item;

        MainController.setSelectedItemTrader(selectedItemTrader);

        setButtonState();
    }

    private void setButtonState() {
        boolean isTraderItemNull = selectedItemTrader == null;
        boolean isPlayerItemNull = selectedItemPlayer == null;
        boolean areBothNull = isTraderItemNull && isPlayerItemNull;

        buttonArea.setDisable(areBothNull);
        buyButton.setDisable(isTraderItemNull);
        sellButton.setDisable(isPlayerItemNull);
    }
}
