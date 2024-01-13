public class Vec2 {

    public double x;
    public double y;

    // Overloaded Constructors
    public Vec2() {
    }

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(Vec2 v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void set(double x, double y ) {
        this.x = x;
        this.y = y;
    }

    // "Overload" Math Operators for vector addition/subtraction/multiplication/division
    public Vec2 add(Vec2 v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }
    public Vec2 sub(Vec2 v) {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }
    public Vec2 mult(Vec2 v) {
        this.x *= v.x;
        this.y *= v.y;
        return this;
    }
    public Vec2 div(Vec2 v) {
        this.x /= v.x;
        this.y /= v.y;
        return this;
    }

    public Vec2 scale(double s) {
        scale(s, s);
        return this;
    }
    
    public void scale(double sx, double sy) {
        this.x *= sx;
        this.y *= sy;
    }

}
