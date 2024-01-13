public class Mouse {
    // Create Class Attributes:
    private Vec2 pos, prevPos;
    private double cursorSize;
    private final double minCursorSize, maxCursorSize;
    private boolean leftButtonDown, rightButtonDown;

    // Empty Constructor to set Default Values:
    public Mouse() {
        minCursorSize = 20;
        maxCursorSize = 100;
        cursorSize = minCursorSize;

        pos = prevPos = new Vec2();

        leftButtonDown = rightButtonDown = false;
    }
    public void UpdatePosition(int x, int y) {
        prevPos.x = pos.x;
        prevPos.y = pos.y;
        pos.x = x;
        pos.y = y;
    }

    public boolean GetLeftButtonDown() {
        return this.leftButtonDown;
    }

    public boolean GetRightButtonDown() {
        return this.rightButtonDown;
    }

    public void SetLeftMouseButton(boolean b) {
        this.leftButtonDown = b;
    }

    public void SetRightMouseButton(boolean b) {
        this.rightButtonDown = b;
    }

    public void IncreaseCursorSize(int i) {
        if (cursorSize + i > maxCursorSize || cursorSize + i < minCursorSize) {
            cursorSize += i;
        }
    }
    public Vec2 GetPosition() {
        return this.pos;
    }

    public double GetCursorSize() {
        return this.cursorSize;
    }

    public Vec2 GetPreviousPosition() {
        return this.prevPos;
    }
}
 {
    
}
