//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages;

import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Weapon;

public class Enemy extends Combatant {

    public Enemy(String name, int lifePoints, Team team){
        this.name = name;
        this.team = team;
        this.team.ajoutCombatant(this);

        this.lifePoints = lifePoints;
        this.maxLifePoints = 100;

        this.weapon = new Weapon("Muscle et poing", 10);

        this.maxMana = 50;

        this.force = 1;
        this.defence = 0.6f;
}

    @Override
    public boolean attack(Combatant cible) {
        int damage = (int)(this.weapon.getCapacity()*this.force*cible.getDefence());
        cible.setLifePoints(cible.getLifePoints()-damage);

        if(cible.getLifePoints()<=0){
            cible.setVivant(false);
        }
        return true;
    }
}

