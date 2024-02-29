package puissancex.puissance4;

import java.util.Scanner;

public class Puissance4 {
    private String player1 = "joueur1";
    // private String joueur2 = "joueur2";
    private int numberOfLine = 6;
    private int numberOfColumn = 7;
    private int winMax = 4;
    private char[][] board;
    private final char PAWN_1 = 'X';
    private final char PAWN_2 = 'O';
    // public String joueurActuel = "default";

    // Constructor
    public Puissance4(String player1, int nBLine, int nBColumn, int winMax) {
        // Initialisation

        this.numberOfLine = nBLine;
        this.numberOfColumn = nBColumn;

        this.board = new char[this.numberOfLine][this.numberOfColumn];
        for (int line = 0; line < this.board.length; line++) {
            for (int column = 0; column < this.board[line].length; column++) {
                this.board[line][column] = '-';
            }
        }

        // this.joueurActuel = joueur1;
        this.player1 = player1;
        this.winMax = winMax;
    }

    public Puissance4(String player1, String player2) {
        // Initialisation

        this.board = new char[this.numberOfLine][this.numberOfColumn];
        for (int ligne = 0; ligne < this.board.length; ligne++) {
            for (int colonne = 0; colonne < this.board[ligne].length; colonne++) {
                this.board[ligne][colonne] = '-';
            }
        }

        // this.joueurActuel = joueur1;
        this.player1 = player1;
    }

    // Version test
    public Puissance4(int i) {

        char[][] jeu = {
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','O','O','O'}
        };
        
        // char[][] jeu = {
        //     {'-','-','-','-','-','-','-','-'},
        //     {'-','-','-','-','-','-','-','-'},
        //     {'-','-','-','-','-','-','-','-'},
        //     {'-','-','-','-','-','-','-','-'},
        //     {'-','-','-','-','-','-','-','-'},
        //     {'-','-','-','-','-','-','-','-'},
        //     {'-','-','-','-','-','-','-','-'},
        //     {'-','-','-','-','-','-','-','-'},
        //     {'-','-','-','-','-','-','-','-'},
        //     {'-','-','-','-','-','-','-','X'},
        //     {'-','-','-','-','-','-','X','X'},
        //     {'-','-','-','-','-','X','X','X'}
        // };
        
        this.board = jeu;
    }

    /********* Getter *********/

    // Name Player
    public String getNamePlayer() {
        return this.player1;
    }

    // TODO: pas utiliser
    // Pawn Player
    public char getPawn1() {
        return this.PAWN_1;
    }

    // TODO: Pas utiliser
    // Pion Joueur 2
    public char getPion2() {
        return this.PAWN_2;
    }

    // Number of Line
    public int getNumberOfLine() {
        return this.numberOfLine;
    }

    // Number of Column
    public int getNumberOfColumn() {
        return this.numberOfColumn;
    }

    // Board
    public char[][] getBoard() {
        return this.board;
    }

    /********* Setter *********/

    // Name Player 1
    public void setNomJoueur1(String player1) {
        this.player1 = player1;
    }

    // Copy Board
    public void setPlateau(char[][] oldBoard) {
        char[][] newBoard = new char[oldBoard.length][oldBoard[0].length];

        for (int line = 0; line < newBoard.length; line++) {
            for (int column = 0; column < newBoard[line].length; column++) {
                newBoard[line][column] = oldBoard[line][column];
            }
        }

        this.board = newBoard;
    }

    /********* Méthod *********/
    // Display Game
    public void displayGame() {

        for (int line = 0; line < this.board[0].length; line++) {
            System.out.print("  " + (line + 1) + "  ");
        }
        System.out.println();

        for (int line = 0; line < this.board.length; line++) {
            for (int column = 0; column < this.board[line].length; column++) {
                System.out.print("| " + this.board[line][column] + " |");
            }
            System.out.println();
        }
    }

    // Verification Turn Ok
    public int verificationLevel(Scanner input) {
        int level;

        System.out.println(this.player1 + ", choisie le niveau de l'IA : 1, 2 ou 3 ?");

        while (!input.hasNextInt()) {
            System.out.println("La saisie n'est pas valide, seulement les niveaux 1, 2 et 3 sont disponible !");
            input.nextLine();
        }

        level = input.nextInt();

        return level;
    }
    
