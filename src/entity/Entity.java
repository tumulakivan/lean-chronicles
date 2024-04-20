package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage left1, left2, left3, left4, right1, right2, right3, right4, idle1, idle2, idle3, idle4,
            right_attack1, right_attack2, right_attack3, right_attack4;
    public String direction;
    public boolean isAttacking = false;
    public int attackDuration = 0;
    public int attackFrame = 0;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
