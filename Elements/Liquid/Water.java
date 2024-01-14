package Elements.Liquid;

import java.awt.*;

public class Water extends Liquid {

    public Water(int x, int y) {
        super(x, y);
        isFreeFalling = true;
    }

    @Override
    public void draw(Graphics g) {
        // System.out.println("Stone draw method called");
        g.setColor(Color.blue);
        g.fillRect((int) position.x, (int) position.y, 1, 1);
        // System.out.println("Stone placed at " + position);
    }
    
}
