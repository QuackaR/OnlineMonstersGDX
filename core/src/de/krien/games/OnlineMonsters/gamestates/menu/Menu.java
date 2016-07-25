package de.krien.games.OnlineMonsters.gamestates.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import de.krien.games.OnlineMonsters.OnlineMonstersGame;
import de.krien.games.OnlineMonsters.gamestates.core.EGameState;

public class Menu implements Screen {

    private Stage stage;

    public Menu() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Skin skin = MenuUtil.createBasicSkin();
        TextButton connectButton = new TextButton("Connect", skin);
        TextButton settingsButton = new TextButton("Settings", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        int center = Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8;

        connectButton.setPosition(center, Gdx.graphics.getHeight()/3*2 - Gdx.graphics.getHeight()/20);
        settingsButton.setPosition(center, Gdx.graphics.getHeight()/2 - Gdx.graphics.getHeight()/20);
        exitButton.setPosition(center, Gdx.graphics.getHeight()/3 - Gdx.graphics.getHeight()/20);

        connectButton.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                OnlineMonstersGame.getInstance().setGameState(EGameState.GAME);
            }
        });
        settingsButton.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                OnlineMonstersGame.getInstance().setGameState(EGameState.SETTINGS);
            }
        });
        exitButton.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                Gdx.app.exit();
            }
        });

        stage.addActor(connectButton);
        stage.addActor(settingsButton);
        stage.addActor(exitButton);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
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
}
