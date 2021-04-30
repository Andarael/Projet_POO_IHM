package shadowLair.view.ui;

import javafx.css.Styleable;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import shadowLair.controller.MainController;
import shadowLair.model.entity.Container;
import shadowLair.model.entity.Player;
import shadowLair.model.entity.place.Place;
import shadowLair.view.RessourceManager;

import java.net.URL;
import java.util.List;
import java.util.function.BiConsumer;

import static shadowLair.view.RessourceManager.getRessourceString;

/**
 * A canevas is responsible for displaying the background image corresponding to the place
 * as well as the NPCs and chests in that place.
 * It is also responsible to notify the MainController if a container is selected
 */
public class CanevasController extends AbstractController {

    /*======= FXML Nodes ========*/

    @FXML public ImageView backGroundImage;
    @FXML public VBox canevasContainer;
    @FXML public ImageView playerImage;
    @FXML public ImageView canevasImage3;
    @FXML public ImageView canevasImage2;
    @FXML public ImageView canevasImage1;

    /*======= FXML Actions ========*/

    /*The highlighting part is done by searching the mouseEvent target
     * There is no code to force a container to be highlighted */

    @FXML
    public void selectImagePlayer(MouseEvent mouseEvent) {
        MainController.selectContainerByIndex(0);
        unHighlightAll();
    }

    @FXML
    public void selectImage1(MouseEvent mouseEvent) {
        MainController.selectContainerByIndex(3);
        highlightSelected(mouseEvent);
    }

    @FXML
    public void selectImage2(MouseEvent mouseEvent) {
        MainController.selectContainerByIndex(2);
        highlightSelected(mouseEvent);
    }

    @FXML
    public void selectImage3(MouseEvent mouseEvent) {
        MainController.selectContainerByIndex(1);
        highlightSelected(mouseEvent);
    }

    /*======= inner variables ========*/

    private Place currentPlace = null;
    private Container selectedContainer = null;

    /*======= AbstractController overrides ========*/

    @Override
    public void initThis() {
        initImages();
        initCanevas();
        updateThis();
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return null;
    }

    @Override
    public void updateThis() {
        updateCanevas();
        updateContainersInCanevas();
    }

    /*======= Initializations ========*/

    private void initImages() {
        playerImage.setImage(null);
        canevasImage3.setImage(null);
        canevasImage2.setImage(null);
        canevasImage1.setImage(null);
    }

    private void initCanevas() {
        canevasContainer.toBack();
        backGroundImage.toBack();
        backGroundImage.setImage(null);
    }

    /*======= privates methods ========*/

    private void highlight(Styleable styleable) {
        styleable.getStyleClass().add("highlighted");
    }

    private void highlightSelected(MouseEvent mouseEvent) {
        unHighlightAll();

        highlight((Styleable) mouseEvent.getTarget());
    }


    private void unHighlight(Styleable styleable) {
        styleable.getStyleClass().remove("highlighted");
    }

    /*======= updates form higher controllers ========*/

    private void updateCanevas() {
        backGroundImage.setImage(null);

        String placeName;
        if (currentPlace != null)
            placeName = currentPlace.getShortName();
        else
            placeName = "";

        URL resource = RessourceManager.getRessource(placeName, ".png");

        backGroundImage.setImage(new Image(resource.toString()));
    }

    private void updateContainersInCanevas() {
        canevasImage1.setImage(null);
        canevasImage2.setImage(null);
        canevasImage3.setImage(null);

        if (currentPlace == null)
            return;

        setContainerImages(currentPlace.getListContainers());
    }

    private void unHighlightAll() {
        unHighlight(playerImage);
        unHighlight(canevasImage1);
        unHighlight(canevasImage2);
        unHighlight(canevasImage3);
    }

    private void setContainerImages(List<Container> containers) {
        performActionOnImages(containers, this::setImageFromContainer);
    }

    private void setImageFromContainer(ImageView imageView, Container container) {
        imageView.setImage(createImageFromContainer(container));
    }

    private Image createImageFromContainer(Container container) {
        if (container == null)
            return null;

        String ressourceName = container.getShortName();
        String url = getRessourceString(ressourceName + "_body", ".png");
        return new Image(url);
    }

    private void performActionOnImages(List<Container> containers,
                                       BiConsumer<ImageView, Container> consumer) {
        if (containers == null)
            return;

        if (containers.size() >= 1)
            consumer.accept(canevasImage1, containers.get(0));

        if (containers.size() >= 2)
            consumer.accept(canevasImage2, containers.get(1));

        if (containers.size() == 3)
            consumer.accept(canevasImage3, containers.get(2));
    }

    public void updateCurrentPlace(Place currentPlace) {
        this.currentPlace = currentPlace;
        this.selectedContainer = null;
        updateThis();
    }

    public void updateSelectedContainer(Container container) {
        // I do not take into account the cases where the wanted selected container is not null
        // For the moment this method is only called with a null container (in the 'Look Place' button)

        if (selectedContainer != container) {
            selectedContainer = container;
            unHighlightAll();
        }
        updateThis();
    }

    public void updatePlayer(Player player) {
        String ressourceName = player.getShortName();

        if (player.isDead())
            ressourceName += "_dead_body";
        else
            ressourceName += "_body";

        // might not be efficient to update the player img everyTime
        // but if we want to add different states or poses, a bit of the cod is already here
        playerImage.setImage(new Image(getRessourceString(ressourceName, ".png")));

    }
}
