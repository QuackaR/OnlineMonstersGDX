package de.krien.games.OnlineMonsters.gamestates.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private Camera camera;
    private Map map;

    private SpriteBatch spriteBatch;

    private PlayerAnimation playerAnimation;
    private TextureRegion currentFrame;
    private float stateTime;

    private Vector2 position;

    public Player(Camera camera, Map map) {
        this.camera = camera;
        this.map = map;

        PlayerAnimation.init();
        playerAnimation = PlayerAnimation.STAND;

        spriteBatch = new SpriteBatch();
        position = new Vector2(900, 900);

        spriteBatch = new SpriteBatch();
        stateTime = 0f;
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
            if (Intersector.overlaps(rectangle, new Rectangle(position.x + offsetX, position.y, playerAnimation.getWidth(), playerAnimation.getHeight()))) {
                intersectX = true;
            }
            if (Intersector.overlaps(rectangle, new Rectangle(position.x , position.y + offsetY, playerAnimation.getWidth(), playerAnimation.getHeight()))) {
                intersectY = true;
            }
        }
        if(!intersectX) {
            position.add(offsetX, 0);
        }
        if(!intersectY) {
            position.add(0, offsetY);
        }

        if(offsetX == 0 && offsetY == 0) {
            playerAnimation = PlayerAnimation.STAND;
        } else if(offsetY < 0) {
            playerAnimation = PlayerAnimation.DOWN;
        } else if(offsetY > 0) {
            playerAnimation = PlayerAnimation.UP;
        }else if(offsetX < 0) {
            playerAnimation = PlayerAnimation.LEFT;
        } else if(offsetX > 0) {
            playerAnimation = PlayerAnimation.RIGHT;
        }

    }

    public void draw() {
        spriteBatch.setProjectionMatrix(camera.getCamera().combined);
        stateTime += Gdx.graphics.getDeltaTime();           // #15
        currentFrame = playerAnimation.getAnimation().getKeyFrame(stateTime, true);  // #16
        spriteBatch.begin();
        spriteBatch.draw(currentFrame, position.x, position.y);             // #17
        spriteBatch.end();
    }

    public Vector2 getPosition() {
        return position;
    }
}
