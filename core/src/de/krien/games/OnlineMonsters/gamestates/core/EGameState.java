package de.krien.games.OnlineMonsters.gamestates.core;

import com.badlogic.gdx.Screen;
import de.krien.games.OnlineMonsters.gamestates.menu.Menu;
import de.krien.games.OnlineMonsters.gamestates.game.Game;
import de.krien.games.OnlineMonsters.gamestates.menu.Settings;

public enum EGameState {


    MENU(new Menu()),
    GAME(new Game()),
    SETTINGS(new Settings()),
    EXIT(null);

    private Screen screen;

    EGameState(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
}
