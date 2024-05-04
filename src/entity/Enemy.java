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
        getEntityImage();
    }

    @Override
    public void getMoveFXImage() {
        if(this.speed >= 5) {
            try {
                moveFX1_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/left1.png"));
                moveFX2_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/left3.png"));
                moveFX3_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/left4.png"));
                moveFX4_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/left5.png"));
                moveFX1_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/1.png"));
                moveFX2_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/3.png"));
                moveFX3_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/4.png"));
                moveFX4_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/5.png"));
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDefaultValues() {
        x = 384;
        y = 288;
        speed = 0;
        direction = "left";
    }

    @Override
    public void getEntityImage() {
        try {
            idle1 = ImageIO.read(getClass().getResourceAsStream("/assets/enemy/Orc_Warrior/idle1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/assets/enemy/Orc_Warrior/idle2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/assets/enemy/Orc_Warrior/idle3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/assets/enemy/Orc_Warrior/idle4.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAttackFXImage() {

    }

    @Override
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

    @Override
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
