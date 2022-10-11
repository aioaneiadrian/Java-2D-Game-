package Game;

import Game.Display.Display;
import Game.States.GameState;
import Game.States.State;
import Game.gfx.Assets;
import Game.gfx.ImageLoader;
import Game.input.KeyManager;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.sql.SQLOutput;

public class Game implements Runnable{
    private Display display;
    public int width, height;
    public String title;


    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private KeyManager keyManager;

    // States
    private State gameState;

    public Game(String title, int width, int height){

        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();


    }

    private void init(){
        display = new Display(title , width , height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameState = new GameState(this);
        State.setState(gameState);

    }
    private void update() throws InterruptedException {
        keyManager.tick();
        if(State.getState()!=null)
            State.getState().tick();


    }
    private void render(){
        bs=display.getCanvas().getBufferStrategy();

        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0, display.getWidth(), display.getHeight());

        if(State.getState()!=null)
            State.getState().render(g);


        bs.show();
        g.dispose();


    }

    public void run(){
        init ();

        int fps =75;
        double timePerTick=1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0 ;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now-lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {

                try {
                    update();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                render();
                ticks++;
                delta--;
            }
        }
        if(timer >= 1000000000){
            System.out.println("Ticks and Frames: " + ticks);
            ticks = 0;
            timer = 0;
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public synchronized void start() {

        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
        if(!running)
            return ;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
