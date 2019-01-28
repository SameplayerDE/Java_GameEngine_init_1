package io.github.SameplayerDE.GameEngine;

import io.github.SameplayerDE.GameEngine.Render.Renderer;

public abstract class AbstractGame {

    public abstract void update(Game game, float delta);
    public abstract void render(Game game, Renderer renderer);

}
