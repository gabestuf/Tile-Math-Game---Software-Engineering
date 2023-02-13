package Game;

public class Tile {

    int value, posX, posY;
    boolean isVisible, isSelected;

    public Tile(int value_, int posX_, int posY_) {
        this.value = value_;
        this.posX = posX_;
        this.posY = posY_;
        this.isVisible = true;
        this.isSelected = false;
    }

    public Tile(int value_, boolean isVisible_){
        this.value = value_;
        this.isVisible = isVisible_;
    }

}
