package io.github.SameplayerDE.GameEngine.Manager;

import io.github.SameplayerDE.GameEngine.Game;

import java.awt.event.*;

public class InputerHandler implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private Game game;

    public boolean LEFT = false, RIGHT = false, TOP = false, BOTTOM = false;
    private int mouseX, mouseY;
    private int mouseWheel;

    public InputerHandler(Game game) {
        this.game = game;

        mouseX = 0;
        mouseY = 0;
        mouseWheel = 0;

        game.getWindow().getCanvas().addMouseListener(this);
        game.getWindow().getCanvas().addMouseMotionListener(this);
        game.getWindow().getCanvas().addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            TOP = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            BOTTOM = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            RIGHT = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            LEFT = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            TOP = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            BOTTOM = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            RIGHT = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            LEFT = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public int getMouseWheel() {
        return mouseWheel;
    }
}
