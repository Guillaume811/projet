package puissancex.minmax;

public class MinMax {
    
    // Constructor

    public MinMax() {

    }

    /********* Getter *********/

    /********* Setter *********/

    /********* Méthod *********/

    // Display Game
    public void displayGame(char[][] board) {
        for (int line = 0; line < board.length; line++) {
            for (int column = 0; column < board[line].length; column++) {
                System.out.print("| " + board[line][column] + " |");
            }
            System.out.println();
        }
    }

    // Display Scoreboard
    public void displayScoreboard(int[] board) {
        for (int aiValue = 0; aiValue < board.length; aiValue++) {
            System.out.println(board[aiValue]);
        }
    }

    // Copy board for minMax
    public char[][] copyBoard(char[][] oldBoard) {
        char[][] newBoard = new char[oldBoard.length][oldBoard[0].length];

        for (int line = 0; line < newBoard.length; line++) {
            for (int column = 0; column < newBoard[line].length; column++) {
                newBoard[line][column] = oldBoard[line][column];
            }
        }

        return newBoard;
    }

    /*
     * Method verification Win Line
     * Go through of the board line by line
     * count the 'X' and 'O'
     * return score, based on the result of the counters
     */
    public int verificationWinLine(char[][] board, int winMax) {
        int counterX = 0;
        int counterO = 0;

        for (int line = board.length - 1; line >= 0; line--) {
            for (int column = 0; column < board[line].length; column++) {
                if (board[line][column] == 'X') {
                    counterX += 1;
                    if (counterO != 0) {
                        counterO = 0;
                    }
                } else if (board[line][column] == 'O') {
                    counterO += 1;
                    if (counterX != 0) {
                        counterX = 0;
                    }
                } else {
                    counterO = 0;
                    counterX = 0;
                }

                if (counterO >= winMax) {
                    return 100;
                }

                if (counterX >= winMax) {
                    return -400;
                }
            }
            counterX = 0;
            counterO = 0;
        }
        return 0;
    }

    /*
     * Method verification Win Line
     * Go through of the board column by column
     * count the 'X' and 'O'
     * return score, based on the result of the counters
     */
    public int verificationWinColumn(char[][] board, int winMax) {
        int counterX = 0;
        int counterO = 0;

        for (int column = 0; column < board[0].length; column++) {
            for (int line = 0; line < board.length; line++) {

                if (board[line][column] == 'X') {
                    counterX += 1;
                    if (counterO != 0) {
                        counterO = 0;
                    }
                } else if (board[line][column] == 'O') {
                    counterO += 1;
                    if (counterX != 0) {
                        counterX = 0;
                    }
                } else {
                    counterO = 0;
                    counterX = 0;
                }

                if (counterO >= winMax) {
                    return 100;
                }

                if (counterX >= winMax) {
                    return -400;
                }
            }
            counterX = 0;
            counterO = 0;
        }
        return 0;
    }

    /*
     * Method verification Win Diagonal
     * Go through of the board from top left to bottom right
     * count the 'X' and 'O'
     * return score, based on the result of the counters
     */
    public int verificationWinDiagonal(char[][] board, int winMax) {
        int line;
        int column;
        int move = 0;
        int numberOfLine = board.length;
        int numberOfLineMax = board.length - 1;
        int counter = 0;
        int counterX = 0;
        int counterO = 0;

        for (int nBL = 0; nBL < numberOfLine; nBL++) {

            counter = nBL + 1;
            line = nBL;
            column = 0;

            while (move < counter) {

                if (board[line][column] == 'X') {
                    counterX += 1;
                    if (counterO != 0) {
                        counterO = 0;
                    }
                } else if (board[line][column] == 'O') {
                    counterO += 1;
                    if (counterX != 0) {
                        counterX = 0;
                    }
                } else {
                    counterO = 0;
                    counterX = 0;
                }

                if (counterO >= winMax) {
                    return 100;
                }

                if (counterX >= winMax) {
                    return -400;
                }

                line -= 1;
                column += 1;
                move += 1;
            }

            move = 0;
            counterX = 0;
            counterO = 0;
        }

        counter = 0;

        for (int nBL = board[0].length - 1; nBL > 0; nBL--) {

            counter += 1;
            line = numberOfLineMax;
            column = nBL;

            while (move < counter) {

                if (board[line][column] == 'X') {
                    counterX += 1;
                    if (counterO != 0) {
                        counterO = 0;
                    }
                } else if (board[line][column] == 'O') {
                    counterO += 1;
                    if (counterX != 0) {
                        counterX = 0;
                    }
                } else {
                    counterO = 0;
                    counterX = 0;
                }

                if (counterO >= winMax) {
                    return 100;
                }

                if (counterX >= winMax) {
                    return -400;
                }

                line -= 1;
                column += 1;
                move += 1;
            }
            move = 0;
            counterX = 0;
            counterO = 0;
        }

        return 0;
    }

