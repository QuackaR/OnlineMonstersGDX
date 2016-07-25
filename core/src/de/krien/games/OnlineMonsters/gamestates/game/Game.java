package de.krien.games.OnlineMonsters.gamestates.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Game implements Screen {

    private Texture img;
    private TiledMap tiledMap;
    private OrthographicCamera camera;
    private TiledMapRenderer tiledMapRenderer;
    private SpriteBatch sb;
    private Texture texture;
    private Sprite sprite;

    public Game() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
        tiledMap = new TmxMapLoader().load("maps\\sewers.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

        sb = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("textures\\char.png"));
        sprite = new Sprite(texture);
        sprite.setScale(0.5f);
        sprite.setPosition(Gdx.graphics.getWidth()/2 - texture.getWidth()/2, Gdx.graphics.getHeight()/2 - texture.getHeight()/2);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            camera.translate(1,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            camera.translate(-1,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            camera.translate(0,1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            camera.translate(0,-1);
        }

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.translate(0,0);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        sb.begin();
        sprite.draw(sb);
        sb.end();
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
