package de.krien.games.OnlineMonsters.gamestates.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class Game implements Screen {
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


/*    private Map map;
    private Player player;

    private long timeOfLastGameLoop = System.nanoTime();

    public Game() {
    }

    public void init() {
        player = new Player();
        player.init(1);
        map = new Map();
        map.init();
    }

    @Override
    public void update() {
        float timeSinceLastGameLoop = getTimeSinceLastGameLoop();
        player.update(timeSinceLastGameLoop);
    }

    @Override
    public void draw() {
        map.draw();
        player.draw();
    }

    private float getTimeSinceLastGameLoop() {
        long timeOfThisGameLoop = System.nanoTime();
        long timeBetweenGameLoops = timeOfThisGameLoop - timeOfLastGameLoop;
        timeOfLastGameLoop = timeOfThisGameLoop;
        float secondsSinceLastGameLoop = (float) timeBetweenGameLoops / 1000000000;
        return secondsSinceLastGameLoop;
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    } */
}
