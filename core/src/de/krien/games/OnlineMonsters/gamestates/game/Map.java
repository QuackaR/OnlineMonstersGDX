package de.krien.games.OnlineMonsters.gamestates.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import de.krien.games.OnlineMonsters.gamestates.core.EGameState;

public class Map {

    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;

    public Map() {
        tiledMap = new TmxMapLoader().load("maps\\Test2.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    public void update() {

    }

    public void draw() {
        tiledMapRenderer.setView(((Game) EGameState.GAME.getScreen()).getCamera().getCamera());
        tiledMapRenderer.render();
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }
}
