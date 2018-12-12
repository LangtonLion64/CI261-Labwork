package com.allsopg.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import utility.TweenData;
import utility.TweenDataAccessor;
import utility.UniversalResource;

public class BumperSprite extends BonusSprite {
    private TweenData tweenData;
    private TweenManager tweenManager;
    private HashMap<String, Sound> myNoises;


    public BumperSprite(String atlasString, Vector2 position, String size) {
        super(atlasString, position, size);
        initTweenData();
        myNoises = UniversalResource.getInstance().getNoises();
    }

    private void initTweenData(){
        tweenData = new TweenData();
        tweenData.setXY(new Vector2(this.getX(),this.getY()));
        tweenData.setColor(this.getColor());
        tweenData.setScale(this.getScaleX());
        tweenManager = UniversalResource.getInstance().getTweenManager();
    }

    private TweenData getTweenData(){return tweenData;}

    public void startupRoutine(){ ;
        Timeline.createSequence()
                .push(Tween.to(tweenData, TweenDataAccessor.TYPE_ROTATION,100f)
                        .target(360))
                .setCallback(new TweenCallback() {
                    @Override
                    public void onEvent(int type, BaseTween<?> source) {
                        setAnimation(Animation.PlayMode.LOOP);
                    }
                })
                .start(tweenManager);
    }
}
