package com.hkhamm.rpg.levels;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.hkhamm.rpg.sprites.Sprite;
import com.hkhamm.rpg.sprites.Player;
import com.hkhamm.rpg.sprites.StationarySprite;

import java.util.HashMap;


public class Cave02 extends Level {

    public Cave02() {
        map = new TmxMapLoader().load("maps/cave02.tmx");

        Player player = new Player("images/wizard.png", 6.68f, 12, 78);

        sprites.add(player);

        exits.put(new Vector3(7.2f, 13.8f, 0), "cave");

        red = 0f;
        green = 0f;
        blue = 0f;
    }
}
