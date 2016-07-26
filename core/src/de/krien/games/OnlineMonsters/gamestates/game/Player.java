package de.krien.games.OnlineMonsters.gamestates.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Player {

    private Camera camera;
    private Map map;

    private SpriteBatch spriteBatch;
    private Texture texture;
    private Sprite sprite;

    public Player(Camera camera, Map map) {
        this.camera = camera;
        this.map = map;

        spriteBatch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("textures\\char.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(500,500);
    }

    public void update() {
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

        MapObjects objects = map.getTiledMap().getLayers().get(2).getObjects();
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

    public void draw() {
        spriteBatch.setProjectionMatrix(camera.getCamera().combined);
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }
}
