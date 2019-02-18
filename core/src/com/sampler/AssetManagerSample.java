package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.Utils.GdxUtils;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class AssetManagerSample extends SampleBase {

    private static final Logger log = new Logger(AssetManagerSample.class.getSimpleName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(AssetManagerSample.class);

    private static final String BACKGROUND_BLUE = "raw/background-blue.png";
    private static final String RED_CIRCLE = "raw/circle-red.png";
    private static final String GREEN_CIRCLE = "raw/circle-green.png";
    private static final String FONT = "fonts/oswald-32.fnt";


    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private AssetManager manager;

    private Texture backgroundBlue;
    private Texture greenCircle;
    private Texture redCircle;
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
        manager.load(BACKGROUND_BLUE,Texture.class);
        manager.load(RED_CIRCLE,Texture.class);
        manager.load(GREEN_CIRCLE,Texture.class);
        manager.load(FONT,BitmapFont.class);



        //blocks until all resources are loaded into memory
        manager.finishLoading();

        //get assets
        backgroundBlue = manager.get(BACKGROUND_BLUE);
        redCircle = manager.get(RED_CIRCLE);
        greenCircle = manager.get(GREEN_CIRCLE);
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

        font.draw(batch, "Asset Manager Sample", 500, 50);



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