    // Verification Turn Ok
    public int verificationInt(Scanner input) {
        int column;

        System.out.println(this.player1 + ", dans quel colonne veux-tu jouer ?");

        while (!input.hasNextInt()) {
            System.out.println("La saisie n'est pas valide, regarde les numéros en haut du plateau.1");
            input.nextLine();
        }

        column = input.nextInt();

        return column;
    }

    /*
     * Method play
     * Go through board starting from the bottom
     * If, box is emptied : put down a pawn
     * Else, return false
     */
    public boolean play(int column, char pawn) {

        for (int line = this.board.length - 1; line >= 0; line--) {
            if (this.board[line][column] == '-') {

                this.board[line][column] = pawn;
                return true;
            }
        }
        System.out.println("La colonne est remplie. Tu ne peux pas placer ton pion ici.");
        return false;
    }


    /*
     * Method win Line
     * Go through board line by line
     * count the 'X' and 'O'
     * break if stop condition is true
     */
    public boolean winLine() {
        // System.out.println("log : winLine");
        int counterX = 0;
        int counterO = 0;

        for (int line = this.board.length - 1; line >= 0; line--) {
            for (int column = 0; column < this.board[line].length; column++) {

                if (this.board[line][column] == 'X') {
                    // System.out.println("log : **********active compteur X");
                    counterX += 1;
                    // System.out.println("log : X = " +counterX);

                    if (counterO != 0) {
                        // System.out.println("log : RESET O = " +counterO);
                        counterO = 0;
                    }
                } else if (this.board[line][column] == 'O') {
                    // System.out.println("log : **********active compteur O");
                    counterO += 1;
                    // System.out.println("log : O = " +counterO);

                    if (counterX != 0) {
                        // System.out.println("log : RESET X = " +counterX);
                        counterX = 0;
                    }
                } else {
                    counterO = 0;
                    // System.out.println("log : RESET O = " +counterO);
                    counterX = 0;
                    // System.out.println("log : RESET X = " +counterX);

                }

                if (counterO >= this.winMax) {
                    System.out.println("L'IA a gagner, avec des lignes");
                    return true;
                }

                if (counterX >= this.winMax) {
                    System.out.println("Bravo " + this.player1 + ", tu as gagné ! (avec des lignes)");
                    return true;
                }
            }
            counterX = 0;
            counterO = 0;
        }
        return false;
    }

    /*
     * Method win Column
     * Go through board column by column
     * count the 'X' and 'O'
     * break if stop condition is true
     */
    public boolean winColumn() {
        int counterX = 0;
        int counterO = 0;

        for (int column = 0; column < this.board[0].length; column++) {
            // System.out.println("log : colonne : " +column);
            for (int line = 0; line < this.board.length; line++) {
                // System.out.println(log : ligne+ " " +ligne);

                if (this.board[line][column] == 'X') {
                    counterX += 1;
                    if (counterO != 0) {
                        counterO = 0;
                    }
                } else if (this.board[line][column] == 'O') {
                    counterO += 1;
                    if (counterX != 0) {
                        counterX = 0;
                    }
                } else {
                    counterX = 0;
                    counterO = 0;
                }

                if (counterX >= this.winMax) {
                    System.out.println("Bravo " + this.player1 + ", tu as gagné ! (avec des colonnes)");
                    return true;
                }

                if (counterO >= this.winMax) {
                    System.out.println("L'IA a gagner, avec des lignes");
                    return true;
                }
            }
            counterX = 0;
            counterO = 0;
        }
        return false;
    }

