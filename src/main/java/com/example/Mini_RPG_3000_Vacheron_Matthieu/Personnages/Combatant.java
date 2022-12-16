//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages;

import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Weapon;

public abstract class Combatant {
    //-------------------- Annonce des Variables --------------------//
    protected String name;
    protected Team team;

    protected int lifePoints;
    protected int maxLifePoints;
    protected boolean vivant = true;

    protected Weapon weapon;

    protected int mana;
    protected int maxMana;

    protected int force;
    protected float defence;

    //-------------------- Les fonctions associées aux variables : get et set --------------------//
    public String getName() {
        return name;
    }


    public void setLifePoints(int newLifePoints) {
        this.lifePoints = newLifePoints;
    }
    public int getLifePoints() {
        return lifePoints;
    }


    public void setMaxLifePoints(int maxLifePoints) {
        this.maxLifePoints = maxLifePoints;
    }
    public int getMaxLifePoints() {
        return maxLifePoints;
    }


    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }
    public boolean isVivant() {
        return vivant;
    }


    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }


    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    public int getMaxMana() {
        return maxMana;
    }


    public abstract boolean attack(Combatant cible);


    public float getDefence() {
        return defence;
    }
}
