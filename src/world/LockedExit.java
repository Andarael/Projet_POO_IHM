package world;

public class LockedExit extends Exit {
    private boolean isLocked;
    private final Place origine;

    public LockedExit(Place destination, Place origine) {
        super(destination);
        this.origine = origine;
        this.isLocked = true;
    }

    public boolean canGo(){
        return !this.isLocked;
    }

    @Override
    public Place goIn(){
        if (!this.canGo()){
            return this.origine;
        }else {
            return this.destination;
        }
    }

    public boolean getIsLocked() {
        return this.isLocked;
    }

    public void unLock() {
        this.isLocked = false;
    }

    public void lock(){
        this.isLocked = true;
    }

    public Place getOrigine() {
        return origine;
    }

}
