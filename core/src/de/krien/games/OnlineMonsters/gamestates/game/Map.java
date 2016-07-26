package de.krien.games.OnlineMonsters.gamestates.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map {

    private Camera camera;

    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;

    public Map(Camera camera) {
        this.camera = camera;

        tiledMap = new TmxMapLoader().load("maps\\Test.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    public void update() {

    }

    public void draw() {
        tiledMapRenderer.setView(camera.getCamera());
        tiledMapRenderer.render();
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }
}
