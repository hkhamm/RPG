package com.hkhamm.rpg;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;

import com.hkhamm.rpg.levels.Level;
import com.hkhamm.rpg.sprites.Player;
import com.hkhamm.rpg.sprites.Sprite;
import com.hkhamm.rpg.sprites.SpriteUpComparator;
import com.hkhamm.rpg.sprites.StationarySprite;

public class View {
    private Array<Sprite> sprites;
    private Array<Sprite> sortedUpSprites;
    private Array<Sprite> sortedDownSprites;
    private Array<StationarySprite> stationarySprites;
    private float red;
    private float green;
    private float blue;

    private Stage stage;

    private OrthographicCamera camera;

    private OrthogonalTiledMapRenderer mapRenderer;
    private int[] baseLayer;
    private int[] underlayer1;
    private int[] underlayer2;
    private int[] overLayer;

    private SpriteBatch spriteBatch;

    private Label hpLabel;
    private Label hp;

    private Skin skin;

    private BitmapFont font25;

    private Array<BitmapFont> fonts;

    private GameInputProcessor inputProcessor;

    public View(Level level) {
        stage = new Stage();
        inputProcessor = new GameInputProcessor();
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(inputProcessor);
        Gdx.input.setInputProcessor(multiplexer);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth() / 48f, Gdx.graphics.getHeight() / 48f);
        camera.update();

        sprites = level.getSprites();
        stationarySprites = level.getStationarySprites();
        red = level.getRed();
        green = level.getGreen();
        blue = level.getBlue();
        spriteBatch = new SpriteBatch();

        // Hide the mouse cursor.
        Gdx.input.setCursorCatched(true);

        TiledMap map = level.getMap();
        mapRenderer = new OrthogonalTiledMapRenderer(map, 1 / 48f);
        baseLayer = new int[1];
        baseLayer[0] = 0;
        underlayer1 = new int[1];
        underlayer1[0] = 1;
        underlayer2 = new int[1];
        underlayer2[0] = 2;
        overLayer = new int[1];
        overLayer[0] = 3;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(new FileHandle("fonts/advocut-webfont.ttf"));
        // BitmapFont font15 = generator.generateFont(15);
        font25 = generator.generateFont(25);
        generator.dispose();

        fonts = new Array<BitmapFont>();
        fonts.add(font25);

