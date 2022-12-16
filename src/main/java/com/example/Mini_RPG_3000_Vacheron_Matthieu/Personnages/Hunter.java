//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages;

import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Food;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Potion;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Weapon;

//----------------------- Création de la classe Hunter contenants ses propres variables -----------------------//
public class Hunter extends Hero {
    private int munitions;
    public Hunter(String name, int lifePoints, Team team){
        this.name = name;
        this.heroType = HeroType.HUNTER;
        this.team = team;
        this.team.ajoutCombatant(this);

        this.lifePoints = lifePoints;
        this.maxLifePoints = 100;

        this.munitions = 10;
        this.weapon = new Weapon("Sarbacane",8);
        this.msgAlerte = ("Oh non, ton \u2744 Chasseur des neiges n'a plus de munition dans sa sarbacane, il ne peut pas attaquer, fait quelque chose a l'aide, on est perdu !");

        this.addConsumable(new Food("◇──◇  [-1-]  -  \uD83C\uDF72 Potage de fougère saupoudré de lamelles de fromage  ◇──◇", 15));
        this.addConsumable(new Food("◇──◇  [-2-]  -  \uD83E\uDD6B Ca se mange, je crois  ◇──◇", 5));
        this.addConsumable(new Potion("◇──◇  [-3-]  -  \uD83E\uDDC9 Le biberon qui fait plez  ◇──◇", 30));
        this.addConsumable(new Potion("◇──◇  [-4-]  -  \uD83C\uDF79 GlouGlou Tropical  ◇──◇", 40));


        this.maxMana = 100;

        this.force = 3;
        this.defence = 0.5f;
    }

    @Override
    public boolean attack(Combatant ennemi) {
        int damage = this.force*this.weapon.getCapacity() +10;

        if(this.munitions >0){
            ennemi.setLifePoints(ennemi.getLifePoints()- damage);

            if (ennemi.getLifePoints()<=0){
                ennemi.setVivant(false);
            }
            this.munitions--;
            return true;

        }else {
            return false;

        }


    }
}
