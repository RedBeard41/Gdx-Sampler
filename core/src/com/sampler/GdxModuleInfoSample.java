package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class GdxModuleInfoSample extends SampleBase {

    private static final Logger log = new Logger(GdxModuleInfoSample.class.getSimpleName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO= new SampleInfo(GdxModuleInfoSample.class);

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        log.debug("app=" + Gdx.app);
        log.debug("audio=" + Gdx.audio);
        log.debug("input=" + Gdx.input);
        log.debug("files=" + Gdx.files);
        log.debug("net=" + Gdx.net);
        log.debug("graphics=" + Gdx.graphics);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
