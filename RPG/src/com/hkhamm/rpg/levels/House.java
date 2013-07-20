package com.hkhamm.rpg.levels;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.hkhamm.rpg.sprites.Sprite;
import com.hkhamm.rpg.sprites.Player;
import com.hkhamm.rpg.sprites.StationarySprite;

import java.util.HashMap;


public class House extends Level {

    public House() {
        map = new TmxMapLoader().load("maps/cave.tmx");

        Player player = new Player("images/wizard.png", 6.68f, 3, 78);

        sprites = new Array<Sprite>();
        sprites.add(player);

        stationarySprites = new Array<StationarySprite>();

        red = 0f;
        green = 0f;
        blue = 0f;

        exits = new HashMap<Vector3, String>(1);
        exits.put(new Vector3(0, 0, 0), "cave");
    }
}
