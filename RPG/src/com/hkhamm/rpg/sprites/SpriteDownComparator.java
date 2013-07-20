package com.hkhamm.rpg.sprites;

import java.util.Comparator;

public class SpriteDownComparator implements Comparator<Sprite> {
    @Override
    public int compare(Sprite s1, Sprite s2) {
        return s1.compareTo(s2);
    }
}
