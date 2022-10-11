package Game.entities.cretures;

import Game.Game;
import Game.gfx.Assets;

import java.awt.*;

public class Player extends Creature{

    private Game game;

    public Player(Game game,float x, float y) {
        super(x, y, 32, 64);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }
    private void getInput(){

        xMove=0;
        yMove=0;

        if(game.getKeyManager().up) {
            yMove = -speed;
        }
        if(game.getKeyManager().down) {
            yMove = speed;
        }
        if(game.getKeyManager().left) {
            xMove = -speed;
        }
        if(game.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)x ,(int)y,null);

    }
}