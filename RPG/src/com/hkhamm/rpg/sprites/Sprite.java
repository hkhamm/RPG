package com.hkhamm.rpg.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.hkhamm.rpg.Creature;


public class Sprite extends Creature implements Comparable<Sprite> {
    
    public static float SIZE = 1.625f;
    public static float MAX_VELOCITY = 4f;
    public static float DAMPING = 0.87f;

    public enum State {
        standFront,
        standBack,
        standLeft,
        standRight,

        walkFront,
        walkBack,
        walkLeft,
        walkRight,

        attackFront,
        attackBack,
        attackLeft,
        attackRight,

        death
    }

    private State state;
    private boolean facingLeft;
    protected Texture texture;
    protected Vector2 position;
    protected Vector2 velocity;
    protected float animationTime;

    protected TextureRegion currentFrame;
    protected TextureRegion currentFrameTop;

    protected Animation standFrontAnimation;
    protected Animation standBackAnimation;
    protected Animation standLeftAnimation;
    protected Animation standRightAnimation;
    protected Animation walkFrontAnimation;
    protected Animation walkBackAnimation;
    protected Animation walkLeftAnimation;
    protected Animation walkRightAnimation;
    protected Animation attackFrontAnimation;
    protected Animation attackBackAnimation;
    protected Animation attackLeftAnimation;
    protected Animation attackRightAnimation;
    protected Animation deathAnimation;

    public Sprite(String textureFile, float x, float y) {
        texture = new Texture(Gdx.files.internal(textureFile));
        position = new Vector2();
        velocity = new Vector2();
        animationTime = 0f;
        setPosition(x, y);
        state = State.standFront;
        facingLeft = false;
    }

    public TextureRegion[] getFrames(Texture texture, int row, int columns, int size) {
        TextureRegion[][] tmp = TextureRegion.split(texture, size, size);
        TextureRegion[] frames = new TextureRegion[columns];
        int index = 0;
        for (int i = 0; i < columns; i++) {
            frames[index++] = tmp[row][i];
        }
        return frames;
    }

    public TextureRegion getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(TextureRegion currentFrame) {
        this.currentFrame = currentFrame;
    }

    public TextureRegion getCurrentFrameTop() {
        return currentFrameTop;
    }

    public void setCurrentFrameTop(TextureRegion currentFrame) {
        this.currentFrameTop = new TextureRegion(currentFrame,
                                                 currentFrame.getRegionX(), currentFrame.getRegionY() + 48,
                                                 currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
    }

    public float getX() {
        return position.x;
    }

    public void setX(float x) {
        this.position.x = x;
    }

    public float getY() {
        return position.y;
    }

    public void setY(float y) {
        this.position.y = y;
    }

    public float getDX() {
        return velocity.x;
    }

    public void setDX(float velocity) {
        this.velocity.x = velocity;
    }

    public float getDY() {
        return velocity.y;
    }

    public void setDY(float velocity) {
        this.velocity.y = velocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x, float y) {
        this.position.set(x, y);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Texture getTexture() {
        return texture;
    }

    public float getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(float animationTime) {
        this.animationTime += animationTime;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isFacingLeft() {
        return facingLeft;
    }

    public void setFacingLeft(boolean facingLeft) {
        this.facingLeft = facingLeft;
    }

    public TextureRegion getStandFrontFrame() {
        return standFrontAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getStandBackFrame() {
        return standBackAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getStandLeftFrame() {
        return standLeftAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getStandRightFrame() {
        return standRightAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getWalkFrontFrame() {
        return walkFrontAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getWalkBackFrame() {
        return walkBackAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getWalkLeftFrame() {
        return walkLeftAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getWalkRightFrame() {
        return walkRightAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getAttackFrontFrame() {
        return attackFrontAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getAttackBackFrame() {
        return attackBackAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getAttackLeftFrame() {
        return attackLeftAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getAttackRightFrame() {
        return attackRightAnimation.getKeyFrame(animationTime, true);
    }

    public TextureRegion getDeathFrame() {
        return deathAnimation.getKeyFrame(animationTime, true);
    }

    public String comparableY() {
        return Float.toString(getY());
    }

    @Override
    public int compareTo(Sprite other) {
        return other.comparableY().compareTo(comparableY());

    }
}
