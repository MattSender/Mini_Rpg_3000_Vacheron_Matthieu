//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages;

import java.util.ArrayList;

public class Team {
    //-------------------- Annonce des Variables --------------------//
    private String teamName;
    private ArrayList<Combatant> teamList;

    //-------------------- Les fonctions associées aux variables : get et set --------------------//
    public String getTeamName() {
        return teamName;
    }

    public Team(String teamName){
        this.teamList  = new ArrayList<Combatant>();
        this.teamName = teamName;
    }

    public ArrayList<Combatant> getTeamList() {
        return teamList;
    }

    public void ajoutCombatant(Combatant combatant){
        this.teamList.add(combatant);
    }

    public ArrayList<Combatant> listeVivant(){
        ArrayList<Combatant> liste = new ArrayList<Combatant>();
        for(Combatant c : this.teamList){
            if(c.vivant){
                liste.add(c);
            }
        }
        return liste;

    }
}