    /*
     * Method win Diagonal 1
     * Go through of the board from top left to bottom right
     * count the 'X' and 'O'
     * break if stop condition is true
     */
    public boolean winDiagonal() {
        int line;
        int column;
        int move = 0;
        int numberOfLineMax = this.board.length - 1;
        // System.out.println("log : numberOfLineMax : " +numberOfLineMax);
        int numberOfColumnMax = this.board[0].length - 1;
        // System.out.println("log : numberOfColumnMax : " +numberOfColumnMax);
        int counter = 0;
        int counterX = 0;
        int counterO = 0;
            // System.out.println("log : ********************win Diag : ");

        for (int nBL = 0; nBL < this.board.length; nBL++) {
            // System.out.println("log : ********************Début boucle for : " +nBL);
            counter = nBL + 1;
            // System.out.println("log : compteur : " +counter);
            line = nBL;
            // System.out.println("log : ligne : " +line);
            column = 0;
            // System.out.println("log : colonne : " +colonne);

            while (move < counter) {
                // System.out.println("log : Début while : deplacement : " +move+ " < "+counter+ " : counter");
                // System.out.println("log : position : [" +line+ "][" +column+ "]");
                if (this.board[line][column] == 'X') {
                    // System.out.println("log : **************counterX");
                    counterX += 1;
                    // System.out.println("log : counterX : " +counterX);
                    if (counterO != 0) {
                        counterO = 0;
                    }
                } else if (this.board[line][column] == 'O') {
                    counterO += 1;
                    if (counterX != 0) {
                        counterX = 0;
                        // System.out.println("log : RESET counterX : " +counterX);

                    }
                } else {
                    counterO = 0;
                    counterX = 0;
                    // System.out.println("log : RESET counterX 1 : " +counterX);

                }

                if (counterO >= this.winMax) {
                    System.out.println("L'IA a gagner, avec des lignes");
                    return true;
                }

                if (counterX >= this.winMax) {
                    // System.out.println("log : counterX : " +counterX);
                    System.out.println("Bravo " + this.player1 + ", tu as gagné ! (avec des diag de gauche a droite)");
                    return true;
                }

                line -= 1;
                // System.out.println("log : ligne : " +line);
                column += 1;
                // System.out.println("log : colonne : " +column);
                move += 1;
                // System.out.println("log : deplacement : " +move);
            }

            move = 0;
            counterX = 0;
            // System.out.println("log : RESET counterX 2 : " +counterX);
            counterO = 0;
        }
        counter = 0;
        // System.out.println("log : RESET counter : " +counter);


        for (int nBL = this.board[0].length - 1; nBL > 0; nBL--) {
            // System.out.println("log : ****************************************this.bord.length: "+this.board.length);
            // System.out.println("log : ***Début 2eme boucle for : "+nBL);
            counter += 1;
            // System.out.println("log : compteur : " +counter);
            line = numberOfLineMax;
            // System.out.println("log : ligne : " +line);
            column = nBL;
            // System.out.println("log : colonne : " +column);

            while (move < counter) {
                // System.out.println("log : Début while : deplacement : " +move+ " < "+counter+ " : compteur");
                // System.out.println("log : position : [" +line+ "][" +column+ "]");
                if (this.board[line][column] == 'X') {
                    counterX += 1;
                    if (counterO != 0) {
                        counterO = 0;
                    }
                } else if (this.board[line][column] == 'O') {
                    counterO += 1;
                    if (counterX != 0) {
                        counterX = 0;
                    }
                } else {
                    // System.out.println("log : je suis la");

                    counterO = 0;
                    counterX = 0;
                }

                if (counterO >= this.winMax) {
                    System.out.println("L'IA a gagner, avec des lignes");
                    return true;
                }

                if (counterX >= this.winMax) {
                    System.out.println("Bravo " + this.player1 + ", tu as gagné ! (avec des diag de gauche a droite)");
                    return true;
                }

                line -= 1;
                // System.out.println("log : ligne : " +line);
                column += 1;
                // System.out.println("log : colonne : " +column);
                move += 1;
                // System.out.println("log : deplacement : " +move);
            }
            // System.out.println("log : ***************************Fin du while");

            move = 0;
            counterX = 0;
            counterO = 0;
        }
        return false;
    }

