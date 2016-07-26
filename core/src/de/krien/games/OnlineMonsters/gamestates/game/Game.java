package de.krien.games.OnlineMonsters.gamestates.game;

import com.badlogic.gdx.Screen;

public class Game implements Screen {

    private Camera camera;
    private Map map;
    private Player player;

    public Game() {
        camera = new Camera();
        map = new Map(camera);
        player = new Player(camera, map);
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
        camera.update(player);
        //camera.move(player.getSprite().getX(), player.getSprite().getY());
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
}
