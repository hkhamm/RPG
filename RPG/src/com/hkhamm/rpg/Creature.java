package com.hkhamm.rpg;

import com.badlogic.gdx.utils.Array;

import com.hkhamm.rpg.classes.GameClass;
import com.hkhamm.rpg.races.Race;

public class Creature {

    protected String name;
    protected Race race;
    protected Array<GameClass> classes;
    protected int HP;
    protected int speed;
    protected int initiative;
    protected int miscInitMod;
    protected int moveActions;
    protected int attackActions;

    // Abilities
    protected int strength;
    protected int strMod;
    protected int dexterity;
    protected int dexMod;
    protected int constitution;
    protected int conMod;
    protected int intelligence;
    protected int intMod;
    protected int wisdom;
    protected int wisMod;
    protected int charisma;
    protected int chaMod;

    // Defense
    protected int AC;
    protected int ACTouch;
    protected int ACFlatFooted;
    protected int armorBonus;
    protected int shieldBonus;
    protected int sizeMod;
    protected int naturalArmor;
    protected int deflectionMod;
    protected int miscArmorMod;

    // Saving Throws
    protected int fortitude;
    protected int will;
    protected int reflex;

    // Attack
    protected int BAB;
    protected int CMB;
    protected int CMD;

    // Skills
    protected int acrobatics;
    protected int appraise;
    protected int bluff;
    protected int climb;
    protected int craft;
    protected int diplomacy;
    protected int disableDevice;
    protected int disguise;
    protected int escapeArtist;
    protected int fly;
    protected int handleAnimal;
    protected int heal;
    protected int intimidate;
    protected int knowledgeArcana;
    protected int knowledgeDungeoneering;
    protected int knowledgeEngineering;
    protected int knowledgeGeography;
    protected int knowledgeHistory;
    protected int knowledgeLocal;
    protected int knowledgeNature;
    protected int knowledgeNobility;
    protected int knowledgePlanes;
    protected int knowledgeReligion;
    protected int linguistics;
    protected int perception;
    protected int perform;
    protected int profession;
    protected int ride;
    protected int senseMotive;
    protected int sleightOfHand;
    protected int spellcraft;
    protected int stealth;
    protected int survival;
    protected int swim;
    protected int useMagicDevice;

    // Skill Ranks
    protected int acrobaticsRank;
    protected int appraiseRank;
    protected int bluffRank;
    protected int climbRank;
    protected int craftRank;
    protected int diplomacyRank;
    protected int disableDeviceRank;
    protected int disguiseRank;
    protected int escapeArtistRank;
    protected int flyRank;
    protected int handleAnimalRank;
    protected int healRank;
    protected int intimidateRank;
    protected int knowledgeArcanaRank;
    protected int knowledgeDungeoneeringRank;
    protected int knowledgeEngineeringRank;
    protected int knowledgeGeographyRank;
    protected int knowledgeHistoryRank;
    protected int knowledgeLocalRank;
    protected int knowledgeNatureRank;
    protected int knowledgeNobilityRank;
    protected int knowledgePlanesRank;
    protected int knowledgeReligionRank;
    protected int linguisticsRank;
    protected int perceptionRank;
    protected int performRank;
    protected int professionRank;
    protected int rideRank;
    protected int senseMotiveRank;
    protected int sleightOfHandRank;
    protected int spellcraftRank;
    protected int stealthRank;
    protected int survivalRank;
    protected int swimRank;
    protected int useMagicDeviceRank;