    /*
     * Method verification Win Diagonal
     * Go through of the board from bottom left to top right
     * count the 'X' and 'O'
     * return score, based on the result of the counters
     */
    public int verificationWinDiagonal2(char[][] board, int winMax) {
        int line;
        int column;
        int move = 0;
        int numberOfLine = board.length;
        int numberOfLine2 = board.length - 1;
        int numberOfColumn = board[0].length - 1;
        int counter = 0;
        int counterX = 0;
        int counterO = 0;

        for (int nBL = 0; nBL < numberOfLine; nBL++) {

            counter = nBL + 1;
            line = nBL;
            column = numberOfColumn;

            while (move < counter) {

                if (board[line][column] == 'X') {
                    counterX += 1;
                    if (counterO != 0) {
                        counterO = 0;
                    }
                } else if (board[line][column] == 'O') {
                    counterO += 1;
                    if (counterX != 0) {
                        counterX = 0;
                    }
                } else {
                    counterO = 0;
                    counterX = 0;
                }

                if (counterO >= winMax) {
                    return 100;
                }

                if (counterX >= winMax) {
                    return -400;
                }

                line -= 1;
                column -= 1;
                move += 1;
            }

            move = 0;
            counterX = 0;
            counterO = 0;
        }

        counter = 0;

        for (int nBL = numberOfLine2; nBL >= 0; nBL--) {

            counter += 1;
            line = nBL;
            column = 0;

            while (move < counter) {

                if (board[line][column] == 'X') {
                    counterX += 1;
                    if (counterO != 0) {
                        counterO = 0;
                    }
                } else if (board[line][column] == 'O') {
                    counterO += 1;
                    if (counterX != 0) {
                        counterX = 0;
                    }
                } else {
                    counterO = 0;
                    counterX = 0;
                }

                if (counterO >= winMax) {
                    return 100;
                }

                if (counterX >= winMax) {
                    return -400;
                }

                line += 1;
                column += 1;
                move += 1;
            }

            move = 0;
            counterX = 0;
            counterO = 0;
        }

        return 0;
    }

    /*
     * Method verification Victoire
     * Added all score of verification win
     */
    public int verificationWin(char[][] board, int winMax) {
    
        int result = verificationWinLine(board, winMax) + verificationWinColumn(board, winMax)
                + verificationWinDiagonal(board, winMax)
                + verificationWinDiagonal2(board, winMax);
        
        return result;
    }

    /*
     * Method play AI
     * Simulated an AI turn
     */
    public char[][] playIa(char[][] plateau, int colonne, char pion) {
        char[][] plateauJeu = copyBoard(plateau);
        for (int ligne = plateauJeu.length - 1; ligne >= 0; ligne--) {

            if (plateauJeu[ligne][colonne] == '-') {
                plateauJeu[ligne][colonne] = pion;
                return plateauJeu;
            }
        }
        return plateauJeu;
    }

