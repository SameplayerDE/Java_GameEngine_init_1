package io.github.SameplayerDE.GameEngine.Objects;

import io.github.SameplayerDE.GameEngine.Game;
import io.github.SameplayerDE.GameEngine.GameConstant;
import io.github.SameplayerDE.GameEngine.Render.Renderer;
import io.github.SameplayerDE.GameEngine.Render.Sprite;
import io.github.SameplayerDE.GameEngine.Render.Texture;

public class Player extends DrawableGameObject {

    private int speed = 5;

    public Player() {
        setSprite(new Sprite(new Texture("/ghast_tear.png")));
    }

    @Override
    public void logic(Game game, float delta) {
        if (game.getInputerHandler().TOP) {
            teleport(getLocation().getX(), getLocation().getY() - speed);
        }
        if (game.getInputerHandler().BOTTOM) {
            teleport(getLocation().getX(), getLocation().getY() + speed);
        }
        if (game.getInputerHandler().LEFT) {
            teleport(getLocation().getX() - speed, getLocation().getY());
        }
        if (game.getInputerHandler().RIGHT) {
            teleport(getLocation().getX() + speed, getLocation().getY());
        }
        if (getLocation().getX() < 0) {
            teleport(0, getLocation().getY());
        }
        if (getLocation().getX() + getSprite().getTexture().width > GameConstant.WIDTH) {
            teleport(GameConstant.WIDTH - getSprite().getTexture().width, getLocation().getY());
        }
        if (getLocation().getY() < 0) {
            teleport(getLocation().getX(), 0);
        }
        if (getLocation().getY() + getSprite().getTexture().height > GameConstant.HEIGHT) {
            teleport(getLocation().getX(), GameConstant.HEIGHT - getSprite().getTexture().height);
        }
    }

    @Override
    public void draw(Game game, Renderer renderer) {
        renderer.drawSprite(getSprite(), getLocation().getX(), getLocation().getY());
    }
}