    // Skill MiscMods
    protected int acrobaticsMiscMod;
    protected int appraiseMiscMod;
    protected int bluffMiscMod;
    protected int climbMiscMod;
    protected int craftMiscMod;
    protected int diplomacyMiscMod;
    protected int disableDeviceMiscMod;
    protected int disguiseMiscMod;
    protected int escapeArtistMiscMod;
    protected int flyMiscMod;
    protected int handleAnimalMiscMod;
    protected int healMiscMod;
    protected int intimidateMiscMod;
    protected int knowledgeArcanaMiscMod;
    protected int knowledgeDungeoneeringMiscMod;
    protected int knowledgeEngineeringMiscMod;
    protected int knowledgeGeographyMiscMod;
    protected int knowledgeHistoryMiscMod;
    protected int knowledgeLocalMiscMod;
    protected int knowledgeNatureMiscMod;
    protected int knowledgeNobilityMiscMod;
    protected int knowledgePlanesMiscMod;
    protected int knowledgeReligionMiscMod;
    protected int linguisticsMiscMod;
    protected int perceptionMiscMod;
    protected int performMiscMod;
    protected int professionMiscMod;
    protected int rideMiscMod;
    protected int senseMotiveMiscMod;
    protected int sleightOfHandMiscMod;
    protected int spellcraftMiscMod;
    protected int stealthMiscMod;
    protected int survivalMiscMod;
    protected int swimMiscMod;
    protected int useMagicDeviceMiscMod;

