package io.github.SameplayerDE.GameEngine.Objects;

import io.github.SameplayerDE.GameEngine.Game;
import io.github.SameplayerDE.GameEngine.Render.Renderer;
import io.github.SameplayerDE.GameEngine.Render.Sprite;
import io.github.SameplayerDE.GameEngine.Utils.Location;

public abstract class DrawableGameObject extends GameObject {

    private Sprite sprite;
    private Location location = new Location(0, 0);

    public abstract void logic(Game game, float delta);
    public abstract void draw(Game game, Renderer renderer);

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void teleport(int x, int y) {
        location.setX(x);
        location.setY(y);
    }
}
