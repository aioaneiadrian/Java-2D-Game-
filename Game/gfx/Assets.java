package Game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage player, enemy, leftside, rightside,road5,road6,road3,road4;

    public static void init(){

        player=ImageLoader.loadImage("/textures/masina_adita.png");
        enemy = ImageLoader.loadImage("/textures/masina_dusman.png");
        leftside=ImageLoader.loadImage("/textures/tile1.png");
        rightside=ImageLoader.loadImage("/textures/tile2.png");

        road3 =ImageLoader.loadImage("/textures/sus.png");
        road4 =ImageLoader.loadImage("/textures/stangajos.png");
        road5 =ImageLoader.loadImage("/textures/mij.png");
        road6 =ImageLoader.loadImage("/textures/dreaptajos.png");



    }
}
