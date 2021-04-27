package controller;

import javafx.css.Styleable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.entity.Container;
import model.entity.item.Key;
import model.entity.place.Exit;
import model.entity.place.LockedExit;
import model.utils.Col;
import model.world.StaticWorld;
import model.world.World;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static controller.RessourceManager.getRessourceString;
import static controller.utils.Utils.readable;

public class DirectionController {

    private final World world = StaticWorld.world;

    public String selected = null;

    @FXML
    public Button buttonTop;
    @FXML
    public Button buttonBottom;
    @FXML
    public Button buttonLeft;
    @FXML
    public Button buttonRight;
    @FXML
    public ImageView canevas;
    @FXML
    public VBox canevasContainer;
    @FXML
    public ImageView playerCanevas;
    @FXML
    public ImageView ContainerCanevas1;
    @FXML
    public ImageView ContainerCanevas2;
    @FXML
    public ImageView ContainerCanevas3;


    private String getContainerNameByIndex(int i) {
        List<Container> listContainers = world.currentPlace.getListContainers();
        int size = listContainers.size();
        System.out.println("size : " + size);
        if (i < size) {
            return listContainers.get(i).getName();
        }

        return null;
    }

    @FXML
    private void initialize() {
        initImages();
        initCanevas();

        updateAll();
    }

    private void initImages() {
        playerCanevas.setImage(new Image(getRessourceString("player", ".png", this)));
        ContainerCanevas1.setImage(null);
        ContainerCanevas2.setImage(null);
        ContainerCanevas3.setImage(null);
    }

    private void initCanevas() {
        canevasContainer.toBack();

        canevas.toBack();

        canevas.setImage(null);
    }

    private void updateAll() {
        updateSelected();
        updateAllButtons();
        updateCanevas();
        updateContainersInCanevas();
    }

    private void updateSelected() {
        unSelectAll();
        unHighlightAll();
    }

    private void unSelectAll() {
        selected = null;
    }

    private void select(int i) {
        unSelectAll();

        System.out.println("i = " + i);

        switch (i) {
            case 0:
                selected = world.getPlayer().getName();
                break;
            case 1:
                selected = getContainerNameByIndex(0);
                break;
            case 2:
                selected = getContainerNameByIndex(1);
                break;
            case 3:
                selected = getContainerNameByIndex(2);
                break;
            default:
                selected = null;
                break;
        }

        System.out.println("selected : " + selected);

    }

    private void unHighlightAll() {
        unHighlight(playerCanevas);
        unHighlight(ContainerCanevas1);
        unHighlight(ContainerCanevas2);
        unHighlight(ContainerCanevas3);
    }

    private void updateCanevas() {
        canevas.setImage(null);

        String placeName = world.currentPlace.getName().toLowerCase();
        URL resource = RessourceManager.getRessource(placeName, ".png", this);

        canevas.setImage(new Image(resource.toString()));

    }

    private void updateContainersInCanevas() {

        ContainerCanevas1.setImage(null);
        ContainerCanevas2.setImage(null);
        ContainerCanevas3.setImage(null);

        List<Container> containers = world.currentPlace.getListContainers();

        System.out.println(containers);
        System.out.println(containers.size());


        Container container;
        setContainerImages(containers);
    }

    private void setContainerImages(List<Container> containers) {
        Image img;

        if (containers.size() >= 1) {
            img = createImageFromContainer(containers.get(0));
            ContainerCanevas3.setImage(img);
        }

        if (containers.size() >= 2) {
            img = createImageFromContainer(containers.get(1));
            ContainerCanevas2.setImage(img);
        }
        if (containers.size() == 3) {
            img = createImageFromContainer(containers.get(2));
            ContainerCanevas1.setImage(img);
        }
    }

    private Image createImageFromContainer(Container container) {
        if (container == null)
            return null;

        String ressourceName = container.getShortName().trim();
        String url = getRessourceString(ressourceName, ".png", this);
        return new Image(url);
    }

