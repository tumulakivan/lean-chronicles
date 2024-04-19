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

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "right";
    }

    public void getPlayerImage() {
        try {
            left1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/test_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/test_left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/test_left_3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/test_left_4.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/test_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/test_right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/test_right_3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/test_right_4.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
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
    }

    public void draw(Graphics2D g2) {
        //g2.setColor(Color.WHITE);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

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
                if(spriteNum == 1)
                    image = right1;
                if(spriteNum == 2)
                    image = right2;
                if(spriteNum == 3)
                    image = right3;
                if(spriteNum == 4)
                    image = right4;
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
