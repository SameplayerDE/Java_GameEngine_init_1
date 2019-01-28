package io.github.SameplayerDE.GameEngine.Utils;

public class Location extends Vector2 {

    public Location(int x, int y) {
        super(x, y);
    }

    public Vector2 toVector2() {
        return new Vector2(X, Y);
    }
}
