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

    public Player(GamePanel gp, KeyHandler keyH, String heroClass) {
        this.gp = gp;
        this.keyH = keyH;
        this.heroClass = heroClass;

        setDefaultValues();
        getPlayerImage();
        getMoveFXImage();
        getAttackFXImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 5;
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
                right_attack1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/right_attack1.png"));
                right_attack2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/right_attack2.png"));
                right_attack3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/right_attack3.png"));
                right_attack4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/right_attack4.png"));
                left_attack1 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/left_attack1.png"));
                left_attack2 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/left_attack2.png"));
                left_attack3 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/left_attack3.png"));
                left_attack4 = ImageIO.read(getClass().getResourceAsStream("/assets/princess_lean/knight/left_attack4.png"));
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
            moveFX1_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/1.png"));
            moveFX2_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/3.png"));
            moveFX3_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/4.png"));
            moveFX4_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/basic_smoke/5.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void getAttackFXImage() {
        try {
            attackFX1_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/slash/image/right1.png"));
            attackFX2_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/slash/image/right2.png"));
            attackFX3_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/slash/image/right3.png"));
            attackFX4_right = ImageIO.read(getClass().getResourceAsStream("/assets/fx/slash/image/right4.png"));
            attackFX1_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/slash/image/left1.png"));
            attackFX2_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/slash/image/left2.png"));
            attackFX3_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/slash/image/left3.png"));
            attackFX4_left = ImageIO.read(getClass().getResourceAsStream("/assets/fx/slash/image/left4.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // attack (right for now)
        if(keyH.attackPressed && !isAttacking) {
            isAttacking = true;
            if(attackCounter != 0)
                attackCounter = 0;
        }

        if(isAttacking) {
            attackCounter++;
            if(attackCounter >= attackTime) {
                attackFrame++;
                attackCounter = 0;
            }

            if(attackFrame > attackDuration) {
                isAttacking = false;
                attackFrame = 1;
            }
        }

        // sprite direction facing
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
        }

        // sprite idle
        if(!keyH.upPressed && !keyH.downPressed && !keyH.leftPressed && !keyH.rightPressed)
            direction = "idle";

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
        BufferedImage right_trail_ahead = null;
        BufferedImage right_trail_behind = null;
        BufferedImage left_trail_ahead = null;
        BufferedImage left_trail_behind = null;
        BufferedImage attack_left = null;
        BufferedImage attack_right = null;
        BufferedImage basicSlash_left = null;
        BufferedImage basicSlash_right = null;
        int basicSlash_rightX = x + 15;
        int basicSlashY = y - 12;
        int basicSlash_leftX = x - 15;

        if(isAttacking) {
            switch(attackFrame) {
                case 1:
                    if(direction == "right") {
                        attack_right = right_attack1;
                        basicSlash_right = attackFX1_right;
                    } else {
                        attack_left = left_attack1;
                        basicSlash_left = attackFX1_left;
                    }
                    break;
                case 2:
                    if(direction == "right") {
                        attack_right = right_attack2;
                        basicSlash_right = attackFX2_right;
                    } else {
                        attack_left = left_attack2;
                        basicSlash_left = attackFX2_left;
                    }
                    break;
                case 3:
                    if(direction == "right") {
                        attack_right = right_attack3;
                        basicSlash_right = attackFX3_right;
                    } else {
                        attack_left = left_attack3;
                        basicSlash_left = attackFX3_left;
                    }
                    break;
                case 4:
                    if(direction == "right") {
                        attack_right = right_attack4;
                        basicSlash_right = attackFX4_right;
                    } else {
                        attack_left = left_attack4;
                        basicSlash_left = attackFX4_left;
                    }
                    break;
            }
            switch(direction) {
                case "left":
                    if(spriteNum == 1) {
                        left_trail_behind = moveFX1_left;
                    }
                    if(spriteNum == 2) {
                        left_trail_behind = moveFX2_left;
                    }
                    if(spriteNum == 3) {
                        left_trail_ahead = moveFX1_left;
                        left_trail_behind = moveFX3_left;
                    }
                    if(spriteNum == 4) {
                        left_trail_ahead = moveFX2_left;
                        left_trail_behind = moveFX4_left;
                    }
                    break;
                case "right":
                    if(spriteNum == 1) {
                        right_trail_behind = moveFX1_right;
                    }
                    if(spriteNum == 2) {
                        right_trail_behind = moveFX2_right;
                    }
                    if(spriteNum == 3) {
                        right_trail_ahead = moveFX1_right;
                        right_trail_behind = moveFX3_right;
                    }
                    if(spriteNum == 4) {
                        right_trail_ahead = moveFX2_right;
                        right_trail_behind = moveFX4_right;
                    }
                    break;
            }
            if(direction == "right") {
                g2.drawImage(attack_right, x, y, gp.tileSize, gp.tileSize, null);
                g2.drawImage(basicSlash_right, basicSlash_rightX, basicSlashY, gp.tileSize, gp.tileSize, null);
            } else {
                g2.drawImage(attack_left, x, y, gp.tileSize, gp.tileSize, null);
                g2.drawImage(basicSlash_left, basicSlash_leftX, basicSlashY, gp.tileSize, gp.tileSize, null);
            }
        } else {
            switch(direction) {
                case "left":
                    if(spriteNum == 1) {
                        image = left1;
                        left_trail_behind = moveFX1_left;
                    }
                    if(spriteNum == 2) {
                        image = left2;
                        left_trail_behind = moveFX2_left;
                    }
                    if(spriteNum == 3) {
                        image = left3;
                        left_trail_ahead = moveFX1_left;
                        left_trail_behind = moveFX3_left;
                    }
                    if(spriteNum == 4) {
                        image = left4;
                        left_trail_ahead = moveFX2_left;
                        left_trail_behind = moveFX4_left;
                    }
                    break;
                case "right":
                    if(spriteNum == 1) {
                        image = right1;
                        right_trail_behind = moveFX1_right;
                    }
                    if(spriteNum == 2) {
                        image = right2;
                        right_trail_behind = moveFX2_right;
                    }
                    if(spriteNum == 3) {
                        image = right3;
                        right_trail_ahead = moveFX1_right;
                        right_trail_behind = moveFX3_right;
                    }
                    if(spriteNum == 4) {
                        image = right4;
                        right_trail_ahead = moveFX2_right;
                        right_trail_behind = moveFX4_right;
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
            // main character sprite
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        }

        // movement dust trail
        int trailY = y + 12;
        if(direction == "right") {
            int right_trailX_behind = x - 26;
            int right_trailX_ahead = right_trailX_behind + 11;

            if(spriteNum == 2 || spriteNum == 3 || spriteNum == 4) {
                g2.drawImage(right_trail_behind, right_trailX_behind, trailY, gp.tileSize, gp.tileSize, null);
                g2.drawImage(right_trail_ahead, right_trailX_ahead, trailY, gp.tileSize, gp.tileSize, null);
            } else
                g2.drawImage(right_trail_behind, right_trailX_behind, trailY, gp.tileSize, gp.tileSize, null);
        }

        if(direction == "left") {
            int left_trailX_behind = x + 26;
            int left_trailX_ahead = left_trailX_behind - 11;

            if(spriteNum == 2 || spriteNum == 3 || spriteNum == 4) {
                g2.drawImage(left_trail_behind, left_trailX_behind, trailY, gp.tileSize, gp.tileSize, null);
                g2.drawImage(left_trail_ahead, left_trailX_ahead, trailY, gp.tileSize, gp.tileSize, null);
            } else
                g2.drawImage(left_trail_behind, left_trailX_behind, trailY, gp.tileSize, gp.tileSize, null);
        }

        System.out.println("coords: " + x + ", " + y);
    }
}