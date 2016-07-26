package de.krien.games.OnlineMonsters.gamestates.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {

    private OrthographicCamera camera;

    public Camera() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
    }

    public void update() {
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
    }

    public void draw() {
        camera.update();
    }

    public void clear() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
