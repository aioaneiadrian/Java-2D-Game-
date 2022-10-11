package Game.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];

    public static Tile left = new left(1);
    public static Tile right = new right(2);

    public static Tile road3 = new road3(3);
    public static Tile road4 = new road4(4);
    public static Tile road5 = new road5(5);
    public static Tile road6 = new road6(6);



    public static final int tile=64;

    protected BufferedImage texture;
    protected final int id;


    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id]=this;

    }

    public void tick(){

    }

    public static int y1 = 0;

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x  ,y + y1 ,tile, tile,null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }

}