    /*
     * Method min
     * Simulated all player 1 turn
     * Check if he win
     * If Score != 0 go to next column
     * SC : if player 1 win in 2 turns or less, play in the column
     * If depth > 0 call method max and stock result
     * When depth = 0, check and up result 
     */
    public int min(char[][] boardMin, int depth, int winMax) {

        int resultScore = 0;
        int score;
        int columnBoard = 0;
        char[][] stockSimulationBoard;
        int[] stockScores = new int[boardMin[0].length];

        while (columnBoard < boardMin[0].length) {

            stockSimulationBoard = copyBoard(playIa(copyBoard(boardMin), columnBoard, 'X'));

            score = verificationWin(stockSimulationBoard, winMax);

            if (score == -400) {
                if (depth >= 2) {
                    return columnBoard;
                }
                stockScores[columnBoard] = score;
                columnBoard++;
            } 
            
            else {
                if (depth != 0) {
                    score = max(stockSimulationBoard, depth - 1, winMax);
                    stockScores[columnBoard] = score;
                    columnBoard++;
                }

                else {
                    score = verificationWin(stockSimulationBoard, winMax);
                    stockScores[columnBoard] = score;
                    columnBoard++;
                }
            }
        }

        for (int i = 0; i < stockScores.length; i++) {
            resultScore += stockScores[i];
        }
        return resultScore;
    }

    /*
     * Method min
     * Simulated all AI turn
     * Check if she win
     * If Score != 0 go to next column
     * If depth > 0 call method min and stock result
     * When depth = 0, check and up result 
     */
    public int max(char[][] boardMax, int depth, int winMax) {

        int resultScore = 0;
        int score;
        int columnBoard = 0;
        char[][] stockSimulationBoard;
        int[] stockScores = new int[boardMax[0].length];

        while (columnBoard < boardMax[0].length) {

            stockSimulationBoard = copyBoard(playIa(copyBoard(boardMax), columnBoard, 'O'));

            score = verificationWin(stockSimulationBoard, winMax);

            if (score != 0) {
                stockScores[columnBoard] = score;
                columnBoard++;
            }

            else {
                if (depth != 0) {
                    score = min(stockSimulationBoard, depth - 1, winMax);
                    stockScores[columnBoard] = score;
                    columnBoard++;
                }
                else {
                    score = verificationWin(stockSimulationBoard, winMax);
                    stockScores[columnBoard] = score;
                    columnBoard++;
                }
            }
        }

        for (int i = 0; i < stockScores.length; i++) {
            resultScore += stockScores[i];
        }
        return resultScore;
    }

    /*
     * Method MinMax
     * Simulated all AI turn
     * Check if she win in 1 turn
     * Else, call method min
     * Stock result in array
     * retrieves the highest value
     * return index of highest value
     */
    public int minMax(char[][] boardMinMax, int depth, int winMax, int numberOfTurn) {

        if (numberOfTurn == 1) {
            return 2;
        }

        int finalValue = -10000000;
        int currentValue;
        int position = 0;
        int aiValue;
        char[][] firstBoard;
        int[] stockAiValue = new int[boardMinMax[0].length];

        for (int columnOfGame = 0; columnOfGame < boardMinMax[0].length; columnOfGame++) {
            
            firstBoard = playIa(copyBoard(boardMinMax), columnOfGame, 'O');
            aiValue = verificationWin(firstBoard, winMax);

            if (aiValue != 0) {
                position = columnOfGame;
                return position;
            }

            else {
                aiValue = min(firstBoard, depth, winMax);
                
                if (aiValue < boardMinMax[0].length) {

                    if(aiValue > 0) {
                        
                        position = aiValue;
                        return position;
                    }
                }
                stockAiValue[columnOfGame] = aiValue;
            }
        }

        for (int i = 0; i < stockAiValue.length; i++) {
            currentValue = stockAiValue[i];

            if (currentValue > finalValue) {
                finalValue = currentValue;
                position = i;
            }
        }
        return position;
    }
}
