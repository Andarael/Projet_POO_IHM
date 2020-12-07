package entity;

import inventory.Inventory;

import java.util.List;

public class Container extends Entity{

    private Inventory inventory;

    public Container(String name, String description) {
        super(name, description);

        this.inventory = new Inventory();
    }

    public Container(String name) {
        this(name, null);
    }


}
