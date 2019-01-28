package io.github.SameplayerDE.GameEngine;

import io.github.SameplayerDE.GameEngine.Manager.DrawableGameObjectManager;
import io.github.SameplayerDE.GameEngine.Manager.GameObjectManager;
import io.github.SameplayerDE.GameEngine.Manager.InputerHandler;
import io.github.SameplayerDE.GameEngine.Manager.ObjectManager;
import io.github.SameplayerDE.GameEngine.Render.Renderer;
import io.github.SameplayerDE.GameEngine.Render.Window;

public class Game implements Runnable {

    private boolean running = false;

    private final int FPS = 60;
    private final int FRAME_CAP = 1000/FPS;

    private Thread thread;
    private Window window;
    private Renderer renderer;
    private InputerHandler inputerHandler;
    private AbstractGame game;
    private ObjectManager[] gameObjectManager;

    public Game(AbstractGame game) {
        this.game = game;
    }

    public void start() {

        window = new Window(this);
        renderer = new Renderer(this);
        inputerHandler = new InputerHandler(this);
        gameObjectManager = new ObjectManager[1];
        gameObjectManager[0] = new DrawableGameObjectManager(this);

        thread = new Thread(this);
        thread.run();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        running = true;

        boolean render = false;
        long firstLoopTime = 0;
        long passedTime = 0;
        long unprocessedTime = 0;
        long lastLoopTime = System.currentTimeMillis();

        while (running) {

            firstLoopTime = System.currentTimeMillis();
            passedTime = firstLoopTime - lastLoopTime;
            lastLoopTime = firstLoopTime;

            unprocessedTime += passedTime;

            while (unprocessedTime >= FRAME_CAP) {
                unprocessedTime -= FRAME_CAP;
                render = true;
                /**
                 * Update
                 */

                game.update(this, FRAME_CAP);
                for (ObjectManager objectManager : gameObjectManager) {
                    objectManager.update(FRAME_CAP);
                }

                /**
                 * Update
                 */
            }

            if (render) {
                /**
                 * Render
                 */
                renderer.clear();
                game.render(this, renderer);
                for (ObjectManager objectManager : gameObjectManager) {
                    objectManager.render(renderer);
                }
                window.update();
                /**
                 * Render
                 */
            }else{
                try {
                    Thread.sleep(1);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Window getWindow() {
        return window;
    }

    public int getFPS() {
        return FPS;
    }

    public int getFRAME_CAP() {
        return FRAME_CAP;
    }

    public Thread getThread() {
        return thread;
    }

    public AbstractGame getGame() {
        return game;
    }

    public InputerHandler getInputerHandler() {
        return inputerHandler;
    }

    public Renderer getRenderer() {
        return renderer;
    }
}
