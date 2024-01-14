package Elements;

import java.awt.Graphics;

import Elements.Solid.Immovable.ImmovableSolid;
import util.Vec2;

public abstract class Element {
    protected Vec2 position;
    public boolean isFreeFalling;

    public Element(int x, int y) {
        position = new Vec2(x, y);
        isFreeFalling = true;
        // System.out.println("Element position set to: "+ position);

    }

    public void draw(Graphics g) {
        return;
    }

    public int getX() {
        return (int) position.x;
    }

    public int getY() {
        return (int) position.y;
    }

    public Vec2 GetPosition() {
        return position;
    }

    public ImmovableSolid getBelowCell(Element cell) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBelowCell'");
    }
}
