package io.github.SameplayerDE.GameEngine.Manager;

import io.github.SameplayerDE.GameEngine.Game;
import io.github.SameplayerDE.GameEngine.Objects.DrawableGameObject;
import io.github.SameplayerDE.GameEngine.Objects.GameObject;
import io.github.SameplayerDE.GameEngine.Render.Renderer;

import java.util.ArrayList;

public abstract class ObjectManager<T> {


    protected Game game;
    protected ArrayList<T> objects = new ArrayList<>();

    public ObjectManager(Game game) {
        this.game = game;
    }

    public void add(T object) {
        objects.add(object);
    }

    /**public void render(Renderer renderer) {
        for (T object : objects) {
            processObject(object, renderer);
        }
    }**/

    public abstract void render(Renderer renderer);
    public abstract void update(float delta);
    //abstract void processObject(T object, Renderer renderer);


    public ArrayList<T> getObjects() {
        return objects;
    }

    public Game getGame() {
        return game;
    }
}
