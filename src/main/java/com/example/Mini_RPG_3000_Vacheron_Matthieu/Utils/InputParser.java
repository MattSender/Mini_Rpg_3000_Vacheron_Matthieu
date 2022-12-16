//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu.Utils;

import com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages.Combatant;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages.Team;

public interface InputParser {
//-------------------- Premiere partie --------------------//
    void presentation();
    void nbHeros();
    void yourTeam(Team team);

//-------------------- Deuxieme partie --------------------//
    void annonceTour();
    void herosActuel(int nombreHero);
    void choixAction();
    void choixObjet();
    void choixEnnemie();

//-------------------- Troisième partie --------------------//
    void alerteMessage();
    void Degats(Combatant cible);

//-------------------- Dernière partie --------------------//
    void Fin();
    void Gagne();
    void Perdu();
}
