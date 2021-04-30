package view.ui;

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
import model.utils.StringUtils;

import java.util.List;

import static view.RessourceManager.getRessourceString;

/**
 * A characterBar is responsible of displaying stats about a being
 * Some additional stats (like equipped and weight) are displayed for the player
 * The characterBar does not notify other controllers.
 */
public class CharacterBarController extends AbstractController {

    /*======= FXML Nodes ========*/

    @FXML public ImageView profileImage;
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

    /*======= inner variables ========*/

    private Being currentBeing = null;

    /*======= AbstractController overrides ========*/

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

    public void updateBeing(Being currentBeing) {
        this.currentBeing = currentBeing;
        updateThis();
    }

    /*======= updates form higher controllers ========*/

    private void updateCharacterBox() {
        if (currentBeing == null)
            characterBar.setOpacity(0);
        else
            characterBar.setOpacity(1);
    }

    private void updateProfilePicture() {
        if (currentBeing == null) {
            profileImage.setImage(null);
            return;
        }

        String url = getRessourceString(currentBeing.getShortName() + "_head", ".png");

        Image image = new Image(url);
        profileImage.setImage(image);
    }

    private void updateCharacterName() {
        if (currentBeing == null) {
            characterNameLabel.setText(null);
            return;
        }

        String name = StringUtils.capitalize(StringUtils.readable(currentBeing.getName()));
        characterNameLabel.setText(name + "\n(lvl " + currentBeing.getLevel() + ")");
    }

    private void updateGold() {
        if (currentBeing == null) {
            goldLabel.setText(null);
            goldQuantityLabel.setText(null);
            return;
        }

        int gold = currentBeing.getInventory().getGold();
        goldLabel.setText(StringUtils.pluralize("Gold", gold) + " :");
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
            equippedText += StringUtils.capitalize(equippedItemName) + "\n";
        } else {
            equippedLabel.setText("Attack :");
        }

        int power;

        if (currentBeing instanceof Player && ((Player) currentBeing).getEquipped() instanceof Bow)
            power = ((Bow) ((Player) currentBeing).getEquipped()).getPowerNoConsume();
        else
            power = currentBeing.getPower();

        equippedText += power + " " + StringUtils.pluralize("damage", power);

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
