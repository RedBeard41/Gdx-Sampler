package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.Utils.GdxUtils;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class InputListeningSample extends SampleBase {

    private static final Logger log = new Logger(InputListeningSample.class.getSimpleName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO= new SampleInfo(InputListeningSample.class);

    private static final int MAX_MESSAGE_COUNT = 15;
    private final Array<String> messages = new Array<String>();


    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(1080, 720, camera);
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));

        //Gdx.input.setInputProcessor(this);
        InputMultiplexer multiplexer = new InputMultiplexer();

        InputAdapter firstProcessor = new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {

                log.debug("first - keyDown keycode=" + keycode);
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                log.debug("first - keyUp keycode=" + keycode);
                return false;
            }

        };
        InputAdapter secondProcessor = new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {

                log.debug("second - keyDown keycode=" + keycode);
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                log.debug("second - keyUp keycode=" + keycode);
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                log.debug("second - keyTyped character=" + character);
                return false;
            }
        };

        multiplexer.addProcessor(firstProcessor);
        multiplexer.addProcessor(secondProcessor);
        multiplexer.addProcessor(this);

        Gdx.input.setInputProcessor(multiplexer);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        //clear screen
        GdxUtils.clearScreen();


        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();
        batch.end();
    }

    private void draw() {
        for (int i = 0; i < messages.size; i++) {
            font.draw(batch, messages.get(i),
                    20.0f,
                    720 - 40.0f * (i + 1));
        }


    }

    private void addMessage(String message) {
        messages.add(message);

        if (messages.size > MAX_MESSAGE_COUNT) {
            messages.removeIndex(0);
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();

    }

    @Override
    public boolean keyDown(int keycode) {

        String message = "KeyDown keycode=" + keycode;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        String message = "KeyUP keycode=" + keycode;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        String message = "KeyTyped keycode=" + character;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        String message = "TouchDown screenX=" + screenX + " screenY: " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        String message = "TouchUP screenX=" + screenX + " screenY: " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        String message = "TouchDragged screenX=" + screenX + " screenY: " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        String message = "mouseMoved screenX=" + screenX + " screenY: " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        String message = "scrolled amount=" + amount;
        log.debug(message);
        addMessage(message);
        return true;
    }
}
