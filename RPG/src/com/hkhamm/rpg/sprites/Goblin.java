package com.hkhamm.rpg.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;

public class Goblin extends Sprite {

    public Goblin(String textureFile, float x, float y, int size) {
        super(textureFile, x, y);

        standFrontAnimation = new Animation(0.3f, getFrames(texture, 8, 2, size));
        standBackAnimation = new Animation(0.3f, getFrames(texture, 5, 2, size));
        standLeftAnimation = new Animation(0.3f, getFrames(texture, 2, 2, size));
        standRightAnimation = new Animation(0.3f, getFrames(texture, 2, 2, size));
        walkFrontAnimation = new Animation(0.3f, getFrames(texture, 7, 4, size));
        walkBackAnimation = new Animation(0.3f, getFrames(texture, 4, 4, size));
        walkLeftAnimation = new Animation(0.3f, getFrames(texture, 1, 3, size));
        walkRightAnimation = new Animation(0.3f, getFrames(texture, 1, 3, size));
        attackFrontAnimation = new Animation(0.3f, getFrames(texture, 6, 3, size));
        attackBackAnimation = new Animation(0.3f, getFrames(texture, 3, 3, size));
        attackLeftAnimation = new Animation(0.3f, getFrames(texture, 0, 3, size));
        attackRightAnimation = new Animation(0.3f, getFrames(texture, 0, 3, size));
    }
}
