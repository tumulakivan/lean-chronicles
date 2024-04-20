package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    private String heroClass;
    BufferedImage moveFX1_right, moveFX2_right, moveFX3_right, moveFX4_right;
    private boolean isMoving = false;

    public Player(GamePanel gp, KeyHandler keyH, String heroClass) {
        this.gp = gp;
        this.keyH = keyH;
        this.heroClass = heroClass;

        setDefaultValues();
        getPlayerImage();
        getMoveFXImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "right";
    }

    public void getPlayerImage() {
        try {
            if(this.heroClass == "knight") {
                left1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/left1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/left2.png"));
                left3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/left3.png"));
                left4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/left4.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/right1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/right2.png"));
                right3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/right3.png"));
                right4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/right4.png"));
                idle1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/idle1.png"));
                idle2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/idle2.png"));
                idle3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/idle3.png"));
                idle4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/idle4.png"));
            }
            if(this.heroClass == "mage") {
                left1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/left1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/left2.png"));
                left3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/left3.png"));
                left4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/left4.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/right1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/right2.png"));
                right3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/right3.png"));
                right4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/right4.png"));
                idle1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/idle1.png"));
                idle2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/idle2.png"));
                idle3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/idle3.png"));
                idle4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/mage/idle4.png"));
            }
            if(this.heroClass == "outlaw") {
                left1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/left1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/left2.png"));
                left3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/left3.png"));
                left4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/left4.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/right1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/right2.png"));
                right3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/right3.png"));
                right4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/right4.png"));
                idle1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/idle1.png"));
                idle2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/idle2.png"));
                idle3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/idle3.png"));
                idle4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/outlaw/idle4.png"));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void getMoveFXImage() {
        try {
            moveFX1_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/left1.png"));
            moveFX2_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/left3.png"));
            moveFX3_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/left4.png"));
            moveFX4_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/left5.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // sprite direction facing
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            isMoving = true;
            if(keyH.upPressed) {
                y -= speed;
            }
            else if(keyH.downPressed) {
                y += speed;
            }
            else if(keyH.leftPressed) {
                direction = "left";
                x -= speed;
            }
            else if(keyH.rightPressed) {
                direction = "right";
                x += speed;
            }
        }

        // sprite idle
        if(!keyH.upPressed && !keyH.downPressed && !keyH.leftPressed && !keyH.rightPressed) {
            isMoving = false;
            direction = "idle";
        }

        // sprite animation
        spriteCounter++;
        if(spriteCounter > 12) {
            switch(spriteNum) {
                case 1:
                    spriteNum = 2;
                    break;
                case 2:
                    spriteNum = 3;
                    break;
                case 3:
                    spriteNum = 4;
                    break;
                case 4:
                    spriteNum = 1;
                    break;
            }

            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        BufferedImage trail_ahead = null;
        BufferedImage trail_behind = null;

        switch(direction) {
            case "left":
                if(spriteNum == 1)
                    image = left1;
                if(spriteNum == 2)
                    image = left2;
                if(spriteNum == 3)
                    image = left3;
                if(spriteNum == 4)
                    image = left4;
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                    trail_behind = moveFX1_right;
                }
                if(spriteNum == 2)
                    image = right2;
                    trail_behind = moveFX2_right;
                if(spriteNum == 3) {
                    image = right3;
                    trail_ahead = moveFX1_right;
                    trail_behind = moveFX3_right;
                }
                if(spriteNum == 4) {
                    image = right4;
                    trail_ahead = moveFX2_right;
                    trail_behind = moveFX4_right;
                }
                break;
            case "idle":
                if(spriteNum == 1)
                    image = idle1;
                if(spriteNum == 2)
                    image = idle2;
                if(spriteNum == 3)
                    image = idle3;
                if(spriteNum == 4)
                    image = idle4;
                break;
        }

        int trailY = y + 12;
        int trailX_behind = x - 26;
        int trailX_ahead = x - 15;

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

        if(spriteNum == 2 || spriteNum == 3 || spriteNum == 4) {
            g2.drawImage(trail_behind, trailX_behind, trailY, gp.tileSize, gp.tileSize, null);
            g2.drawImage(trail_ahead, trailX_ahead, trailY, gp.tileSize, gp.tileSize, null);
        } else
            g2.drawImage(trail_behind, trailX_behind, trailY, gp.tileSize, gp.tileSize, null);
    }
}