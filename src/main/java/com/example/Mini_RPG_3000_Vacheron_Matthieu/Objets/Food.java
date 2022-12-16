package com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages.Hero;

public class Food extends Consumable {
    @Override
    public void Use(Hero hero) {
        hero.setLifePoints(hero.getLifePoints() + this.HPRecup); //Ajouter les pts de vie due a la prise de Food

        if (hero.getMaxLifePoints()<hero.getLifePoints()){ //Si après la prise de Food les pts de vie sont > au pts de vie max, mettre les pts de vie au max
            hero.setLifePoints(hero.getMaxLifePoints());
        }
        System.out.println("Vous :  " + hero.getName() + " Mannnnnge !!!!!");
        System.out.println("Regarde, il t'écoute, il a pris sa " + this.nom + " et récupere " + this.HPRecup + "\u2764 points de vie\n");
    }

    public Food(String nom, int valeurSoins){
        this.HPRecup = valeurSoins;
        this.nom = nom;
    }
}