    /*
     * Method Win Diagonal 2
     * Go through of the board from bottom left to top right
     * count the 'X' and 'O'
     * break if stop condition is true
     */
    public boolean winDiagonal2() {
        int line;
        int column;
        int move = 0;
        int numberOfLine = this.board.length;
        int numberOfLine2 = this.board.length - 1;
        int numberOfColumn = this.board[0].length - 1;
        int counter = 0;
        int counterX = 0;
        int counterO = 0;

        for (int nBL = 0; nBL < numberOfLine; nBL++) {
            // System.out.println("log : ****************Début boucle for : " +nBL);
            counter = nBL + 1;
            // System.out.println("log : compteur : " +counter);
            line = nBL;
            // System.out.println("log : ligne : " +line);
            column = numberOfColumn;
            // System.out.println("log : colonne : " +column);
            while (move < counter) {
                // System.out.println("log : Début while : deplacement : " +move+ " < "
                // +counter+ " : compteur");
                // System.out.println("log : position : [" +line+ "][" +column+ "]");

                if (this.board[line][column] == 'X') {
                    counterX += 1;
                    if (counterO != 0) {
                        counterO = 0;
                    }
                } else if (this.board[line][column] == 'O') {
                    counterO += 1;
                    if (counterX != 0) {
                        counterX = 0;
                    }
                } else {
                    counterO = 0;
                    counterX = 0;
                }

                if (counterO >= this.winMax) {
                    System.out.println("L'IA a gagner, avec des lignes");
                    return true;
                }

                if (counterX >= this.winMax) {
                    System.out.println("Bravo " + this.player1 + ", tu as gagné ! (avec des diag droite a gauche)");
                    return true;
                }

                line -= 1;
                // System.out.println("log : ligne : " +line);
                column -= 1;
                // System.out.println("log : colonne : " +column);
                move += 1;
                // System.out.println("log : deplacement : " +deplacement);
            }

            move = 0;
            counterX = 0;
            counterO = 0;
        }

        counter = 0;

        for (int nBL = numberOfLine2; nBL >= 0; nBL--) {
            // System.out.println("log : ****************Début boucle for : " +nBL);
            counter += 1;
            // System.out.println("log : compteur : " +counter);
            line = nBL;
            // System.out.println("log : ligne : " +line);
            column = 0;
            // System.out.println("log : colonne : " +column);
            while (move < counter) {
                // System.out.println("log : Début while : deplacement : " +move+ " < "
                // +counter+ " : compteur");
                // System.out.println("log : position : [" +line+ "][" +column+ "]");
                if (this.board[line][column] == 'X') {
                    counterX += 1;
                    if (counterO != 0) {
                        counterO = 0;
                    }
                } else if (this.board[line][column] == 'O') {
                    counterO += 1;
                    if (counterX != 0) {
                        counterX = 0;
                    }
                } else {
                    counterO = 0;
                    counterX = 0;
                }

                if (counterO >= this.winMax) {
                    System.out.println("L'IA a gagner, avec des lignes");
                    return true;
                }

                if (counterX >= this.winMax) {
                    System.out.println("Bravo " + this.player1 + ", tu as gagné ! (avec des diag droite a gauche)");
                    return true;
                }

                line += 1;
                // System.out.println("log : ligne : " +ligne);
                column += 1;
                // System.out.println("log : colonne : " +colonne);
                move += 1;
                // System.out.println("log : deplacement : " +move);
            }

            move = 0;
            counterX = 0;
            counterO = 0;
        }

        return false;
    }

    /*
     * Method draw
     * If nb of turn max is reached
     * return true
     * else return false
     */
    public boolean equality(int numberOfTurn) {
        if (numberOfTurn == getNumberOfLine() * getNumberOfColumn() - 1) {
            System.out.println("Toutes les cases sont remplie, dommage c'est un match nul.");
            return true;
        }
        return false;
    }

    /*
     * Method end game
     * Includes all victory conditions
     */
    public boolean endGame(int numberOfTurn) {

        if (winLine()) {
            return true;
        }

        if (winColumn()) {
            return true;
        }

        if (winDiagonal()) {
            return true;
        }

        if (winDiagonal2()) {
            return true;
        }

        if (equality(numberOfTurn)) {
            return true;
        }

        return false;
    }
}