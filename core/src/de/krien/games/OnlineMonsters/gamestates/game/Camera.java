package de.krien.games.OnlineMonsters.gamestates.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class Camera {

    private OrthographicCamera camera;

    public Camera() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
        camera.zoom -= 0.66f;
    }

    public void update(Vector2 position) {
        camera.translate(position.x - camera.position.x, position.y - camera.position.y);
    }

    public void draw() {
        camera.update();
    }

    public void clear() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void move(float x, float y) {
        camera.translate(x - camera.position.x, y - camera.position.y);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
