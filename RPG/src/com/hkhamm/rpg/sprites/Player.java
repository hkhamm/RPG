package com.hkhamm.rpg.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;
import com.hkhamm.rpg.classes.GameClass;
import com.hkhamm.rpg.classes.Wizard;
import com.hkhamm.rpg.races.Human;

public class Player extends Sprite {

    public Player(String textureFile, float x, float y, int size) {
        super(textureFile, x, y);

        // Animations
        standFrontAnimation = new Animation(0.3f, getFrames(texture, 9, 6, size));
        standBackAnimation = new Animation(0.3f, getFrames(texture, 8, 6, size));
        standLeftAnimation = new Animation(0.3f, getFrames(texture, 7, 6, size));
        standRightAnimation = new Animation(0.3f, getFrames(texture, 7, 6, size));
        walkFrontAnimation = new Animation(0.3f, getFrames(texture, 6, 4, size));
        walkBackAnimation = new Animation(0.3f, getFrames(texture, 5, 4, size));
        walkLeftAnimation = new Animation(0.3f, getFrames(texture, 4, 4, size));
        walkRightAnimation = new Animation(0.3f, getFrames(texture, 4, 4, size));
        attackFrontAnimation = new Animation(0.3f, getFrames(texture, 3, 4, size));
        attackBackAnimation = new Animation(0.3f, getFrames(texture, 2, 4, size));
        attackLeftAnimation = new Animation(0.3f, getFrames(texture, 1, 4, size));
        attackRightAnimation = new Animation(0.3f, getFrames(texture, 1, 4, size));
        deathAnimation = new Animation(0.3f, getFrames(texture, 0, 4, size));

        // General
        name = "Player";
        race = new Human();
        classes = new Array<GameClass>();
        classes.add(new Wizard());
        HP = 10;
        speed = 6;
        initiative = 1;
        moveActions = 2;
        attackActions = 1;

        // Abilities
        strength = 10;
        dexterity = 10;
        constitution = 10;
        intelligence = 10;
        wisdom = 10;
        charisma = 10;

        // Ability Modifiers
        strMod = (strength / 2) - 5;
        dexMod = (dexterity / 2) - 5;
        conMod = (constitution / 2) - 5;
        intMod = (intelligence / 2) - 5;
        wisMod = (wisdom / 2) - 5;
        chaMod = (charisma / 2) - 5;

        // Defense
        AC = 10 + armorBonus + shieldBonus + dexMod + sizeMod + naturalArmor + deflectionMod + miscArmorMod;
        ACTouch = AC - armorBonus - shieldBonus;
        ACFlatFooted = AC - dexMod;
        armorBonus = 0;
        shieldBonus = 0;
        sizeMod = 0;
        naturalArmor = 0;
        deflectionMod = 0;
        miscArmorMod = 0;

        // Saving Throws
        fortitude = 0;
        will = 0;
        reflex = 0;

        // Attack
        BAB = 0;
        CMB = 0;
        CMD = 10;
        
        // Skill Ranks
        acrobaticsRank = 0;
        appraiseRank = 0;
        bluffRank = 0;
        climbRank = 0;
        craftRank = 0;
        diplomacyRank = 0;
        disableDeviceRank = 0;
        disguiseRank = 0;
        escapeArtistRank = 0;
        flyRank = 0;
        handleAnimalRank = 0;
        healRank = 0;
        intimidateRank = 0;
        knowledgeArcanaRank = 0;
        knowledgeDungeoneeringRank = 0;
        knowledgeEngineeringRank = 0;
        knowledgeGeographyRank = 0;
        knowledgeHistoryRank = 0;
        knowledgeLocalRank = 0;
        knowledgeNatureRank = 0;
        knowledgeNobilityRank = 0;
        knowledgePlanesRank = 0;
        knowledgeReligionRank = 0;
        linguisticsRank = 0;
        perceptionRank = 0;
        performRank = 0;
        professionRank = 0;
        rideRank = 0;
        senseMotiveRank = 0;
        sleightOfHandRank = 0;
        spellcraftRank = 0;
        stealthRank = 0;
        survivalRank = 0;
        swimRank = 0;
        useMagicDeviceRank = 0;

        // Skill MiscMods
        acrobaticsMiscMod = 0;
        appraiseMiscMod = 0;
        bluffMiscMod = 0;
        climbMiscMod = 0;
        craftMiscMod = 0;
        diplomacyMiscMod = 0;
        disableDeviceMiscMod = 0;
        disguiseMiscMod = 0;
        escapeArtistMiscMod = 0;
        flyMiscMod = 0;
        handleAnimalMiscMod = 0;
        healMiscMod = 0;
        intimidateMiscMod = 0;
        knowledgeArcanaMiscMod = 0;
        knowledgeDungeoneeringMiscMod = 0;
        knowledgeEngineeringMiscMod = 0;
        knowledgeGeographyMiscMod = 0;
        knowledgeHistoryMiscMod = 0;
        knowledgeLocalMiscMod = 0;
        knowledgeNatureMiscMod = 0;
        knowledgeNobilityMiscMod = 0;
        knowledgePlanesMiscMod = 0;
        knowledgeReligionMiscMod = 0;
        linguisticsMiscMod = 0;
        perceptionMiscMod = 0;
        performMiscMod = 0;
        professionMiscMod = 0;
        rideMiscMod = 0;
        senseMotiveMiscMod = 0;
        sleightOfHandMiscMod = 0;
        spellcraftMiscMod = 0;
        stealthMiscMod = 0;
        survivalMiscMod = 0;
        swimMiscMod = 0;
        useMagicDeviceMiscMod = 0;
    }
}