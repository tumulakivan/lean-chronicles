package main;

import javax.swing.JPanel;
import java.awt.*;
import entity.Player;

public class GamePanel extends JPanel implements Runnable {
    // Screen Settings
    final int originalTileSize = 16; // 16x16 tile (character size)
    final int scale = 3; // scale for higher screen resolution
    public final int tileSize = originalTileSize * scale;
    // 4:3 ratio
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    // 768x576 reso (change both resolution and ratio later when finalizing
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    int fps = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH, "knight");

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /*
    @Override
    public void run() {
        double drawInterval = 1000000000/fps;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) {
            // update
            update();
            // draw
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    */

    public void run() {
        double drawInterval = 1000000000/fps;
        double delta = 0.0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000) {
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        g2.dispose();
    }
}
