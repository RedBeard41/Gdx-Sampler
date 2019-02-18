package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.Utils.GdxUtils;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class TextureAtlasSample extends SampleBase {

    private static final Logger log = new Logger(TextureAtlasSample.class.getSimpleName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(TextureAtlasSample.class);

    public static final String ATLAS = "images/atlasSample.atlas";

    private static final String BACKGROUND_BLUE = "background-blue";
    private static final String RED_CIRCLE = "circle-red";
    private static final String GREEN_CIRCLE = "circle-green";
    private static final String FONT = "fonts/oswald-32.fnt";


    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private AssetManager manager;

    private TextureRegion backgroundBlue;
    private TextureRegion greenCircle;
    private TextureRegion redCircle;
    private BitmapFont font;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        manager = new AssetManager();
        manager.getLogger().setLevel(Logger.DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(1080,720, camera);
        batch = new SpriteBatch();

        //load assets
        manager.load(ATLAS,TextureAtlas.class);
        manager.load(FONT,BitmapFont.class);



        //blocks until all resources are loaded into memory
        manager.finishLoading();

        log.debug("diagnostics: "+ manager.getDiagnostics());
        TextureAtlas atlas = manager.get(ATLAS);

        //get assets
        backgroundBlue = atlas.findRegion(BACKGROUND_BLUE);
        redCircle = atlas.findRegion(RED_CIRCLE);
        greenCircle = atlas.findRegion(GREEN_CIRCLE);
        font = manager.get(FONT);
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.draw(backgroundBlue,0,0);
        batch.draw(greenCircle,50,50);
        batch.draw(redCircle,200,200);

        font.draw(batch, "Texture Atlas Sample", 500, 50);



        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
       batch.dispose();
       manager.dispose();
    }
}
