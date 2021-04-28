package controller;

import javafx.fxml.FXML;

import java.util.List;

public abstract class AbstractController {

    private AbstractController parentController;

    @FXML
    private void initialize() {
        initAll();
    }

    public abstract void initAll();

    public abstract void updateAll();

    protected void updateAllChildren() {
        List<AbstractController> controllers = getChildrenControllers();

        if (controllers != null)
            for (AbstractController controller : controllers)
                controller.updateAll();

    }

    public AbstractController getParentController() {
        return parentController;
    }

    public void setParentController(AbstractController parentController) {
        this.parentController = parentController;
    }

    public abstract List<AbstractController> getChildrenControllers();

    public AbstractController getRootController() {
        AbstractController actualController = getParentController();

        if (actualController == null)
            return this;

        AbstractController parentController = actualController.getParentController();
        while (parentController != null) {
            actualController = parentController;
            parentController = actualController.getParentController();
        }

        return actualController;
    }
}
