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
import model.world.StaticWorld;
import model.world.World;

import static controller.RessourceManager.getRessourceString;
import static controller.utils.Utils.*;

public class CharacterBarController {


    @FXML
    public ImageView profilePicture;
    @FXML
    public Label characterNameLabel;
    @FXML
    public Label goldLabel;
    @FXML
    public ProgressBar lifeBar;
    @FXML
    public Label equippedItem;
    @FXML
    public Label hpLabel;
    @FXML
    public Label podsLabel;
    @FXML
    public VBox capacityVbox;
    @FXML
    public Label goldQuantityLabel;
    @FXML
    public HBox CharacterBox;
    @FXML
    public Label equippedLabel;

    World world = StaticWorld.world;

//    public Being currentBeing = (Being) getEntity(world, "scand");
    public Being currentBeing = world.getPlayer();


    @FXML
    public void initialize() {
        updateAll();
    }

    private void updateAll() {
        if (currentBeing == null)
            return;

        updateProfilePicture();
        updateCharacterName();
        updateGold();
        updateLifeBar();
        updateHP();
        updateEquipped();
        updatePods();
    }

    private void updateProfilePicture() {
        System.out.println(currentBeing.getName());
        String url = getRessourceString(currentBeing.getName(), ".png", this);
        Image image = new Image(url);
        profilePicture.setImage(image);
    }

    private void updateCharacterName() {
        String name = readable(currentBeing.getName());
        characterNameLabel.setText(capitalize(name));
    }

    private void updateGold() {
        int gold = currentBeing.getInventory().getGold();
        goldLabel.setText(pluralize("Gold", gold) + " :");
        goldQuantityLabel.setText(String.valueOf(gold));
    }

    private void updateHP() {
        String text = currentBeing.getMaxHp() + " / " + currentBeing.getHp() + " hp";
        hpLabel.setText(text);
    }

    private void updateLifeBar() {
        double hp = currentBeing.getHp();
        double maxHp = currentBeing.getMaxHp();
        lifeBar.setProgress(hp / maxHp);
    }

    private void updateEquipped() {
        String equippedText = "";
        if ((currentBeing instanceof Player)) {
            equippedLabel.setText("Equipped :");
            String equippedItemName = ((Player) currentBeing).getEquipped().getName();
            equippedText += capitalize(equippedItemName) + "\n";
        } else {
            equippedLabel.setText("Attack :");
        }

        int power = currentBeing.getPower();
        equippedText += power + " " + pluralize("damage", power);

        equippedItem.setText(equippedText);
    }

    private void updatePods() {
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
