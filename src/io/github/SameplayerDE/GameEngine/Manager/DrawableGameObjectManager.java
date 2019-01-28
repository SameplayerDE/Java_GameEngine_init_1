package io.github.SameplayerDE.GameEngine.Manager;

import io.github.SameplayerDE.GameEngine.Game;
import io.github.SameplayerDE.GameEngine.Objects.DrawableGameObject;
import io.github.SameplayerDE.GameEngine.Objects.Player;
import io.github.SameplayerDE.GameEngine.Render.Renderer;

public class DrawableGameObjectManager extends ObjectManager<DrawableGameObject> {

    public DrawableGameObjectManager(Game game) {
        super(game);
        add(new Player());
    }

    @Override
    public void render(Renderer renderer) {
        for (DrawableGameObject gameObject : objects) {
            gameObject.draw(game, renderer);
        }
    }

    @Override
    public void update(float delta) {
        for (DrawableGameObject gameObject : objects) {
            gameObject.logic(game, delta);
        }
    }

}
