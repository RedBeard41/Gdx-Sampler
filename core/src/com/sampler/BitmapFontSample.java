package com.sampler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class BitmapFontSample extends SampleBase {

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(BitmapFontSample.class);
    private static final float WIDTH = 1080f; //world units with pixel ratio 1:1
    private static final float HEIGHT = 720f;

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;

    private BitmapFont effectFont;
    private BitmapFont uiFont;
    private GlyphLayout glyphLayout = new GlyphLayout();

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        batch = new SpriteBatch();

        effectFont = new BitmapFont(Gdx.files.internal("fonts/effects_font_32.fnt"));
        effectFont.getData().markupEnabled = true;
        uiFont = new BitmapFont(Gdx.files.internal("fonts/ui_Font_32.fnt"));

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {


     batch.setProjectionMatrix(camera.combined);
     batch.begin();

     draw();

     batch.end();



    }

    private void draw(){
        String text1 = "[GREEN]Using [BLUE]Bitmap [RED]Font";
        effectFont.draw(batch, text1, 0, HEIGHT);

        String text2 = "Bitmap Fonts are cool!".toUpperCase();
        glyphLayout.setText(uiFont,text2);
        uiFont.draw(batch, text2, (WIDTH - glyphLayout.width) /2f, (HEIGHT - glyphLayout.height) /2f);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
