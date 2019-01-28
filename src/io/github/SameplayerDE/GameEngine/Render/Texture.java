package io.github.SameplayerDE.GameEngine.Render;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Texture {

    public int width, height;
    public int[] pixels;
    public BufferedImage image;

    public Texture(String path) {
        try {

            //File file = new File(path);
            image = ImageIO.read(Image.class.getResourceAsStream(path));
            //image = ImageIO.read(ClassLoader.getSystemResource(path).openStream());
            width = image.getWidth();
            height = image.getHeight();

            System.out.println(width);
            System.out.println(height);

            pixels = image.getRGB(0, 0, width, height, null, 0, width);

            image.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return image;
    }
}
