package Game.entities.cretures;

import Game.entities.Entity;

import java.awt.*;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 1;
    public static final int DEFAULT_HEIGHT = 64;
    public static final int DEFAULT_WEIDHT = 64;


    protected  int health;
    protected  float speed;
    protected float xMove,yMove;



    public Creature(float x, float y, int width, int height) {

        super(x, y,width,height);
        health = DEFAULT_HEALTH;
        speed = 3.0f;
        xMove = 0;
        yMove = 0;

    }

    public void move (){
        if(x >= 64 && x <= 4 * 64 - 32) {
            x += xMove;
        }
        if((x >= 55 && x < 64 ) ||(x > 224 && x <= 235 )) {
            x -= xMove;
        }
        if(y <= 640 - 32 && y >= -32) {
            y += yMove;
        }
        if(y > 604 || y < -32) {
            y -= yMove;
        }
    }

    //GETTER AND SETTERS
    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