    private void updateAllButtons() {
        updateButton(buttonTop, 0);
        updateButton(buttonLeft, 1);
        updateButton(buttonRight, 2);
        updateButton(buttonBottom, 3);
    }

    private void updateButton(Button button, int index) {
        resetButtonColor(button);
        button.setDisable(true);

        if (world.currentPlace.exitExistIndex(index)) {
            Exit exit = world.currentPlace.getExitByIndex(index);
            button.setDisable(false);
            button.setText(readable(exit.getName()));
            setButtonColorFromExit(button, exit);
        } else {
            button.setText("      ");
        }

        if (index == 1 || index == 2) {
            setVerticalText(button);
        }
    }

    /**
     * We must set the text to vertical, button rotation is not good
     * because then TrueType font antialiasing does not apply properly (windows)
     */
    private void setVerticalText(Button button) {
        String originalText = button.getText();
        String newText = "";

        for (char c : originalText.toCharArray())
            newText += c + "\n";

        button.setLineSpacing(-5); // i can't put negative value in css
        button.setText(newText);
    }

    private void setButtonColorFromExit(Button button, Exit exit) {
        if (exit instanceof LockedExit) {
            disableButtonIfNoKey(button, (LockedExit) exit);
            setButtonToExitColor(button, exit);
        }
    }

    private void disableButtonIfNoKey(Button button, LockedExit exit) {
        String keyName = Key.generateKeyName(exit.getColor());
        button.setDisable(!world.getPlayer().contains(keyName));
    }

    private void setButtonToExitColor(Button button, Exit exit) {
        if (exit.getDestination() == null)
            button.setDisable(true);

        String colorName = ((LockedExit) exit).getColor().getColorName();
        button.getStyleClass().add(colorName);
    }

    private void resetButtonColor(Button button) {
        for (Col col : Col.values()) {
            String colorName = col.getColorName();
            button.getStyleClass().remove(colorName);
        }
    }

    private List<String> getCommandByDirection(int index) {
        Exit exit = world.currentPlace.getExitByIndex(index);
        String destination = exit != null ? exit.getName() : "";
        return new ArrayList<>(Arrays.asList("go", destination));
    }

    private void executeByuDirection(int index) {
        model.command.Execute.execute(world, getCommandByDirection(index));
    }

    private void highlight(Styleable styleable) {
        styleable.getStyleClass().add("highlighted");
    }

    private void selectHighlighted(MouseEvent mouseEvent) {
        unHighlightAll();

        highlight((Styleable) mouseEvent.getTarget());
    }

    private void unHighlight(Styleable styleable) {
        styleable.getStyleClass().remove("highlighted");
    }

    @FXML
    public void goTop(ActionEvent actionEvent) {
        executeByuDirection(0);
        System.out.println("going top");
        updateAll();
    }

    @FXML
    public void goLeft(ActionEvent actionEvent) {
        executeByuDirection(1);
        updateAll();
        System.out.println("going Left");
    }

    @FXML
    public void goRight(ActionEvent actionEvent) {
        executeByuDirection(2);
        updateAll();
        System.out.println("going Right");
    }

    @FXML
    public void goBottom(ActionEvent actionEvent) {
        executeByuDirection(3);
        updateAll();
        System.out.println("going bottom");
    }

    @FXML
    public void selectImagePlayer(MouseEvent mouseEvent) {
        unSelectAll();
        unHighlightAll();
    }

    @FXML
    public void selectImage1(MouseEvent mouseEvent) {
        select(3);
        selectHighlighted(mouseEvent);
    }

    @FXML
    public void selectImage2(MouseEvent mouseEvent) {
        select(2);
        selectHighlighted(mouseEvent);
    }

    @FXML
    public void selectImage3(MouseEvent mouseEvent) {
        select(1);
        selectHighlighted(mouseEvent);
    }


}
