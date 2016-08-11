package de.krien.games.OnlineMonsters.gamestates.game.player;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public enum PlayerSprite {
    STAND,
    DOWN,
    LEFT,
    RIGHT,
    UP;

    private static final int FRAME_COLS = 3;
    private static final int FRAME_ROWS = 4;

    private static Texture walkSheet;
    private static Animation standAnimation;
    private static Animation walkDownAnimation;
    private static Animation walkLeftAnimation;
    private static Animation walkRightAnimation;
    private static Animation walkUpAnimation;

    public static void init() {
        walkSheet = new Texture(Gdx.files.internal("textures\\Character02.png"));
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);

        TextureRegion[] walkDownFrames = tmp[0];
        TextureRegion[] walkLeftFrames = tmp[1];
        TextureRegion[] walkRightFrames = tmp[2];
        TextureRegion[] walkUpFrames = tmp[3];
        TextureRegion[] standFrames = new TextureRegion[1];
        standFrames[0] = walkDownFrames[1];

        standAnimation = new Animation(0.025f, standFrames);
        walkDownAnimation = new Animation(0.025f, walkDownFrames);
        walkLeftAnimation = new Animation(0.025f, walkLeftFrames);
        walkRightAnimation = new Animation(0.025f, walkRightFrames);
        walkUpAnimation = new Animation(0.025f, walkUpFrames);
    }

    public Animation getAnimation() {
        switch (this) {
            case STAND:
                return standAnimation;
            case DOWN:
                return walkDownAnimation;
            case LEFT:
                return walkLeftAnimation;
            case RIGHT:
                return walkRightAnimation;
            case UP:
                return walkUpAnimation;
            default:
                return standAnimation;
        }
    }

    public static float getHeight() {
        return walkSheet.getHeight()/FRAME_COLS;
    }

    public static float getWidth() {
        return walkSheet.getHeight()/FRAME_ROWS;
    }

}
