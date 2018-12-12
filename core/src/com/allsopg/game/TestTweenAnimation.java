package com.allsopg.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import utility.Constants;
import utility.UniversalResource;

import static utility.Constants.BACKGROUND_COLOR;

public class TestTweenAnimation implements ApplicationListener {
    private SpriteBatch batch;
    private float animationTime;
    BonusSprite bp;
    BonusSprite bumper;
    private ScreenViewport viewport;
    private BitmapFont font;
    private static String text;

    @Override
    public void create() {
        viewport = new ScreenViewport();
        batch = new SpriteBatch();
        text = "Well Seymour, I made it, despite your directions.";
        font = new BitmapFont(Gdx.files.internal("android/assets/font/stencil.fnt"));
        bp = new BonusSprite(Constants.BALL_ATLAS,
                new Vector2(400,300),
                Constants.SIZE);
        bp.startupRoutine();
        bumper = new BumperSprite(Constants.BUMPER,
                new Vector2(50,50),
                Constants.SIZE);
        bumper.startupRoutine();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(BACKGROUND_COLOR.r,BACKGROUND_COLOR.g,
                BACKGROUND_COLOR.b,BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        animationTime+=Gdx.graphics.getDeltaTime();
        UniversalResource.getInstance().getTweenManager().update(animationTime);
        bp.update(animationTime);
        //draw
        batch.begin();
        font.draw(batch,text,Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/4);
        bp.draw(batch);
        batch.end();
    }

    public static void setText(String t)
    {
        text = t;
    }

    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void dispose() {}
    @Override
    public void resize(int width, int height) {}
}
