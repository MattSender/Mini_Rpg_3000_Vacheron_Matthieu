//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages;

import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Consumable;
import java.util.ArrayList;

public abstract class Hero extends Combatant {
    //-------------------- Annonce des Variables --------------------//
    protected HeroType heroType;
    protected ArrayList<Consumable> consumables = new ArrayList<Consumable>();

    protected String msgAlerte;


    //-------------------- Hero - Message d'alerte --------------------//
    public HeroType getHeroType() {
        return heroType;
    }

    public String getFailMessage() {
        return msgAlerte;
    }

    //-------------------- Consumable --------------------//
    public void addConsumable(Consumable c){
        this.consumables.add(c);
    }
    public ArrayList<Consumable> getConsumables() {
        return consumables;
    }
    public void useConsumable(Consumable c){
        c.Use(this);
        this.consumables.remove(c);
    }
}


