package com.hkhamm.rpg.levels;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.hkhamm.rpg.sprites.Sprite;
import com.hkhamm.rpg.sprites.Goblin;
import com.hkhamm.rpg.sprites.Player;
import com.hkhamm.rpg.sprites.StationarySprite;

import java.util.HashMap;


public class Cave extends Level {

    public Cave() {
        map = new TmxMapLoader().load("maps/cave.tmx");

        Player player = new Player("images/wizard.png", 6.68f, 2, 78);
        Goblin goblin01 = new Goblin("images/goblin.png", 6.68f, 10, 78);

        sprites.add(player);
        sprites.add(goblin01);

        exits.put(new Vector3(7.2f, 0.8f, 0), "level01");
        exits.put(new Vector3(7.2f, 12.8f, 0), "cave02");

        red = 0f;
        green = 0f;
        blue = 0f;
    }
}
