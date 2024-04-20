package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;
    public BufferedImage left1, left2, left3, left4, right1, right2, right3, right4, idle1, idle2, idle3, idle4,
            right_attack1, right_attack2, right_attack3, right_attack4, left_attack1, left_attack2, left_attack3, left_attack4,
            moveFX1_right, moveFX2_right, moveFX3_right, moveFX4_right, moveFX1_left, moveFX2_left, moveFX3_left, moveFX4_left
            , attackFX1_right, attackFX2_right, attackFX3_right, attackFX4_right, attackFX1_left, attackFX2_left, attackFX3_left, attackFX4_left;
    public String direction, previousDirection;
    public boolean isAttacking = false;
    public int attackDuration = 4;
    public int attackFrame = 1;
    public int attackTime = 12;
    public int attackCounter = 0;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
