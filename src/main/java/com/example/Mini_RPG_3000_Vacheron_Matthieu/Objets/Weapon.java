package com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets;

public class Weapon extends Item {
   private int capacity;

   public int getCapacity() {
      return capacity;
   }

   public Weapon(String nomWeapon, int weaponCapacity){
      this.capacity = weaponCapacity;
      this.nom = nomWeapon;
   }
}
