package Elements.Solid.Immovable;

import java.awt.Color;
import java.awt.Graphics;

public class Stone extends ImmovableSolid {
    public Stone() {
        
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, 5, 5);
    }
}
