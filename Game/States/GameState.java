package Game.States;

import Game.Game;
import Game.entities.cretures.Enemy;
import Game.entities.cretures.Player;
import Game.gfx.Assets;
import Game.tiles.Tile;
import Game.worlds.World;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameState extends State{

    private Player player;
    private World world;
    private ArrayList<Enemy> enemies = new ArrayList<>();

    private long start;
    private int nrSec = 0;

    public GameState(Game game){
        super(game);
        start = System.nanoTime();
        player = new Player(game,144, 600);
        world = new World("res/world1.txt");

    }

    @Override
    public void tick() throws InterruptedException {
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        if(timeElapsed / 1e9 > nrSec) {
            nrSec++;
            if(nrSec % 2 == 0) {
                int[] vals = {64, 115, 168, 220};
                int index = (int)(Math.random() * 4);
                enemies.add(new Enemy(vals[index], -64));
            }
        }

        world.tick();
        player.tick();
        for(Enemy enemy : enemies) {
            enemy.tick();
            if(enemy.hover(player)) {
                System.exit(1); // actiune exit
            }
        }

        for(int i = 0; i < enemies.size(); ++i) {
            if(enemies.get(i).getY() > 640) {
                enemies.remove(i);
                i--;
                System.out.println("++");
            }
        }

    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);

        for(Enemy enemy : enemies) {
            enemy.render(g);
        }
    }
}
