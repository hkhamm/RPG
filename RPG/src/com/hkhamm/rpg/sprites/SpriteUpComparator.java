package com.hkhamm.rpg.sprites;

import java.util.Comparator;

public class SpriteUpComparator implements Comparator<Sprite> {
    @Override
    public int compare(Sprite s1, Sprite s2) {
        return s2.compareTo(s1);
    }
}
