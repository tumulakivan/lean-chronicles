package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy extends Entity {
    GamePanel gp;

    public Enemy(GamePanel gp) {
        this.gp = gp;

        setDefaultValues();
        getEnemyImage();
    }

    public void setDefaultValues() {
        x = 384;
        y = 288;
        speed = 0;
        direction = "left";
    }

    public void getEnemyImage() {
        try {
            idle1 = ImageIO.read(getClass().getResourceAsStream("/assets/enemy/Orc_Warrior/idle1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/assets/enemy/Orc_Warrior/idle2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/assets/enemy/Orc_Warrior/idle3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/assets/enemy/Orc_Warrior/idle4.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
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

        if(spriteNum == 1) {
            image = idle1;
        }
        if(spriteNum == 2) {
            image = idle2;
        }
        if(spriteNum == 3) {
            image = idle3;
        }
        if(spriteNum == 4) {
            image = idle4;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
