package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entity.Being;
import model.entity.Player;
import model.entity.item.Bow;

import java.util.List;

import static controller.RessourceManager.getRessourceString;
import static controller.utils.Utils.*;

public class CharacterBarController extends AbstractController {

    //    todo meilleurs noms pour les fields
    @FXML public ImageView profilePicture;
    @FXML public Label characterNameLabel;
    @FXML public Label goldLabel;
    @FXML public ProgressBar lifeBar;
    @FXML public Label equippedItem;
    @FXML public Label hpLabel;
    @FXML public Label podsLabel;
    @FXML public VBox capacityVbox;
    @FXML public Label goldQuantityLabel;
    @FXML public HBox CharacterBox;
    @FXML public Label equippedLabel;
    @FXML public HBox characterBar;

    private Being currentBeing = null;

    // todo update quand : use, go, attack,


    @Override
    public void initThis() {
        updateThis();
    }

    @Override
    public void updateThis() {
        updateProfilePicture();
        updateCharacterName();
        updateGold();
        updateLifeBar();
        updateHP();
        updateEquipped();
        updatePods();
        updateCharacterBox();
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return null;
    }

    public void setCurrentBeing(Being currentBeing) {
        this.currentBeing = currentBeing;
        updateThis();
    }

    private void updateCharacterBox() {
        if (currentBeing == null)
            characterBar.setOpacity(0);
        else
            characterBar.setOpacity(1);
    }

    private void updateProfilePicture() {
        if (currentBeing == null) {
            profilePicture.setImage(null);
            return;
        }

        String url = getRessourceString(currentBeing.getShortName() + "_head", ".png", this);

        Image image = new Image(url);
        profilePicture.setImage(image);
    }

    private void updateCharacterName() {
        if (currentBeing == null) {
            characterNameLabel.setText(null);
            return;
        }

        String name = readable(currentBeing.getName());
        characterNameLabel.setText(capitalize(name));
    }

    private void updateGold() {
        if (currentBeing == null) {
            goldLabel.setText(null);
            goldQuantityLabel.setText(null);
            return;
        }

        int gold = currentBeing.getInventory().getGold();
        goldLabel.setText(pluralize("Gold", gold) + " :");
        goldQuantityLabel.setText(String.valueOf(gold));
    }

    private void updateHP() {
        if (currentBeing == null) {
            hpLabel.setText(null);
            return;
        }

        String text = currentBeing.getHp() + " / " + currentBeing.getMaxHp() + " hp";
        hpLabel.setText(text);
    }

    private void updateLifeBar() {
        if (currentBeing == null) {
            lifeBar.setProgress(0);
            return;
        }

        double hp = currentBeing.getHp();
        double maxHp = currentBeing.getMaxHp();
        lifeBar.setProgress(hp / maxHp);
    }

    private void updateEquipped() {
        if (currentBeing == null) {
            equippedLabel.setText(null);
            equippedItem.setText(null);
            return;
        }

        String equippedText = "";
        if ((currentBeing instanceof Player)) {
            equippedLabel.setText("Equipped :");
            String equippedItemName = ((Player) currentBeing).getEquipped().getName();
            equippedText += capitalize(equippedItemName) + "\n";
        } else {
            equippedLabel.setText("Attack :");
        }

        int power;

        if (currentBeing instanceof Player && ((Player) currentBeing).getEquipped() instanceof Bow)
            power = ((Bow) ((Player) currentBeing).getEquipped()).getPowerNoConsume();
        else
            power = currentBeing.getPower();

        equippedText += power + " " + pluralize("damage", power);

        equippedItem.setText(equippedText);
    }

    private void updatePods() {
        if (currentBeing == null) {
            capacityVbox.setOpacity(0);
            return;
        }

        if (currentBeing instanceof Player) {
            capacityVbox.setOpacity(1);
            Player player = (Player) currentBeing;
            double capacity = player.getCapacity();
            double usedCapacity = player.getUsedCapacity();
            podsLabel.setText(usedCapacity + " kg /\n" + capacity + " kg");
        } else {
            podsLabel.setText("");
            capacityVbox.setOpacity(0);
        }
    }
}
