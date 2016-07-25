package de.krien.games.OnlineMonsters;

import com.badlogic.gdx.Game;
import de.krien.games.OnlineMonsters.gamestates.core.EGameState;

public class OnlineMonstersGame extends Game {

    private static OnlineMonstersGame instance;
    private EGameState gameState;

    private OnlineMonstersGame() {
    }

    public static OnlineMonstersGame getInstance() {
        if(instance == null) {
            instance = new OnlineMonstersGame();
        }
        return instance;
    }

    @Override
    public void create() {
        gameState = EGameState.MENU;
        setScreen(gameState.getScreen());
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {

    }

    public EGameState getGameState() {
        return gameState;
    }

    public void setGameState(EGameState gameState) {
        this.gameState = gameState;
        setScreen(gameState.getScreen());
    }


}
