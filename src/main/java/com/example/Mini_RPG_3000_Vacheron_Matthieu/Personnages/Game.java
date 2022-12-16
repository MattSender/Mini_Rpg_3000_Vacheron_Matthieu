//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages;

import com.example.Mini_RPG_3000_Vacheron_Matthieu.Utils.InputParser;


import java.util.ArrayList;

public class Game {
    //-------------------- Annonce des Variables --------------------//
    private InputParser inputParser;

    private int cbHeros;
    private Team herosTeam;
    private Team targetTeam;

    private int level = 1;

    private Combatant combattantActuel;
    private ArrayList<Combatant> ordreTour = new ArrayList<Combatant>();

    //-------------------- Les fonctions associées aux variables --------------------//
    public void start(){
        this.inputParser.presentation();
    }


    public void setInputParser(InputParser inputParser) {
        this.inputParser = inputParser;
    }


    public Game(){
        this.targetTeam = new Team("Equipe Monstre");
    }


    public void createTeam(String nomTeam){
        this.herosTeam = new Team(nomTeam);
        this.inputParser.nbHeros();
    }


    //-------------------- Heros --------------------//
    public  void boucleHeros(int actuel){
        if(actuel<=this.cbHeros){
            this.inputParser.herosActuel(actuel);
        }else {
            this.inputParser.yourTeam(herosTeam);
        }
    }  // Ne pas separer les deux fctn boucle et creatHeros
    public void createHeros(int nombre, String nom){
        if(nombre ==1){
            new Warrior(nom,100, this.herosTeam);
        }
        else if(nombre == 2){
            new Hunter(nom, 100, this.herosTeam);
        }
        else if(nombre == 3){
            new Mage(nom,100,this.herosTeam);

        }
        else if(nombre == 4){
            new Healer(nom, 100, this.herosTeam);
        }
        this.boucleHeros(this.herosTeam.getTeamList().size()+1);
    }

    public void setCbHeros(int cbHeros) {
        this.cbHeros = cbHeros;
    }
    public int getCbHeros() {
        return cbHeros;
    }

    public Combatant getCombattantActuel() {
        return combattantActuel;
    }

    public Team getHerosTeam() {
        return herosTeam;
    }

    public void obj(int input){
        Hero h = (Hero)this.combattantActuel;
        h.useConsumable(h.getConsumables().get(input-1));

        this.end();
    }


    //-------------------- Ennemies --------------------//
    public void createCible(int nombreHero){
        String[] listNom = {"Lions Affamés","Demons des Enfers","Frère Galiadus"};
        if(this.level!=3){
            for(int i = 0; i< nombreHero; i = i+1) {
                new Enemy(listNom[this.level - 1], 100, this.targetTeam);
            }
        }
        else {
            new Enemy(listNom[this.level-1],12*this.cbHeros,this.targetTeam);
        }
        this.inputParser.yourTeam(this.targetTeam);
    }

    public Team getCibleTeam() {
        return targetTeam;
    }


    //-------------------- Niveau --------------------//
    public int getLevel() {
        return level;
    }

    public void niveauSup(){
        this.level++;
        for(Combatant c : this.getHerosTeam().listeVivant()){
            c.setLifePoints(c.getMaxLifePoints());
            c.setMaxLifePoints(c.getMaxMana());
        }
        this.ordreTour = new ArrayList<Combatant>();
        this.targetTeam = new Team("Equipe de l'arene de Tekaliss");
        this.inputParser.Fin();
    }


    public void ordrePassage(){
        for(int i = 0; i<this.cbHeros; i=i+1){
            this.ordreTour.add(this.herosTeam.getTeamList().get(i));
            this.ordreTour.add(this.targetTeam.getTeamList().get(i));
        }
        this.nextCombattant();
        this.inputParser.annonceTour();
    }


    //-------------------- Combatant --------------------//
    public void attaque(Combatant cible){
        if(!this.combattantActuel.attack(cible)){
            this.inputParser.alerteMessage();
        }
        this.inputParser.Degats(cible);
    }

    public void end(){
        if(this.getHerosTeam().listeVivant().size()==0){
            this.lose();
        }
        else if(this.getCibleTeam().listeVivant().size()==0){

            if(this.level<3){
                this.niveauSup();
            }
            else {
                this.win();
            }
        }
        else {
            this.nextCombattant();
            this.inputParser.choixAction();
        }
    }

    public void nextCombattant(){
        int i = this.ordreTour.indexOf(this.combattantActuel);
        if(i+1==this.ordreTour.size()){
            i = 0;
        }
        else {
            i = i+1;
        }
        this.combattantActuel = this.ordreTour.get(i);
    }


    //-------------------- Fin de la partie --------------------//
    public void win(){
        this.inputParser.Gagne();
    }

    public void lose(){
        this.inputParser.Perdu();
    }
}

