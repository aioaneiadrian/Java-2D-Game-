package Game;

import Game.Display.Display;

public class Launcher {
    public static void main (String[] args){
        Game game = new Game("Drive to survive!", 320, 640);
        game.start();

    }
}
