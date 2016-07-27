package de.krien.games.OnlineMonsters.gamestates.game;

import com.badlogic.gdx.Screen;
import de.krien.games.OnlineMonsters.gamestates.game.player.Player;

public class Game implements Screen {

    private Camera camera;
    private Map map;
    private Player player;

    public Game() {
        camera = new Camera();
        map = new Map();
        player = new Player();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        update();
        draw();
    }

    private void update() {
        map.update();
        player.update();
        camera.update(player.getPosition());
    }

    private void draw() {
        camera.clear();
        map.draw();
        player.draw();
        camera.draw();
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

    public Map getMap() {
        return map;
    }

    public Camera getCamera() {
        return camera;
    }

    public Player getPlayer() {
        return player;
    }
}
