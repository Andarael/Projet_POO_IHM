package controller;

import javafx.css.Styleable;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.entity.Container;
import model.world.StaticWorld;
import model.world.World;

import java.net.URL;
import java.util.List;

import static controller.RessourceManager.getRessourceString;

public class CanevasController extends AbstractController {

    private final World world = StaticWorld.world;

    @FXML
    public ImageView backGroundImage;
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

    private Container selected = null;

    @Override
    public void initAll() {
        initImages();
        initCanevas();
        updateAll();
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return null;
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

    @Override
    public void updateAll() {
        updateAllChildren();
        updateSelected();
        updateCanevas();
        updateContainersInCanevas();
    }

    private void initImages() {
        playerCanevas.setImage(new Image(getRessourceString("player", ".png", this)));
        ContainerCanevas1.setImage(null);
        ContainerCanevas2.setImage(null);
        ContainerCanevas3.setImage(null);
    }

    private void initCanevas() {
        canevasContainer.toBack();

        backGroundImage.toBack();

        backGroundImage.setImage(null);
    }

    private void updateSelected() {
        unSelectAll();
        unHighlightAll();
    }

    private void unSelectAll() {
        selected = null;
    }

    private void unHighlightAll() {
        unHighlight(playerCanevas);
        unHighlight(ContainerCanevas1);
        unHighlight(ContainerCanevas2);
        unHighlight(ContainerCanevas3);
    }

    private void select(int i) {
        unSelectAll();

        switch (i) {
            case 0:
                selected = world.getPlayer();
                break;
            case 1:
            case 2:
            case 3:
                selected = world.currentPlace.getContainerByIndex(i - 1);
                break;
            default:
                selected = null;
                break;
        }
    }

    private void updateCanevas() {
        backGroundImage.setImage(null);

        String placeName = world.currentPlace.getName().toLowerCase();
        URL resource = RessourceManager.getRessource(placeName, ".png", this);

        backGroundImage.setImage(new Image(resource.toString()));

    }

    private void updateContainersInCanevas() {
        ContainerCanevas1.setImage(null);
        ContainerCanevas2.setImage(null);
        ContainerCanevas3.setImage(null);

        List<Container> containers = world.currentPlace.getListContainers();

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
}
