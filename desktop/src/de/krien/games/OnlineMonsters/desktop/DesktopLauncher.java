package de.krien.games.OnlineMonsters.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.krien.games.OnlineMonsters.OnlineMonstersGame;
import de.krien.games.OnlineMonsters.gamestates.menu.Menu;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Online Monsters";
        config.width = 1280;
        config.height = 720;
        new LwjglApplication(OnlineMonstersGame.getInstance(), config);
    }
}
