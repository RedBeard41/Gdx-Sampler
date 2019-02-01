package com.sampler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.Utils.GdxUtils;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class SpriteBatchSample extends SampleBase {

    private static final Logger log = new Logger(SpriteBatchSample.class.getSimpleName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(SpriteBatchSample.class);

    private static final float WORLD_WIDTH = 10.8f; //world units

    private static final float WORLD_HEIGHT = 7.2f; //world units


    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;

    private Texture texture;
    private Color oldColor;

    private int width = 1; //world units
    private int height = 1; //world units

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        batch = new SpriteBatch();

        oldColor = new Color();
        texture = new Texture(Gdx.files.internal("raw/character.png"));
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();

        batch.end();
    }

    private void draw() {
        batch.draw(texture,
                1, 1,  //x,y
                width / 2f, height / 2f, //originX, originY
                width, height, //width, height
                1.0f, 1.0f, //scaleX, scaleY
                0f, //rotation
                0, 0, //srcX, srcY
                texture.getWidth(), texture.getHeight(), //srcWidth, srcHeight
                false, false); //flipX, flipY

        //flip character
        batch.draw(texture,
                4, 2,  //x,y
                width / 2f, height / 2f, //originX, originY
                width, height, //width, height
                2.0f, 2.0f, //scaleX, scaleY
                0f, //rotation
                0, 0, //srcX, srcY
                texture.getWidth(), texture.getHeight(), //srcWidth, srcHeight
                true, false); //flipX, flipY

        oldColor.set(batch.getColor());

        //set color to sprite batch
        batch.setColor(Color.GREEN);

        //render green character

        batch.draw(texture,
                8, 1,  //x,y
                width / 2f, height / 2f, //originX, originY
                width, height, //width, height
                1.0f, 1.0f, //scaleX, scaleY
                0f, //rotation
                0, 0, //srcX, srcY
                texture.getWidth(), texture.getHeight(), //srcWidth, srcHeight
                false, false); //flipX, flipY

        batch.setColor(oldColor);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();

    }
}
