package io.github.SameplayerDE.GameEngine.Render;

import io.github.SameplayerDE.GameEngine.Game;
import io.github.SameplayerDE.GameEngine.GameConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Calendar;

public class Window {

    private JFrame frame;
    private BufferedImage image;
    private Canvas canvas;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    public Window(Game game) {
        image = new BufferedImage(GameConstant.WIDTH, GameConstant.HEIGHT, BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();

        Dimension dimension = new Dimension(GameConstant.WIDTH, GameConstant.HEIGHT);
        canvas.setPreferredSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMinimumSize(dimension);

        frame = new JFrame(GameConstant.TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        graphics = bufferStrategy.getDrawGraphics();
    }

    public void update() {
        graphics.drawImage(image, 0,0,canvas.getWidth(), canvas.getHeight(), null);
        bufferStrategy.show();
    }

    public JFrame getFrame() {
        return frame;
    }

    public BufferedImage getImage() {
        return image;
    }

    public BufferStrategy getBufferStrategy() {
        return bufferStrategy;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Graphics getGraphics() {
        return graphics;
    }
}