    public Creature() {
        // Skills
        acrobatics = dexMod + acrobaticsRank + acrobaticsMiscMod;
        appraise = intMod + appraiseRank + appraiseMiscMod;
        bluff = chaMod + bluffRank + bluffMiscMod;
        climb = strMod + climbRank + climbMiscMod;
        craft = intMod + craftRank + craftMiscMod;
        diplomacy = chaMod + diplomacyRank + diplomacyMiscMod;
        if (disableDeviceRank > 0) {
            disableDevice = dexMod + disableDeviceRank + disableDeviceMiscMod;
        } else {
            disableDevice = 0;
        }
        disguise = chaMod + disguiseRank + disguiseMiscMod;
        escapeArtist = dexMod + escapeArtistRank + escapeArtistMiscMod;
        fly = dexMod + flyRank + flyMiscMod;
        if (handleAnimalRank > 0) {
            handleAnimal = chaMod + handleAnimalRank + handleAnimalMiscMod;
        } else {
            handleAnimal = 0;
        }
        heal = wisMod + healRank + healMiscMod;
        intimidate = chaMod + intimidateRank + intimidateMiscMod;
        if (knowledgeArcanaRank > 0) {
            knowledgeArcana = intMod + knowledgeArcanaRank + knowledgeArcanaMiscMod;

        } else {
            knowledgeArcana = 0;
        }
        if (knowledgeDungeoneeringRank > 0) {
            knowledgeDungeoneering = intMod + knowledgeDungeoneeringRank + knowledgeDungeoneeringMiscMod;

        } else {
            knowledgeDungeoneering = 0;
        }
        if (knowledgeEngineeringRank > 0) {
            knowledgeEngineering = intMod + knowledgeEngineeringRank + knowledgeEngineeringMiscMod;

        } else {
            knowledgeEngineering = 0;
        }
        if (knowledgeGeographyRank > 0) {
            knowledgeGeography = intMod + knowledgeGeographyRank + knowledgeGeographyMiscMod;
        } else {
            knowledgeGeography = 0;
        }
        if (knowledgeHistoryRank > 0) {
            knowledgeHistory = intMod + knowledgeHistoryRank + knowledgeHistoryMiscMod;
        } else {
            knowledgeHistory = 0;
        }
        if (knowledgeLocalRank > 0) {
            knowledgeLocal = intMod + knowledgeLocalRank + knowledgeLocalMiscMod;
        } else {
            knowledgeLocal = 0;
        }
        if (knowledgeNatureRank > 0) {
            knowledgeNature = intMod + knowledgeNatureRank + knowledgeNatureMiscMod;
        } else {
            knowledgeNature = 0;
        }
        if (knowledgeNobilityRank > 0) {
            knowledgeNobility = intMod + knowledgeNobilityRank + knowledgeNobilityMiscMod;
        } else {
            knowledgeNobility = 0;
        }
        if (knowledgePlanesRank > 0) {
            knowledgePlanes = intMod + knowledgePlanesRank + knowledgePlanesMiscMod;
        } else {
            knowledgePlanes = 0;
        }
        if (knowledgeReligionRank > 0) {
            knowledgeReligion = intMod + knowledgeReligionRank + knowledgeReligionMiscMod;
        } else {
            knowledgeReligion = 0;
        }
        linguistics = intMod + linguisticsRank + linguisticsMiscMod;
        perception = wisMod + perceptionRank + perceptionMiscMod;
        perform = chaMod + performRank + performMiscMod;
        if (professionRank > 0) {
            profession = wisMod + professionRank + professionMiscMod;
        } else {
            profession = 0;
        }
        ride = dexMod + rideRank + rideMiscMod;
        senseMotive = wisMod + senseMotiveRank + senseMotiveMiscMod;
        if (sleightOfHandRank > 0) {
            sleightOfHand = dexMod + sleightOfHandRank + sleightOfHandMiscMod;
        } else {
            sleightOfHand = 0;
        }
        if (spellcraftRank > 0) {
            spellcraft = intMod + spellcraftRank + spellcraftMiscMod;
        } else {
            spellcraft = 0;
        }
        stealth = dexMod + stealthRank + stealthMiscMod;
        survival = wisMod + survivalRank + survivalMiscMod;
        swim = strMod + swimRank + swimMiscMod;
        if (useMagicDeviceRank > 0) {
            useMagicDevice = chaMod + useMagicDeviceRank + useMagicDeviceMiscMod;
        } else {
            useMagicDevice = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Array<GameClass> getClasses() {
        return classes;
    }

    public void setClasses(Array<GameClass> classes) {
        this.classes = classes;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getMiscInitMod() {
        return miscInitMod;
    }

    public void setMiscInitMod(int miscInitMod) {
        this.miscInitMod = miscInitMod;
    }

    public int getMoveActions() {
        return moveActions;
    }

    public void setMoveActions(int moveActions) {
        this.moveActions = moveActions;
    }

    public int getAttackActions() {
        return attackActions;
    }

    public void setAttackActions(int attackActions) {
        this.attackActions = attackActions;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getChaMod() {
        return chaMod;
    }

    public void setChaMod(int chaMod) {
        this.chaMod = chaMod;
    }

    public int getStrMod() {
        return strMod;
    }

    public void setStrMod(int strMod) {
        this.strMod = strMod;
    }

    public int getDexMod() {
        return dexMod;
    }

    public void setDexMod(int dexMod) {
        this.dexMod = dexMod;
    }

    public int getConMod() {
        return conMod;
    }

    public void setConMod(int conMod) {
        this.conMod = conMod;
    }

    public int getIntMod() {
        return intMod;
    }

    public void setIntMod(int intMod) {
        this.intMod = intMod;
    }

    public int getWisMod() {
        return wisMod;
    }

    public void setWisMod(int wisMod) {
        this.wisMod = wisMod;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public int getACTouch() {
        return ACTouch;
    }

    public void setACTouch(int ACTouch) {
        this.ACTouch = ACTouch;
    }

    public int getACFlatFooted() {
        return ACFlatFooted;
    }

    public void setACFlatFooted(int ACFlatFooted) {
        this.ACFlatFooted = ACFlatFooted;
    }

    public int getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(int armorBonus) {
        this.armorBonus = armorBonus;
    }

    public int getShieldBonus() {
        return shieldBonus;
    }

    public void setShieldBonus(int shieldBonus) {
        this.shieldBonus = shieldBonus;
    }

    public int getSizeMod() {
        return sizeMod;
    }

    public void setSizeMod(int sizeMod) {
        this.sizeMod = sizeMod;
    }

    public int getNaturalArmor() {
        return naturalArmor;
    }

    public void setNaturalArmor(int naturalArmor) {
        this.naturalArmor = naturalArmor;
    }

    public int getDeflectionMod() {
        return deflectionMod;
    }

    public void setDeflectionMod(int deflectionMod) {
        this.deflectionMod = deflectionMod;
    }

    public int getMiscArmorMod() {
        return miscArmorMod;
    }

    public void setMiscArmorMod(int miscArmorMod) {
        this.miscArmorMod = miscArmorMod;
    }

    public int getFortitude() {
        return fortitude;
    }

    public void setFortitude(int fortitude) {
        this.fortitude = fortitude;
    }

    public int getWill() {
        return will;
    }

    public void setWill(int will) {
        this.will = will;
    }

    public int getReflex() {
        return reflex;
    }

    public void setReflex(int reflex) {
        this.reflex = reflex;
    }

    public int getBAB() {
        return BAB;
    }

    public void setBAB(int BAB) {
        this.BAB = BAB;
    }

    public int getCMB() {
        return CMB;
    }

    public void setCMB(int CMB) {
        this.CMB = CMB;
    }

    public int getCMD() {
        return CMD;
    }

    public void setCMD(int CMD) {
        this.CMD = CMD;
    }

    public int getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(int acrobatics) {
        this.acrobatics = acrobatics;
    }

    public int getAppraise() {
        return appraise;
    }

    public void setAppraise(int appraise) {
        this.appraise = appraise;
    }

    public int getBluff() {
        return bluff;
    }

    public void setBluff(int bluff) {
        this.bluff = bluff;
    }

    public int getClimb() {
        return climb;
    }

    public void setClimb(int climb) {
        this.climb = climb;
    }

    public int getCraft() {
        return craft;
    }

    public void setCraft(int craft) {
        this.craft = craft;
    }

    public int getDiplomacy() {
        return diplomacy;
    }

    public void setDiplomacy(int diplomacy) {
        this.diplomacy = diplomacy;
    }

    public int getDisableDevice() {
        return disableDevice;
    }

    public void setDisableDevice(int disableDevice) {
        this.disableDevice = disableDevice;
    }

    public int getDisguise() {
        return disguise;
    }

    public void setDisguise(int disguise) {
        this.disguise = disguise;
    }

    public int getEscapeArtist() {
        return escapeArtist;
    }

    public void setEscapeArtist(int escapeArtist) {
        this.escapeArtist = escapeArtist;
    }

    public int getFly() {
        return fly;
    }

    public void setFly(int fly) {
        this.fly = fly;
    }

    public int getHandleAnimal() {
        return handleAnimal;
    }

    public void setHandleAnimal(int handleAnimal) {
        this.handleAnimal = handleAnimal;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getIntimidate() {
        return intimidate;
    }

    public void setIntimidate(int intimidate) {
        this.intimidate = intimidate;
    }

    public int getKnowledgeArcana() {
        return knowledgeArcana;
    }

    public void setKnowledgeArcana(int knowledgeArcana) {
        this.knowledgeArcana = knowledgeArcana;
    }

    public int getKnowledgeDungeoneering() {
        return knowledgeDungeoneering;
    }

    public void setKnowledgeDungeoneering(int knowledgeDungeoneering) {
        this.knowledgeDungeoneering = knowledgeDungeoneering;
    }

    public int getKnowledgeEngineering() {
        return knowledgeEngineering;
    }

    public void setKnowledgeEngineering(int knowledgeEngineering) {
        this.knowledgeEngineering = knowledgeEngineering;
    }

    public int getKnowledgeGeography() {
        return knowledgeGeography;
    }

    public void setKnowledgeGeography(int knowledgeGeography) {
        this.knowledgeGeography = knowledgeGeography;
    }

    public int getKnowledgeHistory() {
        return knowledgeHistory;
    }

    public void setKnowledgeHistory(int knowledgeHistory) {
        this.knowledgeHistory = knowledgeHistory;
    }

    public int getKnowledgeLocal() {
        return knowledgeLocal;
    }

    public void setKnowledgeLocal(int knowledgeLocal) {
        this.knowledgeLocal = knowledgeLocal;
    }

    public int getKnowledgeNature() {
        return knowledgeNature;
    }

    public void setKnowledgeNature(int knowledgeNature) {
        this.knowledgeNature = knowledgeNature;
    }

    public int getKnowledgeNobility() {
        return knowledgeNobility;
    }

    public void setKnowledgeNobility(int knowledgeNobility) {
        this.knowledgeNobility = knowledgeNobility;
    }

    public int getKnowledgePlanes() {
        return knowledgePlanes;
    }

    public void setKnowledgePlanes(int knowledgePlanes) {
        this.knowledgePlanes = knowledgePlanes;
    }

    public int getKnowledgeReligion() {
        return knowledgeReligion;
    }

    public void setKnowledgeReligion(int knowledgeReligion) {
        this.knowledgeReligion = knowledgeReligion;
    }

    public int getLinguistics() {
        return linguistics;
    }

    public void setLinguistics(int linguistics) {
        this.linguistics = linguistics;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getPerform() {
        return perform;
    }

    public void setPerform(int perform) {
        this.perform = perform;
    }

    public int getProfession() {
        return profession;
    }

    public void setProfession(int profession) {
        this.profession = profession;
    }

    public int getRide() {
        return ride;
    }

    public void setRide(int ride) {
        this.ride = ride;
    }

    public int getSenseMotive() {
        return senseMotive;
    }

    public void setSenseMotive(int senseMotive) {
        this.senseMotive = senseMotive;
    }

    public int getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(int sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    public int getSpellcraft() {
        return spellcraft;
    }

    public void setSpellcraft(int spellcraft) {
        this.spellcraft = spellcraft;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getSurvival() {
        return survival;
    }

    public void setSurvival(int survival) {
        this.survival = survival;
    }

    public int getSwim() {
        return swim;
    }

    public void setSwim(int swim) {
        this.swim = swim;
    }

    public int getUseMagicDevice() {
        return useMagicDevice;
    }

    public void setUseMagicDevice(int useMagicDevice) {
        this.useMagicDevice = useMagicDevice;
    }      public int getAcrobaticsRank() {
        return acrobaticsRank;
    }

    public void setAcrobaticsRank(int acrobaticsRank) {
        this.acrobaticsRank = acrobaticsRank;
    }

    public int getAppraiseRank() {
        return appraiseRank;
    }

    public void setAppraiseRank(int appraiseRank) {
        this.appraiseRank = appraiseRank;
    }

    public int getBluffRank() {
        return bluffRank;
    }

    public void setBluffRank(int bluffRank) {
        this.bluffRank = bluffRank;
    }

    public int getClimbRank() {
        return climbRank;
    }

    public void setClimbRank(int climbRank) {
        this.climbRank = climbRank;
    }

    public int getCraftRank() {
        return craftRank;
    }

    public void setCraftRank(int craftRank) {
        this.craftRank = craftRank;
    }

    public int getDiplomacyRank() {
        return diplomacyRank;
    }

    public void setDiplomacyRank(int diplomacyRank) {
        this.diplomacyRank = diplomacyRank;
    }

    public int getDisableDeviceRank() {
        return disableDeviceRank;
    }

    public void setDisableDeviceRank(int disableDeviceRank) {
        this.disableDeviceRank = disableDeviceRank;
    }

    public int getDisguiseRank() {
        return disguiseRank;
    }

    public void setDisguiseRank(int disguiseRank) {
        this.disguiseRank = disguiseRank;
    }

    public int getEscapeArtistRank() {
        return escapeArtistRank;
    }

    public void setEscapeArtistRank(int escapeArtistRank) {
        this.escapeArtistRank = escapeArtistRank;
    }

    public int getFlyRank() {
        return flyRank;
    }

    public void setFlyRank(int flyRank) {
        this.flyRank = flyRank;
    }

    public int getHandleAnimalRank() {
        return handleAnimalRank;
    }

    public void setHandleAnimalRank(int handleAnimalRank) {
        this.handleAnimalRank = handleAnimalRank;
    }

    public int getHealRank() {
        return healRank;
    }

    public void setHealRank(int healRank) {
        this.healRank = healRank;
    }

    public int getIntimidateRank() {
        return intimidateRank;
    }

    public void setIntimidateRank(int intimidateRank) {
        this.intimidateRank = intimidateRank;
    }

    public int getKnowledgeArcanaRank() {
        return knowledgeArcanaRank;
    }

    public void setKnowledgeArcanaRank(int knowledgeArcanaRank) {
        this.knowledgeArcanaRank = knowledgeArcanaRank;
    }

    public int getKnowledgeDungeoneeringRank() {
        return knowledgeDungeoneeringRank;
    }

    public void setKnowledgeDungeoneeringRank(int knowledgeDungeoneeringRank) {
        this.knowledgeDungeoneeringRank = knowledgeDungeoneeringRank;
    }

    public int getKnowledgeEngineeringRank() {
        return knowledgeEngineeringRank;
    }

    public void setKnowledgeEngineeringRank(int knowledgeEngineeringRank) {
        this.knowledgeEngineeringRank = knowledgeEngineeringRank;
    }

    public int getKnowledgeGeographyRank() {
        return knowledgeGeographyRank;
    }

    public void setKnowledgeGeographyRank(int knowledgeGeographyRank) {
        this.knowledgeGeographyRank = knowledgeGeographyRank;
    }

    public int getKnowledgeHistoryRank() {
        return knowledgeHistoryRank;
    }

    public void setKnowledgeHistoryRank(int knowledgeHistoryRank) {
        this.knowledgeHistoryRank = knowledgeHistoryRank;
    }

    public int getKnowledgeLocalRank() {
        return knowledgeLocalRank;
    }

    public void setKnowledgeLocalRank(int knowledgeLocalRank) {
        this.knowledgeLocalRank = knowledgeLocalRank;
    }

    public int getKnowledgeNatureRank() {
        return knowledgeNatureRank;
    }

    public void setKnowledgeNatureRank(int knowledgeNatureRank) {
        this.knowledgeNatureRank = knowledgeNatureRank;
    }

    public int getKnowledgeNobilityRank() {
        return knowledgeNobilityRank;
    }

    public void setKnowledgeNobilityRank(int knowledgeNobilityRank) {
        this.knowledgeNobilityRank = knowledgeNobilityRank;
    }

    public int getKnowledgePlanesRank() {
        return knowledgePlanesRank;
    }

    public void setKnowledgePlanesRank(int knowledgePlanesRank) {
        this.knowledgePlanesRank = knowledgePlanesRank;
    }

    public int getKnowledgeReligionRank() {
        return knowledgeReligionRank;
    }

    public void setKnowledgeReligionRank(int knowledgeReligionRank) {
        this.knowledgeReligionRank = knowledgeReligionRank;
    }

    public int getLinguisticsRank() {
        return linguisticsRank;
    }

    public void setLinguisticsRank(int linguisticsRank) {
        this.linguisticsRank = linguisticsRank;
    }

    public int getPerceptionRank() {
        return perceptionRank;
    }

    public void setPerceptionRank(int perceptionRank) {
        this.perceptionRank = perceptionRank;
    }

    public int getPerformRank() {
        return performRank;
    }

    public void setPerformRank(int performRank) {
        this.performRank = performRank;
    }

    public int getProfessionRank() {
        return professionRank;
    }

    public void setProfessionRank(int professionRank) {
        this.professionRank = professionRank;
    }

    public int getRideRank() {
        return rideRank;
    }

    public void setRideRank(int rideRank) {
        this.rideRank = rideRank;
    }

    public int getSenseMotiveRank() {
        return senseMotiveRank;
    }

    public void setSenseMotiveRank(int senseMotiveRank) {
        this.senseMotiveRank = senseMotiveRank;
    }

    public int getSleightOfHandRank() {
        return sleightOfHandRank;
    }

    public void setSleightOfHandRank(int sleightOfHandRank) {
        this.sleightOfHandRank = sleightOfHandRank;
    }

    public int getSpellcraftRank() {
        return spellcraftRank;
    }

    public void setSpellcraftRank(int spellcraftRank) {
        this.spellcraftRank = spellcraftRank;
    }

    public int getStealthRank() {
        return stealthRank;
    }

    public void setStealthRank(int stealthRank) {
        this.stealthRank = stealthRank;
    }

    public int getSurvivalRank() {
        return survivalRank;
    }

    public void setSurvivalRank(int survivalRank) {
        this.survivalRank = survivalRank;
    }

    public int getSwimRank() {
        return swimRank;
    }

    public void setSwimRank(int swimRank) {
        this.swimRank = swimRank;
    }

    public int getUseMagicDeviceRank() {
        return useMagicDeviceRank;
    }

    public void setUseMagicDeviceRank(int useMagicDeviceRank) {
        this.useMagicDeviceRank = useMagicDeviceRank;
    }

    public int getAcrobaticsMiscMod() {
        return acrobaticsMiscMod;
    }

    public void setAcrobaticsMiscMod(int acrobaticsMiscMod) {
        this.acrobaticsMiscMod = acrobaticsMiscMod;
    }

    public int getAppraiseMiscMod() {
        return appraiseMiscMod;
    }

    public void setAppraiseMiscMod(int appraiseMiscMod) {
        this.appraiseMiscMod = appraiseMiscMod;
    }

    public int getBluffMiscMod() {
        return bluffMiscMod;
    }

    public void setBluffMiscMod(int bluffMiscMod) {
        this.bluffMiscMod = bluffMiscMod;
    }

    public int getClimbMiscMod() {
        return climbMiscMod;
    }

    public void setClimbMiscMod(int climbMiscMod) {
        this.climbMiscMod = climbMiscMod;
    }

    public int getCraftMiscMod() {
        return craftMiscMod;
    }

    public void setCraftMiscMod(int craftMiscMod) {
        this.craftMiscMod = craftMiscMod;
    }

    public int getDiplomacyMiscMod() {
        return diplomacyMiscMod;
    }

    public void setDiplomacyMiscMod(int diplomacyMiscMod) {
        this.diplomacyMiscMod = diplomacyMiscMod;
    }

    public int getDisableDeviceMiscMod() {
        return disableDeviceMiscMod;
    }

    public void setDisableDeviceMiscMod(int disableDeviceMiscMod) {
        this.disableDeviceMiscMod = disableDeviceMiscMod;
    }

    public int getDisguiseMiscMod() {
        return disguiseMiscMod;
    }

    public void setDisguiseMiscMod(int disguiseMiscMod) {
        this.disguiseMiscMod = disguiseMiscMod;
    }

    public int getEscapeArtistMiscMod() {
        return escapeArtistMiscMod;
    }

    public void setEscapeArtistMiscMod(int escapeArtistMiscMod) {
        this.escapeArtistMiscMod = escapeArtistMiscMod;
    }

    public int getFlyMiscMod() {
        return flyMiscMod;
    }

    public void setFlyMiscMod(int flyMiscMod) {
        this.flyMiscMod = flyMiscMod;
    }

    public int getHandleAnimalMiscMod() {
        return handleAnimalMiscMod;
    }

    public void setHandleAnimalMiscMod(int handleAnimalMiscMod) {
        this.handleAnimalMiscMod = handleAnimalMiscMod;
    }

    public int getHealMiscMod() {
        return healMiscMod;
    }

    public void setHealMiscMod(int healMiscMod) {
        this.healMiscMod = healMiscMod;
    }

    public int getIntimidateMiscMod() {
        return intimidateMiscMod;
    }

    public void setIntimidateMiscMod(int intimidateMiscMod) {
        this.intimidateMiscMod = intimidateMiscMod;
    }

    public int getKnowledgeArcanaMiscMod() {
        return knowledgeArcanaMiscMod;
    }

    public void setKnowledgeArcanaMiscMod(int knowledgeArcanaMiscMod) {
        this.knowledgeArcanaMiscMod = knowledgeArcanaMiscMod;
    }

    public int getKnowledgeDungeoneeringMiscMod() {
        return knowledgeDungeoneeringMiscMod;
    }

    public void setKnowledgeDungeoneeringMiscMod(int knowledgeDungeoneeringMiscMod) {
        this.knowledgeDungeoneeringMiscMod = knowledgeDungeoneeringMiscMod;
    }

    public int getKnowledgeEngineeringMiscMod() {
        return knowledgeEngineeringMiscMod;
    }

    public void setKnowledgeEngineeringMiscMod(int knowledgeEngineeringMiscMod) {
        this.knowledgeEngineeringMiscMod = knowledgeEngineeringMiscMod;
    }

    public int getKnowledgeGeographyMiscMod() {
        return knowledgeGeographyMiscMod;
    }

    public void setKnowledgeGeographyMiscMod(int knowledgeGeographyMiscMod) {
        this.knowledgeGeographyMiscMod = knowledgeGeographyMiscMod;
    }

    public int getKnowledgeHistoryMiscMod() {
        return knowledgeHistoryMiscMod;
    }

    public void setKnowledgeHistoryMiscMod(int knowledgeHistoryMiscMod) {
        this.knowledgeHistoryMiscMod = knowledgeHistoryMiscMod;
    }

    public int getKnowledgeLocalMiscMod() {
        return knowledgeLocalMiscMod;
    }

    public void setKnowledgeLocalMiscMod(int knowledgeLocalMiscMod) {
        this.knowledgeLocalMiscMod = knowledgeLocalMiscMod;
    }

    public int getKnowledgeNatureMiscMod() {
        return knowledgeNatureMiscMod;
    }

    public void setKnowledgeNatureMiscMod(int knowledgeNatureMiscMod) {
        this.knowledgeNatureMiscMod = knowledgeNatureMiscMod;
    }

    public int getKnowledgeNobilityMiscMod() {
        return knowledgeNobilityMiscMod;
    }

    public void setKnowledgeNobilityMiscMod(int knowledgeNobilityMiscMod) {
        this.knowledgeNobilityMiscMod = knowledgeNobilityMiscMod;
    }

    public int getKnowledgePlanesMiscMod() {
        return knowledgePlanesMiscMod;
    }

    public void setKnowledgePlanesMiscMod(int knowledgePlanesMiscMod) {
        this.knowledgePlanesMiscMod = knowledgePlanesMiscMod;
    }

    public int getKnowledgeReligionMiscMod() {
        return knowledgeReligionMiscMod;
    }

    public void setKnowledgeReligionMiscMod(int knowledgeReligionMiscMod) {
        this.knowledgeReligionMiscMod = knowledgeReligionMiscMod;
    }

    public int getLinguisticsMiscMod() {
        return linguisticsMiscMod;
    }

    public void setLinguisticsMiscMod(int linguisticsMiscMod) {
        this.linguisticsMiscMod = linguisticsMiscMod;
    }

    public int getPerceptionMiscMod() {
        return perceptionMiscMod;
    }

    public void setPerceptionMiscMod(int perceptionMiscMod) {
        this.perceptionMiscMod = perceptionMiscMod;
    }

    public int getPerformMiscMod() {
        return performMiscMod;
    }

    public void setPerformMiscMod(int performMiscMod) {
        this.performMiscMod = performMiscMod;
    }

    public int getProfessionMiscMod() {
        return professionMiscMod;
    }

    public void setProfessionMiscMod(int professionMiscMod) {
        this.professionMiscMod = professionMiscMod;
    }

    public int getRideMiscMod() {
        return rideMiscMod;
    }

    public void setRideMiscMod(int rideMiscMod) {
        this.rideMiscMod = rideMiscMod;
    }

    public int getSenseMotiveMiscMod() {
        return senseMotiveMiscMod;
    }

    public void setSenseMotiveMiscMod(int senseMotiveMiscMod) {
        this.senseMotiveMiscMod = senseMotiveMiscMod;
    }

    public int getSleightOfHandMiscMod() {
        return sleightOfHandMiscMod;
    }

    public void setSleightOfHandMiscMod(int sleightOfHandMiscMod) {
        this.sleightOfHandMiscMod = sleightOfHandMiscMod;
    }

    public int getSpellcraftMiscMod() {
        return spellcraftMiscMod;
    }

    public void setSpellcraftMiscMod(int spellcraftMiscMod) {
        this.spellcraftMiscMod = spellcraftMiscMod;
    }

    public int getStealthMiscMod() {
        return stealthMiscMod;
    }

    public void setStealthMiscMod(int stealthMiscMod) {
        this.stealthMiscMod = stealthMiscMod;
    }

    public int getSurvivalMiscMod() {
        return survivalMiscMod;
    }

    public void setSurvivalMiscMod(int survivalMiscMod) {
        this.survivalMiscMod = survivalMiscMod;
    }

    public int getSwimMiscMod() {
        return swimMiscMod;
    }

    public void setSwimMiscMod(int swimMiscMod) {
        this.swimMiscMod = swimMiscMod;
    }

    public int getUseMagicDeviceMiscMod() {
        return useMagicDeviceMiscMod;
    }

    public void setUseMagicDeviceMiscMod(int useMagicDeviceMiscMod) {
        this.useMagicDeviceMiscMod = useMagicDeviceMiscMod;
    }
}
