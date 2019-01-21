package com.mariaiva.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;


    public Animation(TextureRegion region, int frameCount, float cycleTime){
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth()/frameCount;
        for(int i=0;i<frameCount;i++){
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;

    }

    public Animation(TextureAtlas ta, int frameCount, float cycleTime){
        for(TextureRegion tr : ta.getRegions()){
            frames.add(tr);
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;

    }

    public void flipX(){
        for (TextureRegion t : frames) {
            t.flip(true, false);
        }
    }

    public boolean isFlipX(){
        return getFrame().isFlipX();
    }

    public void update(float dt){
        currentFrameTime += dt;
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if(frame >= frameCount){
            frame = 0;
        }
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }

}
