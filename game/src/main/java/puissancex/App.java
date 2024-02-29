package puissancex;

import java.util.InputMismatchException;
import java.util.Scanner;

import puissancex.puissance4.Puissance4;
import puissancex.minmax.MinMax;


public class App {
    public static void main( String[] args ) {

        String player1 = "joueur1";
        int numberOfTurn = 0;
        int column = 0;
        int level = 0;
        int maxLevel = 4;
        int depth = 0;
        boolean turnOk = false;
        boolean levelOk = false;

        Scanner inputNamePlayer1 = new Scanner(System.in);
        Scanner inputColumnPlayer = new Scanner(System.in);
        Scanner inputLevelAi = new Scanner(System.in);

        try {
            System.out.println("Entrer le nom du Joueur 1 :");
            player1 = inputNamePlayer1.next();
            System.out.println();


        } catch (InputMismatchException e) {
            System.out.println(e);
            System.out.println("La saisie n'est pas valide.");
        }

        Puissance4 game = new Puissance4(player1, 6, 7, 4);
        MinMax iA = new MinMax();

        // AI Level
        while (!levelOk) {

            level = game.verificationLevel(inputLevelAi);

            if (level > maxLevel || level < 0) {

                levelOk = false;
            }
            
            else {

                if (level == 1) {

                    System.out.println("Vous avez choisie le niveau 1 ! Easy !");
                    System.out.println();
                    depth = 2;
                    levelOk = true;
                }

                if (level == 2) {

                    System.out.println("Vous avez choisie le niveau 2 ! Medium !");
                    System.out.println();
                    depth = 3;
                    levelOk = true;
                }

                if (level == 3) {

                    System.out.println("Vous avez choisie le niveau 3 ! Hardcore !");
                    System.out.println();
                    depth = 5;
                    levelOk = true;
                }
                
            }
        }

        System.out.println("FIGHT : " + game.getNamePlayer() + " VS IA");
        game.displayGame();

        while (numberOfTurn < game.getNumberOfLine() * game.getNumberOfColumn()) {
            while (!turnOk) {

                column = game.verificationInt(inputColumnPlayer);

                if (column > game.getBoard()[0].length || column < 0) {

                    turnOk = false;
                }
                
                else {

                    turnOk = true;
                }
            }

            turnOk = false;

            game.play(column - 1, 'X');

            game.displayGame();
            System.out.println();

            if (game.endGame(numberOfTurn)) {
                break;
            }

            numberOfTurn++;
            System.out.println("log :nombreDeTour : " +numberOfTurn);


            game.play(iA.minMax(game.getBoard(), depth, 4, numberOfTurn), 'O');
            System.out.println("Tour de l'IA");
            game.displayGame();

            if (game.endGame(numberOfTurn)) {
                break;
            }

            numberOfTurn++;
            System.out.println("log :nombreDeTour : " +numberOfTurn);

        }

        try {
            // System.out.println("log : je ferme les scanner");
            inputNamePlayer1.close();
            inputColumnPlayer.close();

        } catch (IllegalStateException e) {
            System.out.println("Les scanner ne sont pas fermer correctement.");
        }
    }
}