        setupHUD();
    }

    public void setupHUD() {
        skin = new Skin();

        // Generate a 1x1 white texture and store it in the skin named "white".
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("white", new Texture(pixmap));

        // Store the default libgdx font under the name "default".
        skin.add("default", font25);

        // Configure a TextButtonStyle and name it "default".
        // Skin resources are stored by type, so this doesn't overwrite the font.
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.background = skin.newDrawable("white", Color.DARK_GRAY);
        labelStyle.font = skin.getFont("default");
        skin.add("default", labelStyle);

        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        table.bottom().left();
        stage.addActor(table);

        hpLabel = new Label("  HP:  ", skin);
        hp = new Label(Integer.toString(sprites.get(0).getHP()), skin);
        table.add(hpLabel);
        table.add(hp).width(50);
    }

    public void render() {
        Gdx.gl.glClearColor(red, green, blue, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.set(sprites.get(0).getX() + 1, sprites.get(0).getY(), 0);
        camera.update();

        spriteBatch.setProjectionMatrix(camera.combined);

        mapRenderer.setView(camera);

        mapRenderer.render(baseLayer);
        mapRenderer.render(underlayer1);
        mapRenderer.render(underlayer2);

        sortedUpSprites = new Array<Sprite>(sprites);
        sortedUpSprites.sort(new SpriteUpComparator());

        // sortedDownSprites = new Array<Sprite>(sprites);
        // sortedDownSprites.sort(new SpriteDownComparator());

        spriteBatch.begin();
        renderStationarySprites();
        renderSprites();
        // renderSpritesTop();
        renderStationarySpritesTop();
        spriteBatch.end();

        mapRenderer.render(overLayer);

        hp.setText(Integer.toString(sprites.get(0).getHP()));
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void resize(int width, int height) {
        stage.setViewport(width, height, true);
    }

    private void renderSprites() {
        for (Sprite sprite : sortedUpSprites) {
            sprite.setAnimationTime(Gdx.graphics.getDeltaTime());

            switch (sprite.getState()) {
                case standFront:
                    sprite.setCurrentFrame(sprite.getStandFrontFrame());
                    break;
                case standBack:
                    sprite.setCurrentFrame(sprite.getStandBackFrame());
                    break;
                case standLeft:
                    sprite.setCurrentFrame(sprite.getStandLeftFrame());
                    break;
                case standRight:
                    sprite.setCurrentFrame(sprite.getStandRightFrame());
                    break;
                case walkFront:
                    sprite.setCurrentFrame(sprite.getWalkFrontFrame());
                    break;
                case walkBack:
                    sprite.setCurrentFrame(sprite.getWalkBackFrame());
                    break;
                case walkLeft:
                    sprite.setCurrentFrame(sprite.getWalkLeftFrame());
                    break;
                case walkRight:
                    sprite.setCurrentFrame(sprite.getWalkRightFrame());
                    break;
                case attackFront:
                    sprite.setCurrentFrame(sprite.getAttackFrontFrame());
                    break;
                case attackBack:
                    sprite.setCurrentFrame(sprite.getAttackBackFrame());
                    break;
                case attackLeft:
                    sprite.setCurrentFrame(sprite.getAttackLeftFrame());
                    break;
                case attackRight:
                    sprite.setCurrentFrame(sprite.getAttackRightFrame());
                    break;
                case death:
                    sprite.setCurrentFrame(sprite.getDeathFrame());
                    break;
            }

            if (!sprite.isFacingLeft()) {
                spriteBatch.draw(sprite.getCurrentFrame(), sprite.getX(), sprite.getY(),
                                 Sprite.SIZE, Sprite.SIZE);
            } else {
                spriteBatch.draw(sprite.getCurrentFrame(), sprite.getX() + Sprite.SIZE, sprite.getY(),
                                 -Sprite.SIZE, Sprite.SIZE);
            }
        }
    }

    private void renderSpritesTop() {
        for (Sprite sprite : sortedDownSprites) {
            sprite.setAnimationTime(Gdx.graphics.getDeltaTime());

            switch (sprite.getState()) {
                case standFront:
                    sprite.setCurrentFrameTop(sprite.getStandFrontFrame());
                    break;
                case standBack:
                    sprite.setCurrentFrameTop(sprite.getStandBackFrame());
                    break;
                case standLeft:
                    sprite.setCurrentFrameTop(sprite.getStandLeftFrame());
                    break;
                case standRight:
                    sprite.setCurrentFrameTop(sprite.getStandRightFrame());
                    break;
                case walkFront:
                    sprite.setCurrentFrameTop(sprite.getWalkFrontFrame());
                    break;
                case walkBack:
                    sprite.setCurrentFrameTop(sprite.getWalkBackFrame());
                    break;
                case walkLeft:
                    sprite.setCurrentFrameTop(sprite.getWalkLeftFrame());
                    break;
                case walkRight:
                    sprite.setCurrentFrameTop(sprite.getWalkRightFrame());
                    break;
                case attackFront:
                    sprite.setCurrentFrameTop(sprite.getAttackFrontFrame());
                    break;
                case attackBack:
                    sprite.setCurrentFrameTop(sprite.getAttackBackFrame());
                    break;
                case attackLeft:
                    sprite.setCurrentFrameTop(sprite.getAttackLeftFrame());
                    break;
                case attackRight:
                    sprite.setCurrentFrameTop(sprite.getAttackRightFrame());
                    break;
                case death:
                    sprite.setCurrentFrameTop(sprite.getDeathFrame());
                    break;
            }

            if (!sprite.isFacingLeft()) {
                spriteBatch.draw(sprite.getCurrentFrameTop(), sprite.getX(), sprite.getY() + 1,
                        Sprite.SIZE, Sprite.SIZE);
            } else {
                spriteBatch.draw(sprite.getCurrentFrameTop(), sprite.getX() + Sprite.SIZE, sprite.getY() + 1,
                        -Sprite.SIZE, Sprite.SIZE);
            }
        }
    }

    private void renderStationarySprites() {
        for (StationarySprite stationarySprite : stationarySprites) {
            stationarySprite.setAnimationTime(Gdx.graphics.getDeltaTime());

            stationarySprite.setCurrentFrame(stationarySprite.getAnimationFrame());

            spriteBatch.draw(stationarySprite.getCurrentFrame(), stationarySprite.getX(), stationarySprite.getY(),
                             stationarySprite.getSize(), stationarySprite.getSize());
        }
    }

    private void renderStationarySpritesTop() {
        for (StationarySprite stationarySprite : stationarySprites) {
            spriteBatch.draw(stationarySprite.getHeadTexture(),
                             stationarySprite.getX(), stationarySprite.getY() + 1,
                             stationarySprite.getSize(), stationarySprite.getSize());
        }
    }

    // TODO Add observer pattern: Game observes View and is notified of input, then modifies the player. 
    public void getInput() {
        Player player = (Player) sprites.get(0);

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            sprites.get(0).setState(Sprite.State.walkBack);
            sprites.get(0).setDY(Sprite.MAX_VELOCITY);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            sprites.get(0).setState(Sprite.State.walkFront);
            sprites.get(0).setDY(-Sprite.MAX_VELOCITY);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            sprites.get(0).setFacingLeft(true);
            sprites.get(0).setState(Sprite.State.walkLeft);
            sprites.get(0).setDX(-Sprite.MAX_VELOCITY);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            sprites.get(0).setFacingLeft(false);
            sprites.get(0).setState(Sprite.State.walkRight);
            sprites.get(0).setDX(Sprite.MAX_VELOCITY);
        }

        if (Gdx.input.justTouched()) {
            Vector3 point = getWorldPoint(Gdx.input.getX(), Gdx.input.getY());
            sprites.get(0).setPosition(point.x, point.y);

        }

        if (Gdx.input.isKeyPressed(Input.Keys.H)) {
            player.setHP(player.getHP() - 1);
        }

//        if (inputProcessor.keyTyped('t')) {
//            hpLabel.setText("Changed!");
//        }
    }
    public Vector3 getWorldPoint(float x, float y) {
        Vector3 worldPoint = new Vector3(x, y, 0);
        camera.unproject(worldPoint);

        float worldX = sprites.get(0).getX() - 15;
        float worldY = sprites.get(0).getY() - 9.375f;

        worldPoint.set(worldPoint.x + worldX, worldPoint.y + worldY, 0);

        return worldPoint;
    }

    public Stage getStage() {
        return stage;
    }

    public Array<BitmapFont> getFonts() {
        return fonts;
    }
}