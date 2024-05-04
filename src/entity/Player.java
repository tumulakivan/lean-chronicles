package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.io.IOException;

public abstract class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    @Override
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 3;
        direction = "right";
    }

    @Override
    public void update() {
        // attack (right for now)
        if(keyH.attackPressed && !isAttacking) {
            System.out.println("current direction: " + direction);
            System.out.println("previous direction: " + previousDirection);
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
            } else if(keyH.downPressed) {
                y += speed;
            }
            if(keyH.leftPressed) {
                direction = "left";
                previousDirection = direction;
                x -= speed;
            } else if(keyH.rightPressed) {
                direction = "right";
                previousDirection = direction;
                x += speed;
            }
        }

        // sprite idle
        if(!keyH.upPressed && !keyH.downPressed && !keyH.leftPressed && !keyH.rightPressed) {
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

        // sprinting
        if(keyH.sprintPressed) {
            setSpeed(5);
        } else {
            setSpeed(3);
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}