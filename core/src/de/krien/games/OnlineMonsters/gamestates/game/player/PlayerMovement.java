package de.krien.games.OnlineMonsters.gamestates.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import de.krien.games.OnlineMonsters.gamestates.core.EGameState;
import de.krien.games.OnlineMonsters.gamestates.game.Game;

public class PlayerMovement {

    private static final int MOVEMENT_SPEED = 3;

    private PlayerSprite playerSprite;
    private TextureRegion currentFrame;

    private boolean movement;
    private float stateTime;
    private Vector2 position;


    public PlayerMovement() {
        PlayerSprite.init();
        playerSprite = PlayerSprite.STAND;
        stateTime = 0f;
        position = new Vector2(900, 900);
    }

    public void update() {
        Vector2 offset = calculateInput();
        boolean[] intersection = checkIntersection(offset);
        checkIfMovement(offset);
        moveSpritePosition(offset, intersection);
        changeAnimationSprite(offset);
    }

    private void changeAnimationSprite(Vector2 offset) {
        if(offset.y < 0) {
            playerSprite = PlayerSprite.DOWN;
        } else if(offset.y > 0) {
            playerSprite = PlayerSprite.UP;
        }else if(offset.x < 0) {
            playerSprite = PlayerSprite.LEFT;
        } else if(offset.x > 0) {
            playerSprite = PlayerSprite.RIGHT;
        }
    }

    private void checkIfMovement(Vector2 offset) {
        if(offset.x == 0 && offset.y == 0) {
            movement = false;
        } else {
            movement = true;
        }
    }

    private void moveSpritePosition(Vector2 offset, boolean[] intersection) {
        if(!intersection[0]) {
            position.add(offset.x, 0);
        }
        if(!intersection[1]) {
            position.add(0, offset.y);
        }
    }

    private boolean[] checkIntersection(Vector2 offset) {
        boolean[] intersection = new boolean[2];
        MapObjects objects = ((Game) EGameState.GAME.getScreen()).getMap().getTiledMap().getLayers().get(2).getObjects();
        for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {
            Rectangle rectangle = rectangleObject.getRectangle();
            if (Intersector.overlaps(rectangle, new Rectangle(position.x + offset.x, position.y, playerSprite.getWidth(), playerSprite.getHeight()))) {
                intersection[0] = true;
            }
            if (Intersector.overlaps(rectangle, new Rectangle(position.x , position.y + offset.y, playerSprite.getWidth(), playerSprite.getHeight()))) {
                intersection[1] = true;
            }
        }
        return intersection;
    }

    private Vector2 calculateInput() {
        Vector2 offset = new Vector2();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            offset.add(MOVEMENT_SPEED,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            offset.sub(MOVEMENT_SPEED,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            offset.add(0,MOVEMENT_SPEED);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            offset.sub(0,MOVEMENT_SPEED);
        }
        return offset;
    }

    public TextureRegion getCurrentFrame() {
        if(movement || currentFrame == null) {
            stateTime += Gdx.graphics.getDeltaTime();
            currentFrame = playerSprite.getAnimation().getKeyFrame(stateTime, true);
        }
        return currentFrame;
    }

    public Vector2 getPosition() {
        return position;
    }
}
