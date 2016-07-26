package de.krien.games.OnlineMonsters.gamestates.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Game implements Screen {

    private OrthographicCamera camera;

    private TiledMap tiledMap;
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

        tiledMap = new TmxMapLoader().load("maps\\Test.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

        sb = new SpriteBatch();

        texture = new Texture(Gdx.files.internal("textures\\char.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(0,0);
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
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            camera.translate(5,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            camera.translate(-5,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            camera.translate(0,5);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            camera.translate(0,-5);
        }

        float offsetX = 0;
        float offsetY = 0;

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            offsetX+=5;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            offsetX-=5;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            offsetY+=5;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            offsetY-=5;
        }

        boolean intersectX = false;
        boolean intersectY = false;

        MapObjects objects = tiledMap.getLayers().get(1).getObjects();
        for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {
            Rectangle rectangle = rectangleObject.getRectangle();
            if (Intersector.overlaps(rectangle, new Rectangle(sprite.getX() + offsetX, sprite.getY(), sprite.getWidth(), sprite.getHeight()))) {
                intersectX = true;
            }
            if (Intersector.overlaps(rectangle, new Rectangle(sprite.getX(), sprite.getY() + offsetY, sprite.getWidth(), sprite.getHeight()))) {
                intersectY = true;
            }
        }
        if(!intersectX) {
            sprite.translate(offsetX, 0);
        }
        if(!intersectY) {
            sprite.translate(0, offsetY);
        }
    }

    private void draw() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sprite.draw(sb);
        sb.end();

        camera.update();
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
