package com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets;

import com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages.Hero;

public abstract class Consumable extends Item {

    protected int HPRecup;

    public abstract void Use(Hero hero);
}
