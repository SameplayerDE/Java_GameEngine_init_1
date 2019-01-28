package io.github.SameplayerDE.GameEngine.Render;

import io.github.SameplayerDE.GameEngine.Game;
import io.github.SameplayerDE.GameEngine.GameConstant;

import java.awt.image.DataBufferInt;

public class Renderer {

    private int pixelWidth, pixelHeight;
    private int[] pixels;

    public Renderer(Game game) {
        pixelWidth = GameConstant.WIDTH;
        pixelHeight = GameConstant.HEIGHT;
        pixels = ((DataBufferInt) game.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void setPixel(int x, int y, int value) {
        if ((x < 0 || x >= pixelWidth || y < 0 || y >= pixelHeight) || value == 0xffff00ff) {
            return;
        }
        pixels[x + y * pixelWidth] = value;
    }

    public void drawSprite(Sprite sprite, int x, int y) {
        for (int i = 0; i < sprite.getTexture().height; i++) {
            for (int j = 0; j < sprite.getTexture().width; j++) {
                setPixel(i + x, j + y, sprite.getTexture().pixels[i + j * sprite.getTexture().width]);
            }
        }
    }

}
