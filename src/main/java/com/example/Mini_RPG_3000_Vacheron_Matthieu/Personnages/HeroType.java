//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages;

public enum HeroType {
    //-------------------- Annonce des Variables --------------------//
    WARRIOR,
    HEALER,
    MAGE,
    HUNTER;

    //-------------------- La fonctions associée aux variables --------------------//
    public String toString() {
        if (this.equals(HeroType.WARRIOR)) {
            return "Warrior";
        }
        else if (this.equals(HeroType.HEALER)) {
            return "Healer";
        }
        else if (this.equals(HeroType.MAGE)) {
            return "Mage";
        }
        else if (this.equals(HeroType.HUNTER)) {
            return "Hunter";
        }
        return null;
    }
}
