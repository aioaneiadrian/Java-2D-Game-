package Game.tiles;

import Game.gfx.Assets;

public class left extends Tile{

    public left (int id){
        super (Assets.leftside,id);
    }

    public boolean isSolid(){
        return true;
    }
}
