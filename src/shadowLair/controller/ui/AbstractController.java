package shadowLair.controller.ui;

import javafx.fxml.FXML;

import java.util.List;

/**
 * An AbstractController aims to streamline the initialization and communication of nested fxml controllers
 * It provides methods to update all child controllers at once.
 * And allows lower controller to easily talk to their parents in the tree
 * <p>
 * Those features are barely used in this project.
 */
public abstract class AbstractController {

    private AbstractController parentController;

    /**
     * is called at the creation of the FXMLController
     * So we set the parent here
     */
    @FXML
    protected final void initialize() {
        initThis();
        setThisAsParentController();
    }

    /**
     * for the children to implement their own initialization
     */
    public abstract void initThis();

    /**
     * for the children to implement their own updates
     */
    public abstract void updateThis();

    /**
     * update all the AbstractController children of this
     */
    protected void updateAllChildren() {
        List<AbstractController> controllers = getChildrenControllers();

        if (controllers != null)
            controllers.forEach(controller -> {
                controller.updateAllChildren();
                controller.updateThis();
            });
    }

    public AbstractController getParentController() {
        return parentController;
    }

    public void setParentController(AbstractController parentController) {
        this.parentController = parentController;
    }

    /**
     * register this as a parent for all its children
     */
    public final void setThisAsParentController() {
        List<AbstractController> controllers = getChildrenControllers();

        if (controllers == null) // if this is a leaf in the tree
            return;

        for (AbstractController childController : controllers) {
            if (childController == null)
                continue;

            childController.setParentController(this);
        }
    }

    /**
     * for children to implement
     */
    public List<AbstractController> getChildrenControllers() {
        return null;
    }

    /**
     * recursively searches for the highest controller in the tree
     * It might be useful to update the interface at once form a deeply nested controller
     */
    public GameUIController getRootController() {
        AbstractController actualController = getParentController();

        if (this instanceof GameUIController)
            return (GameUIController) this;

        else if (actualController == null)
            return null;

        else
            return actualController.getRootController();
    }
}
