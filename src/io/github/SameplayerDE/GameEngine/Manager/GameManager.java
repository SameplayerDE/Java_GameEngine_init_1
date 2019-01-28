package io.github.SameplayerDE.GameEngine.Manager;

import io.github.SameplayerDE.GameEngine.AbstractGame;
import io.github.SameplayerDE.GameEngine.Game;
import io.github.SameplayerDE.GameEngine.Render.Renderer;
import io.github.SameplayerDE.GameEngine.Render.Sprite;
import io.github.SameplayerDE.GameEngine.Render.Texture;

public class GameManager extends AbstractGame {

    private Sprite sprite;

    public GameManager() {
        sprite = new Sprite(new Texture("/ghast_tear.png"));
    }

    @Override
    public void update(Game game, float delta) {

    }

    @Override
    public void render(Game game, Renderer renderer) {
        //renderer.drawSprite(sprite, game.getInputerHandler().getMouseX(), game.getInputerHandler().getMouseY());
    }

    public static void main(String[] args) {
        Game game = new Game(new GameManager());
        game.start();
    }

}
