package de.krien.games.OnlineMonsters.gamestates.game.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import de.krien.games.OnlineMonsters.gamestates.core.EGameState;
import de.krien.games.OnlineMonsters.gamestates.game.Game;

public class Player {

    private PlayerMovement playerMovement;

    private SpriteBatch spriteBatch;

    public Player() {
        playerMovement = new PlayerMovement();

        spriteBatch = new SpriteBatch();
    }

    public void update() {
        playerMovement.update();
    }

    public void draw() {
        spriteBatch.setProjectionMatrix(((Game) EGameState.GAME.getScreen()).getCamera().getCamera().combined);
        spriteBatch.begin();
        spriteBatch.draw(
                playerMovement.getCurrentFrame(),
                playerMovement.getPosition().x,
                playerMovement.getPosition().y
        );
        spriteBatch.end();
    }

    public Vector2 getPosition() {
        return playerMovement.getPosition();
    }
}
