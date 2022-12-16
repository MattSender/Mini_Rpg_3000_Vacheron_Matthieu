//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages;

import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Food;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Potion;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Weapon;

//----------------------- Création de la classe Mage contenants ses propres variables -----------------------//
public class Mage extends SpellCaster {
    public Mage(String name, int lifePoints, Team team){
        this.name = name;
        this.heroType = HeroType.MAGE;
        this.team = team;
        this.team.ajoutCombatant(this);

        this.lifePoints = lifePoints;
        this.maxLifePoints = 100;

        this.weapon = new Weapon("Baguette",8);

        this.addConsumable(new Food("◇──◇  [-1-]  -  \uD83C\uDF72 Potage de fougère saupoudré de lamelles de fromage  ◇──◇", 15));
        this.addConsumable(new Food("◇──◇  [-2-]  -  \uD83E\uDD6B Ca se mange, je crois  ◇──◇", 5));
        this.addConsumable(new Potion("◇──◇  [-3-]  -  \uD83E\uDDC9 Le biberon qui fait plez  ◇──◇", 30));
        this.addConsumable(new Potion("◇──◇  [-4-]  -  \uD83C\uDF79 GlouGlou Tropical  ◇──◇", 40));

        this.maxMana = 100;
        this.depenseMana = 10;
        this.msgAlerte = ("Oh non, ton \uD83E\uDE84 Mage Noir n'a plus de mana, il ne peut pas attaquer, fait quelque chose a l'aide, on est perdu !");

        this.force = 1;
        this.defence = 0.4f;
    }

    @Override
    public boolean attack(Combatant ennemi) {
        int damage = this.force*this.weapon.getCapacity();

        if(this.getMana()>=this.depenseMana){
            ennemi.setLifePoints(ennemi.getLifePoints()-damage);
            this.setMana(this.getMana()-this.depenseMana);

            if(ennemi.getLifePoints()<=0){
                ennemi.setVivant(false);
            }
            return true;

        }else {
            return false;
        }
    }
}
