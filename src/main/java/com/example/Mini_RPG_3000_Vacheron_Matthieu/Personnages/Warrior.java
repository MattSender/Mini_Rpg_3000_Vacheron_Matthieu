//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages;

import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Food;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Potion;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Weapon;

//----------------------- Création de la classe Warrior contenants ses propres variables -----------------------//
public class Warrior extends Hero {
    public Warrior(String name, int lifePoints, Team team) {
        this.name = name;
        this.heroType = HeroType.WARRIOR;
        this.team = team;
        this.team.ajoutCombatant(this);

        this.lifePoints = lifePoints;
        this.maxLifePoints = 100;

        this.weapon = new Weapon("Katana Japonais", 10);

        this.addConsumable(new Food("◇──◇  [-1-]  -  \uD83C\uDF72 Potage de fougère saupoudré de lamelles de fromage  ◇──◇", 15));
        this.addConsumable(new Food("◇──◇  [-2-]  -  \uD83E\uDD6B Ca se mange, je crois  ◇──◇", 5));
        this.addConsumable(new Potion("◇──◇  [-3-]  -  \uD83E\uDDC9 Le biberon qui fait plez  ◇──◇", 30));
        this.addConsumable(new Potion("◇──◇  [-4-]  -  \uD83C\uDF79 GlouGlou Tropical  ◇──◇", 40));


        this.maxMana = 100;

        this.force = 2;
        this.defence = 0.8f;
    }

    @Override
    public boolean attack(Combatant ennemi) {
        int damage = (int)(this.weapon.getCapacity()*this.force*ennemi.getDefence());

        ennemi.setLifePoints(ennemi.getLifePoints()-damage);

        if(ennemi.getLifePoints()<=0){
            ennemi.setVivant(false);
        }
        return true;
    }

}
