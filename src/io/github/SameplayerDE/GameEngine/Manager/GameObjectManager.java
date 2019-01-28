package io.github.SameplayerDE.GameEngine.Manager;

import io.github.SameplayerDE.GameEngine.Game;
import io.github.SameplayerDE.GameEngine.Objects.DrawableGameObject;
import io.github.SameplayerDE.GameEngine.Objects.GameObject;
import io.github.SameplayerDE.GameEngine.Objects.Player;
import io.github.SameplayerDE.GameEngine.Render.Renderer;

import java.util.ArrayList;

public class GameObjectManager {

    private Game game;

    private ArrayList<GameObject> gameObjects;

    public GameObjectManager(Game game) {
        gameObjects = new ArrayList<>();
        this.game = game;
        add(new Player());
    }

    public void add(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void render(Renderer renderer) {
        for (GameObject object : gameObjects) {
            Class superClass = object.getClass().getSuperclass();
            if (superClass.equals(DrawableGameObject.class)) {
                DrawableGameObject drawableGameObject = (DrawableGameObject) object;
                drawableGameObject.draw(game, renderer);
            }
        }
    }

    public void update(float delta) {

    }

}
