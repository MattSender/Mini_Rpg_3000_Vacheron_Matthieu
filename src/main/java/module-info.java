module com.example.rpgfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires emoji.java;
    opens com.example.Mini_RPG_3000_Vacheron_Matthieu to javafx.fxml;
    exports com.example.Mini_RPG_3000_Vacheron_Matthieu;
    exports com.example.Mini_RPG_3000_Vacheron_Matthieu.Utils;
    opens com.example.Mini_RPG_3000_Vacheron_Matthieu.Utils to javafx.fxml;
    exports com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages;
    opens com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages to javafx.fxml;
}