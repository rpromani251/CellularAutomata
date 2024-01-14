package Elements;

import util.Vec2;

public class EmptyCell extends Element {

    Vec2 position;

    public EmptyCell(int x, int y) {
        super(x, y);
        isFreeFalling = false;
    }   
}
