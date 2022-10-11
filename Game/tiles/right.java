package Game.tiles;

import Game.gfx.Assets;

import java.awt.image.BufferedImage;

public class right extends Tile{
    public right( int id) {
        super(Assets.rightside, id);
    }

    public boolean isSolid(){
        return true;
    }
}
