package Elements.Solid.Immovable;

import java.awt.Color;
import java.awt.Graphics;

import util.Vec2;

public class Stone extends ImmovableSolid {
    public Stone(int x, int y) {
        super(x, y);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void draw(Graphics g) {
        // System.out.println("Stone draw method called");
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect((int) position.x, (int) position.y, 1, 1);
        System.out.println("Stone placed at " + position);
    }
}
