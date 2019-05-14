package framework.data.accessories;

import framework.logic.AccessoryType;
import framework.logic.Action;

public abstract class Accessory implements Comparable<Accessory> {

    private int width;
    private int height;
    private int posX;
    private int posY;
    private Action action;
    private int layer;
    private String pathToImage;

    public Accessory(int width, int height, int posX, int posY, int layer, String pathToImage) {
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
        this.layer = layer;
        this.pathToImage = pathToImage;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String newPath){
        this.pathToImage = newPath;
    }

    public int getLayer() {
        return layer;
    }

    /**
     * Compare based on layer; high to low
     * @param other other Accessory to be compared to
     * @return int to indicate relation between the objects
     */

    public int compareTo(Accessory other) {
        return this.layer - other.layer;
    }

    public abstract AccessoryType getAccessoryType();

    public void setAction(Action action) {
        this.action = action;
    }

    public void doAction() {
        this.action.action(this);
    }
}