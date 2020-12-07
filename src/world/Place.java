package world;

import java.util.Map;
import java.util.Set;
import inventory.*;
import entity.Entity;


public class Place {
    private int size;
    private Inventory loot;
    private Map<String, Exit> exits;
    private String name;
    private Entity enti;

    public void display() {
        String t = new String();

        if(this.size<10){
            t = "petite";
        }
        if(this.size>=10 && this.size<20){
            t = "moyenne";
        }
        if(this.size>=20){
            t = "grande";
        }
        Main.cleanScreen();
        System.out.println("Vous etes dans une "+t+" salle.");
        if(!this.loot.isEmpty()) {
            System.out.println("Par terre vous voyez : ");
            this.loot.getInvDisplayDetails();
        }
        System.out.println("D�placement possible :");
        Set<String> e = this.exits.keySet();
        for(String s : e) {
            System.out.println(this.exits.get(s).GoIn().getName()+" : "+s);
        }

    }

    public String getName(){return this.name;}

    public boolean hasEntity() {
        if(this.enti != null)
            return true;
        return false;
    }

    public Entity getEntity() {
        return this.enti;
    }
}
