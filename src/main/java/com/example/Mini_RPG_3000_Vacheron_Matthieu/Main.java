//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

import com.example.Mini_RPG_3000_Vacheron_Matthieu.Utils.ConsoleParser;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages.Game;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Utils.InputParser;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
    }

//-------------------- Demarer la partie, en créant cette partie --------------------//
    public static void main(String[] args){
        Game game;
        game = new Game(); // Crée la partie

        InputParser inputParser = new ConsoleParser(game); // Genere la console pour jouer

        game.setInputParser(inputParser);
        game.start(); // Commencer la partie
    }

}