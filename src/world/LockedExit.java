package world;

public class LockedExit extends Exit {
    private boolean isLocked;
    private Place origine;

    public LockedExit(Place dest, Place ori) {
        super(dest);
        this.origine = ori;
        this.isLocked = true;
    }

    //@Override
    public Place goIn(){
        if (this.isLocked){
            System.out.println("this exit is locked, you need the key.");
            return this.origine;
        }else{
            return this.destination;
        }
    }


}
