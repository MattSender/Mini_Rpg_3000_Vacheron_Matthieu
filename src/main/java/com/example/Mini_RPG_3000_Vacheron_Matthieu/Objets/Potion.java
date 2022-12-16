package com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages.Hero;

public class Potion extends Consumable {

    @Override
    public void Use(Hero hero) {
        hero.setMana(hero.getMana() + this.HPRecup); //Ajouter le Mana due a la prise de potion

        if (hero.getMaxMana()<hero.getMana()){ //Si après la prise de la potion le mana est > au mana max, mettre le mana au max
            hero.setMana(hero.getMaxMana());
        }
        System.out.println("Regarde, " + hero.getName() +" t'écoute, il prend sa fameuse potion \uD83C\uDF44 de regeneration, " + this.nom + ", il gagne "+ this.HPRecup +
                "\uD83D\uDCAA de mana\n");
    }

    public Potion (String nom, int HPRecup) {
        this.HPRecup = HPRecup;
        this.nom = nom;
    }
}
