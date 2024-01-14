package Elements;

import java.awt.Graphics;

import util.Vec2;

public abstract class Element {
    protected Vec2 position;

    public Element(int x, int y) {
        position = new Vec2(x, y);
        // System.out.println("Element position set to: "+ position);

    }

    public void draw(Graphics g) {
        return;
    }
}
