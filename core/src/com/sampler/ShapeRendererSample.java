package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.Utils.GdxUtils;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class ShapeRendererSample extends SampleBase {

    private static final Logger log = new Logger(ShapeRendererSample.class.getSimpleName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(ShapeRendererSample.class);

    public static final float WORLD_HEIGHT = 20f;
    public static final float WORLD_WIDTH = 40f;

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;

    private boolean drawGrid = true;
    private boolean drawCircles = true;
    private boolean drawRectangles = true;
    private boolean drawPoints = true;


    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        renderer = new ShapeRenderer();

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height); //not centering camera
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();

        renderer.setProjectionMatrix(camera.combined);

        if (drawGrid) {
            drawGrid();
        }

        if (drawCircles) {
            drawCircles();
        }

        if (drawRectangles) {
            drawRectangles();
        }

        if (drawPoints) {
            drawPoints();
        }

    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.G) {
            drawGrid = !drawGrid;
            return true;
        }

        if (keycode == Input.Keys.C) {
            drawCircles = !drawCircles;
            return true;
        }

        if (keycode == Input.Keys.R) {
            drawRectangles = !drawRectangles;
            return true;
        }

        if (keycode == Input.Keys.P) {
            drawPoints = !drawPoints;
            return true;
        }

        return false;
    }

    private void drawPoints() {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.YELLOW);
        renderer.point(-5, 0, 0);
        renderer.point(5, -3, 0);
        renderer.point(8, 6, 1);

        renderer.end();

        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.ORANGE);
        renderer.x(-10, 0, .25f);
        renderer.end();
    }

    private void drawRectangles() {
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.rect(-8, 4, 4, 2);
        renderer.rect(-11, 3, 1, 5);
        renderer.end();
    }

    private void drawCircles() {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.BLUE);
        renderer.circle(2, 2, 2, 30);

        renderer.setColor(Color.GREEN);
        renderer.circle(-5, -5, 2, 30);
        renderer.end();
    }

    private void drawGrid() {
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.WHITE);

        int worldWidth = (int) WORLD_WIDTH;
        int worldHeight = (int) WORLD_HEIGHT;

        for (int x = -worldWidth; x < worldWidth; x++) {
            renderer.line(x, -worldHeight, x, worldHeight);
        }

        for (int y = -worldHeight; y < worldHeight; y++) {
            renderer.line(-worldWidth, y, worldWidth, y);
        }

        renderer.setColor(Color.RED);
        renderer.line(-worldWidth, 0f, worldWidth, 0f);
        //renderer.line(-worldWidth, worldHeight, worldWidth, worldHeight);
        renderer.line(0f, -worldHeight, 0f, worldHeight);
        // renderer.line(worldWidth,-worldHeight,worldWidth,worldHeight);

        renderer.end();
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
        renderer.dispose();
    }
}
