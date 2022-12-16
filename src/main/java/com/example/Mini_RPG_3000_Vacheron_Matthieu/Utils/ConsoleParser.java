//-------------------- Importations --------------------//
package com.example.Mini_RPG_3000_Vacheron_Matthieu.Utils;

import java.util.*;

import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Consumable;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Objets.Food;
import com.example.Mini_RPG_3000_Vacheron_Matthieu.Personnages.*;

public class ConsoleParser implements InputParser {
    public Scanner scanner;
    private Game game;

    public ConsoleParser(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    //-------------------- Aide au developpement --------------------//
    public static int nbValide(Scanner scanner) {
        String input = scanner.nextLine();
        while (!alerteNombres(input)) {
            System.out.println("\ud83d\udea8 Le chiffre que vous avez choisi n'est pas valide, selectionnez en un autre ! \ud83d\udea8");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    public static boolean alerteNombres(String input) {
        if (Objects.equals(input, "")) {
            return false;
        }

        List<Character> chiffre = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        char[] listInput = input.toCharArray();
        for (char c : listInput) {
            if (!chiffre.contains(c)) {
                return false;
            }
        }
        return true;
    }

    //-------------------- Premiere partie --------------------//
    @Override
    public void presentation() {
        System.out.println("★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★");
        System.out.println("Bonjour et bienvenue dans l'Arene de Tekaliss jeune combattant. ");
        System.out.println("Je suis Matthieu \ud83d\udc68, ton guide et ton serviteur pour toute la durée de ton séjour !");
        System.out.println("Celle-ci sera ta maison lors de ces prochains jours passés à combattre avec ton équipe de héros. ");
        System.out.println("Allez, viens, allons combattre !");
        System.out.println("Mais avant toute chose, je te laisse choisir le nom que tu souhaites donner à ton équipe : ");
        String nom = this.scanner.nextLine();
        this.game.createTeam(nom);

    }

    @Override
    public void nbHeros() {
        System.out.println("★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★");
        System.out.println("Parfait ! Maintenant, que tu possèdes une équipe au sein de Tekaliss, combien de héros désir-tu ?");
        System.out.println("\ud83c\udccf Ne t'inquiète pas, je te les donne, alors combien en veux-tu (pas plus de 5) ? \ud83c\udccf");

        int nombre = nbValide(this.scanner);
        while (nombre <= 0) {
            nombre = nbValide(this.scanner);
        }
        while (nombre > 5){
            System.out.println("Mon jeune ami, je veux bien t'aider et te prêter certains héros, mais n'abuse pas de ma gentillesse ! Prends en moins, allez, disons pas plus de 5.");
            nombre = nbValide(this.scanner);
        }
        this.game.setCbHeros(nombre);
        System.out.println("Oh Oh, tant que cela ? ");
        System.out.println("Et bien écoute, je te laisse choisir quel type de héros tu désir.");
        this.game.boucleHeros(1);
    }


    @Override
    public void herosActuel(int rang) {
        System.out.println("\nQue choisis tu en tant que " + rang + " héros ?");
        System.out.println("◇──◇  [-1-]  -  \u265E Chevalier  ◇──◇");
        System.out.println("◇──◇  [-2-]  -  \u2744 Chasseur des neiges  ◇──◇");
        System.out.println("◇──◇  [-3-]  -  \uD83E\uDE84 Mage Noir  ◇──◇");
        System.out.println("◇──◇  [-4-]  -  \u2695 Guérisseur  ◇──◇");
        int nombre = nbValide(this.scanner);
        if (nombre != 1 && nombre != 2 && nombre != 3 && nombre != 4) {
            System.out.println("\ud83d\udea8 Non, chère ami, tu ne peux pas choisir un héros qui n'existe pas ! \ud83d\udea8");
            nombre = nbValide(this.scanner);
        }
//Nom du héro que l'on choisit

        System.out.println("Comment souhaites-tu appeler ton nouveau héros ?");
        String nom = this.scanner.nextLine();
        System.out.println("Vite, qu'on amène un Mage Nommeur ! Nommé celui-ci " + nom);
        this.game.createHeros(nombre, nom);
    }

    @Override
    public void yourTeam(Team team) {
        System.out.println("\n★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★\n");

        if (team.getTeamList().size() > 0) {
            Combatant combatant0 = team.getTeamList().get(0);
            if (combatant0 instanceof Hero) {
                System.out.println("Tu as donc choisi mon jeune ami. Alors, laisse-moi te résumer qui compose ton équipe :\n");

                for (Combatant combatant : team.getTeamList()) {
                    Hero hero = (Hero) combatant;
                    System.out.println(hero.getName() + " est un " + hero.getHeroType().toString() + " qui possède " + hero.getLifePoints() + "\u2764 points de vie");
                }

                this.game.createCible(this.game.getCbHeros());

            } else {
                System.out.println("Tes ennemis sont très puissants mon jeune ami. Mais ne t'inquiète pas, je reste ici et veille à ce que tu restes en vie. ");
                System.out.println("Voici qui tu devras affronter lors de ce combat :\n");

                for (Combatant combatant : team.getTeamList())
                    System.out.println(combatant.getName() + " possède " + combatant.getLifePoints() + "\u2764 points de vie");

                System.out.println("\nBonne chance à toi et que la déesse Tekaliss soit avec toi ! ");
                this.game.ordrePassage();
            }
        }
    }

    //-------------------- Deuxieme partie --------------------//
    @Override
    public void annonceTour() {
        System.out.println("\n★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★\n");
        System.out.println("\uD83D\uDCE2 Cher Public, il est l'heure. L'arène ouvre ses portes, faites vos paris ! \uD83D\uDCE2");
        System.out.println("\uD83D\uDC4F Mesdames et messieurs, les matchs vont commencer à préparer vous a un combat EPIC ! \uD83D\uDC4F");
        System.out.println("\nC'est le tour de " + this.game.getCombattantActuel().getName());
        System.out.println("\n★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★\n");

        this.choixAction();
    }

    @Override
    public void choixAction() {
        if (this.game.getCombattantActuel() instanceof Hero) {
            System.out.println("Vite dépêche toi, dis à ton héros quoi faire ! \uD83D\uDE23");
            System.out.println("◇──◇  [-1-]  -  \u2694 Attaquer votre Ennemie  ◇──◇");
            System.out.println("◇──◇  [-2-]  -  \uD83C\uDF81 Utiliser un de vos objets  ◇──◇");

            int input = nbValide(this.scanner);
            if (input != 1 && input != 2) {
                input = nbValide(this.scanner);
            }

            if (input == 1) {
                this.choixEnnemie();
            }
            else if (input == 2) {
                this.choixObjet();
            }

        }
        else {
            int x = (int) (Math.random() * this.game.getHerosTeam()
                    .listeVivant().size() - 1);
            Combatant cible = this.game.getHerosTeam().listeVivant().get(x);

            System.out.println("Regarde, il attaque, " + this.game.getCombattantActuel().getName() + " est en train de frapper \uD83C\uDFAF " + cible.getName());

            this.game.attaque(cible);
        }
    }

    @Override
    public void choixEnnemie() {
        System.out.println("\n★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★\n");
        System.out.println("\uD83D\uDD08 Il faut crier à ton héros qui souhaites-tu attaquer, l'ennemi qu'il doit vaincre pour remporter tous ses combats, alors dis lui ! \uD83D\uDD08");

        ArrayList<Combatant> list;
        if (this.game.getCombattantActuel() instanceof Healer) {
            list = this.game.getHerosTeam().listeVivant();
        }
        else {
            list = this.game.getCibleTeam().listeVivant();
        }
        for (Combatant combatant : list) { //Qui attaquer entre les différents ennemies
            int indice = list.indexOf(combatant) + 1;
            System.out.println("★――――★  [-" + indice + "-]  ★――――★ Si tu attaque le combatant numéro " + indice + ", " + combatant.getName() + ", " + " sache qu'il possède " + combatant.getLifePoints() + "\u2764 points de vie actuellement! ");
        }
        int input = nbValide(this.scanner);
        while (input < 1 || input > list.size() + 1) {
            System.out.println("\ud83d\udea8 Aucun n'ennemi ne répond à ce nom ! Es-tu sûr que tu n'as pas besoin de lunettes mon jeune ami \uD83D\uDE06 ?  \ud83d\udea8");
            input = nbValide(this.scanner);
        }
        Combatant cible = list.get(input - 1);
        this.game.attaque(cible);
    }

    @Override
    public void choixObjet() {

        Hero h = (Hero) this.game.getCombattantActuel();
        if (h.getConsumables().size() > 0) {
            System.out.println("\n★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★\n");
            System.out.println("Hey l'ami ! Choisis vite un des objets dans ton inventaire avant que cela ne soit trop tard ! \\u1F96B \n");
            for (Consumable c : h.getConsumables()) {
                if (c instanceof Food) {
                    System.out.println(c.getNom());
                }
            }

            int intput = nbValide(this.scanner);
            if (intput < 1 || intput > h.getConsumables().size()) {
                System.out.println("\ud83d\udea8 Le chiffre que vous avez choisi n'est pas valide, selectionnez en un autre ! \ud83d\udea8 \n");
                intput = nbValide(this.scanner);
            }

            this.game.obj(intput);

        } else {
            System.out.println("\ud83d\udea8 Non, tu ne peux plus rien faire, il ne te reste aucun objet en réserve ! \ud83d\udea8 \n");
            this.game.end();
        }

    }

    //-------------------- Troisième partie --------------------//
    @Override
    public void alerteMessage() {
        Hero h = (Hero) this.game.getCombattantActuel();
        //En fonction du combatant (s'il lui reste du mana ...)
        System.out.println(h.getFailMessage());
    }

    @Override
    public void Degats(Combatant cible) {
        System.out.println("\n★━━━━━━━━━━━━━━━━━━━━★★━━━━━━━━━━━━━━━━━━━━★");
        System.out.println("| \uD83D\uDE27 | Il ne reste que " + cible.getLifePoints() + "\u2764 points de vie à " + cible.getName() + ", tu peux le faire, continue !");
        System.out.println("★━━━━━━━━━━━━━━━━━━━━★★━━━━━━━━━━━━━━━━━━━━★\n");
        this.game.end();
    }

    //-------------------- Dernière partie --------------------//
    @Override
    public void Fin() {
        System.out.println("\n★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★\n");
        System.out.println("Il ne reste plus qu'à prier \uD83D\uDD47 pour que toi et ton équipe de furieux combattants arriviez a passer le niveau " + this.game.getLevel());
        System.out.println("\n★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★\n");
        this.game.createCible(this.game.getCbHeros());
    }

    @Override
    public void Gagne() {
        System.out.println("\n★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★\n");
        System.out.println("Ouah ! Tu as gagné mon jeune ami. Bravo, tes ennemis étaient forts, mais tu as vaincu \uD83D\uDCAA");
        System.out.println("Je te souhaite de continuer sur ta lance camarade. L'arène de Tekaliss est tienne maintenant ! Reviens quand tu le désir, je t'accueillerais avec grande joie.\uD83D\uDC4B");
        System.out.println("\n★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★\n");
    }

    @Override
    public void Perdu() {
        System.out.println("\n★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★\n");
        System.out.println("Tu y étais presque mon jeune amis. Mais ce n'est pas grave, l'important, c'est de participer. \uD83D\uDE28");
        System.out.println("Tu fus un combattant et un ami merveilleux. L'arène de Tekaliss t'attendra pour ta revanche! Reviens quand tu le désir, je t'accueillerais avec grande joie.\uD83D\uDC4B");
        System.out.println("\n★・・・・・★・・・・・★・・・・・★・・・・・★・・・・・★\n");
    }
}