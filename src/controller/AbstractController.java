package controller;

import javafx.fxml.FXML;

import java.util.List;

public abstract class AbstractController {

    private AbstractController parentController;

    @FXML
    protected final void initialize() {
        initThis();
        setThisAsParentController();
    }

    public abstract void initThis();

    public final void updateAll(AbstractController caller) {
        updateThis();
        updateAllChildrenExceptCaller(caller);
        updateAllInParent();
    }

    private void updateAllInParent() {
        AbstractController parentController = getParentController();
        if (parentController != null)
            parentController.updateAll(this);
    }

    private void updateAllChildrenExceptCaller(AbstractController caller) {
        List<AbstractController> childrenControllers = getChildrenControllers();
        if (childrenControllers == null)
            return;

        childrenControllers.stream()
                           .filter(childrenController -> childrenController != null &&
                                                              childrenController != caller)
                           .forEach(childrenController -> childrenController.updateAll(this));
    }

    public abstract void updateThis();

    protected void updateAllChildren() {
        List<AbstractController> controllers = getChildrenControllers();

        if (controllers != null)
            for (AbstractController controller : controllers) {
                controller.updateAllChildren(); // todo check
                controller.updateThis();
            }

    }

    public AbstractController getParentController() {
        return parentController;
    }

    public void setParentController(AbstractController parentController) {
        this.parentController = parentController;
    }

    public final void setThisAsParentController() {
        List<AbstractController> controllers = getChildrenControllers();

        if (controllers == null)
            return;

        for (AbstractController childController : controllers) {
            if (childController == null)
                continue;

            childController.setParentController(this);
        }
    }

    public List<AbstractController> getChildrenControllers() {
        return null;
    }

    public MainUIController getRootController() {
        AbstractController actualController = getParentController();

        if (this instanceof MainUIController)
            return (MainUIController) this;

        else if (actualController == null)
            return null;

        else
            return actualController.getRootController();
    }
}
