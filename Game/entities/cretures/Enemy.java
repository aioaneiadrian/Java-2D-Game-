package Game.entities.cretures;

import Game.entities.Entity;
import Game.gfx.Assets;

import java.awt.*;

public class Enemy extends Entity {

    public Enemy(float x, float y) {
        super(x, y, 32, 64);
    }

    public void tick() {
        y += 1;
    }

    public boolean hover(Player player) {
        for(int i = (int)x; i <= x + 30; i += 30) {
            for(int j = (int)y; j <= y + 60; j += 60) { // punct dusman
                for(int i1 = (int)player.getX(); i1 <= player.getX() + 30; i1++) {
                    for(int j1 = (int)player.getY(); j1 <= player.getY() + 60; j1++) { // punct player
                        if(i == i1 && j == j1) { // daca au un punct comun -> valeu
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }



    public void render(Graphics g) {
        g.drawImage(Assets.enemy, (int)x ,(int)y,null);
    }
}
