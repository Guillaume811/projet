package puissancex.puissance4;

import static org.junit.jupiter.api.Assertions.*;

// import java.io.ByteArrayInputStream;
// import java.io.InputStream;
// import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class Puissance4Test {

    @Test
    void testPlay() {
        // Check if pawns do not extend beyond the board
        Puissance4 game = new Puissance4("p1", 6, 7, 4);
        assertTrue(game.play(0, 'X'));
        assertTrue(game.play(0, 'X'));
        assertTrue(game.play(0, 'X'));
        assertTrue(game.play(0, 'X'));
        assertTrue(game.play(0, 'X'));
        assertTrue(game.play(0, 'X'));
        assertFalse(game.play(0, 'X'));

        Puissance4 game2 = new Puissance4("p1", 8, 8, 5);
        assertTrue(game2.play(0, 'X'));
        assertTrue(game2.play(0, 'X'));
        assertTrue(game2.play(0, 'X'));
        assertTrue(game2.play(0, 'X'));
        assertTrue(game2.play(0, 'X'));
        assertTrue(game2.play(0, 'X'));
        assertTrue(game2.play(0, 'X'));
        assertTrue(game2.play(0, 'X'));
        assertFalse(game2.play(0, 'X'));

        Puissance4 game3 = new Puissance4("gui", 8, 9, 5);
        assertTrue(game3.play(0, 'X'));
        assertTrue(game3.play(0, 'X'));
        assertTrue(game3.play(0, 'X'));
        assertTrue(game3.play(0, 'X'));
        assertTrue(game3.play(0, 'X'));
        assertTrue(game3.play(0, 'X'));
        assertTrue(game3.play(0, 'X'));
        assertTrue(game3.play(0, 'X'));
        assertFalse(game3.play(0, 'X'));

        Puissance4 game4 = new Puissance4("gui", 12, 12, 6);
        assertTrue(game4.play(0, 'X'));
        assertTrue(game4.play(0, 'X'));
        assertTrue(game4.play(0, 'X'));
        assertTrue(game4.play(0, 'X'));
        assertTrue(game4.play(0, 'X'));
        assertTrue(game4.play(0, 'X'));
        assertTrue(game4.play(0, 'X'));
        assertTrue(game4.play(0, 'X'));
        assertTrue(game4.play(0, 'X'));
        assertTrue(game4.play(0, 'X'));
        assertTrue(game4.play(0, 'X'));
        assertTrue(game4.play(0, 'X'));
        assertFalse(game4.play(0, 'X'));


        Puissance4 game5 = new Puissance4("gui", 16, 17, 10);
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertTrue(game5.play(0, 'X'));
        assertFalse(game5.play(0, 'X'));
    }

    @Test
    void testWinLine() {
        Puissance4 game = new Puissance4("j1", 6, 7, 4);
        char[][] jeu = {
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'O','O','O','O','-','-','-'}
        };
        game.setPlateau(jeu);
        assertTrue(game.winLine());

        char[][] jeu2 = {
            {'X','X','X','X','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'}
        };
        game.setPlateau(jeu2);
        assertTrue(game.winLine());

        char[][] jeu3 = {
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','X','X'},
            {'X','X','-','-','-','X','X'}
        };
        game.setPlateau(jeu3);
        assertFalse(game.winLine());

        char[][] jeu4 = {
            {'X','X','-','-','-','X','X'},
            {'-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'}
        };
        game.setPlateau(jeu4);
        assertFalse(game.winLine());

        char[][] jeu5 = {
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'X','X','O','X','X','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'}
        };
        game.setPlateau(jeu5);
        assertFalse(game.winLine());

        Puissance4 game2 = new Puissance4("j1", 8, 8, 5);
        char[][] jeu6 = {
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-'},
            {'X','X','X','-','-','-','X','X'}
        };
        game2.setPlateau(jeu6);
        assertFalse(game2.winLine());

        char[][] jeu7 = {
            {'X','X','-','-','-','X','X','X'},
            {'-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'}
        };
        game2.setPlateau(jeu7);
        assertFalse(game2.winLine());

        Puissance4 game3 = new Puissance4("j1", 12, 12, 6);
        char[][] jeu8 = {
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'X','X','X','-','-','-','-','-'},
            {'X','X','X','-','-','-','X','X'}
        };
        game3.setPlateau(jeu8);
        assertFalse(game3.winLine());

        char[][] jeu9 = {
            {'X','X','X','-','-','-','X','X'},
            {'X','X','X','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'}
        };
        game3.setPlateau(jeu9);
        assertFalse(game3.winLine());

        Puissance4 game4 = new Puissance4("j1", 16, 17, 10);
        char[][] jeu10 = {
            {'X','X','X','X','X','-','-','-','-','-','-','-','X','X','X','X','X'},
            {'X','X','X','X','X','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}
        };
        game4.setPlateau(jeu10);
        assertFalse(game4.winLine());

        char[][] jeu11 = {
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','X','X','X','X','X'},
            {'X','X','X','X','X','-','-','-','-','-','-','-','X','X','X','X','X'}
        };
        game4.setPlateau(jeu11);
        assertFalse(game4.winLine());
    }

    @Test
    void testWinColumn() {
        Puissance4 game = new Puissance4("j1", 6, 7, 4);
        char[][] jeu = {
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','O','-','-','-','-','-'},
            {'-','O','-','-','-','-','-'},
            {'-','O','-','-','-','-','-'},
            {'-','O','-','-','-','-','-'}
        };
        game.setPlateau(jeu);
        assertTrue(game.winColumn());

        char[][] jeu2 = {
            {'X','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'}
        };
        game.setPlateau(jeu2);
        assertTrue(game.winColumn());

        char[][] jeu3 = {
            {'X','X','-','-','-','-','-'},
            {'X','X','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'}
        };
        game.setPlateau(jeu3);
        assertFalse(game.winColumn());

        char[][] jeu4 = {
            {'-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','X','X'},
            {'-','-','-','-','-','X','X'}
        };
        game.setPlateau(jeu4);
        assertFalse(game.winColumn());

        char[][] jeu5 = {
            {'-','-','-','-','-','-','-'},
            {'-','-','X','-','-','-','-'},
            {'-','-','X','-','-','-','-'},
            {'-','-','O','-','-','-','-'},
            {'-','-','X','-','-','-','-'},
            {'-','-','X','-','-','-','-'}
        };
        game.setPlateau(jeu5);
        assertFalse(game.winColumn());

        Puissance4 game2 = new Puissance4("j1", 8, 8, 5);
        char[][] jeu6 = {
            {'X','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-'}
        };
        game2.setPlateau(jeu6);
        assertFalse(game2.winColumn());

        char[][] jeu7 = {
            {'-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','X','X'}
        };
        game2.setPlateau(jeu7);
        assertFalse(game2.winColumn());

        Puissance4 game3 = new Puissance4("j1", 12, 12, 6);
        char[][] jeu8 = {
            {'X','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-'}
        };
        game3.setPlateau(jeu8);
        assertFalse(game3.winColumn());

        char[][] jeu9 = {
            {'-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','X','X'}
        };
        game3.setPlateau(jeu9);
        assertFalse(game3.winColumn());

        Puissance4 game4 = new Puissance4("j1", 16, 17, 10);
        char[][] jeu10 = {
            {'X','X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}
        };
        game4.setPlateau(jeu10);
        assertFalse(game4.winColumn());

        char[][] jeu11 = {
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X','X'}
        };
        game4.setPlateau(jeu11);
        assertFalse(game4.winColumn());
    }

    @Test
    void testWinDiagonal() {
        Puissance4 game = new Puissance4("j1", 6, 7, 4);
        char[][] jeu = {
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','O','-'},
            {'-','-','-','-','O','-','-'},
            {'-','-','-','O','-','-','-'},
            {'-','-','O','-','-','-','-'}
        };
        game.setPlateau(jeu);
        assertTrue(game.winDiagonal());

        char[][] jeu2 = {
            {'-','-','-','-','-','-','-'},
            {'-','-','-','X','-','-','-'},
            {'-','-','X','-','-','-','-'},
            {'-','X','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'}
        };
        game.setPlateau(jeu2);
        assertTrue(game.winDiagonal());

        char[][] jeu3 = {
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','X'},
            {'-','-','-','-','-','X','X'}
        };
        game.setPlateau(jeu3);
        assertFalse(game.winDiagonal());

        char[][] jeu4 = {
            {'X','X','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'}
        };
        game.setPlateau(jeu4);
        assertFalse(game.winDiagonal());

        char[][] jeu5 = {
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','X','-','-'},
            {'-','-','-','X','-','-','-'},
            {'-','-','O','-','-','-','-'},
            {'-','X','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'}
        };
        game.setPlateau(jeu5);
        assertFalse(game.winDiagonal());

        Puissance4 game2 = new Puissance4("j1", 8, 8, 5);
        char[][] jeu6 = {
            {'X','X','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'}
        };
        game2.setPlateau(jeu6);
        assertFalse(game2.winDiagonal());

        char[][] jeu7 = {
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','X','X','X'}
        };
        game2.setPlateau(jeu7);
        assertFalse(game2.winDiagonal());

        Puissance4 game3 = new Puissance4("j1", 12, 12, 6);
        char[][] jeu8 = {
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','-','-','-','X','X','X'}
        };
        game3.setPlateau(jeu8);
        assertFalse(game3.winDiagonal());

        char[][] jeu9 = {
            {'X','X','X','-','-','-','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'}
        };
        game3.setPlateau(jeu9);
        assertFalse(game3.winDiagonal());

        Puissance4 game4 = new Puissance4("j1", 16, 17, 10);
        char[][] jeu10 = {
            {'X','X','X','X','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','X','X','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}
        };
        game4.setPlateau(jeu10);
        assertFalse(game4.winDiagonal());

        char[][] jeu11 = {
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','X','X','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','X','X','X','X'}
        };
        game4.setPlateau(jeu11);
        assertFalse(game4.winDiagonal());
    }

    @Test
    void testWinDiagonal2() {
        Puissance4 game = new Puissance4("j1", 6, 7, 4);
        char[][] jeu = {
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'O','-','-','-','-','-','-'},
            {'-','O','-','-','-','-','-'},
            {'-','-','O','-','-','-','-'},
            {'-','-','-','O','-','-','-'}
        };
        game.setPlateau(jeu);
        assertTrue(game.winDiagonal2());

        char[][] jeu2 = {
            {'-','-','-','X','-','-','-'},
            {'-','-','-','-','X','-','-'},
            {'-','-','-','-','-','X','-'},
            {'-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'}
        };
        game.setPlateau(jeu2);
        assertTrue(game.winDiagonal2());

        char[][] jeu3 = {
            {'-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'}
        };
        game.setPlateau(jeu3);
        assertFalse(game.winDiagonal2());

        char[][] jeu4 = {
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-'}
        };
        game.setPlateau(jeu4);
        assertFalse(game.winDiagonal2());

        char[][] jeu5 = {
            {'-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-'},
            {'-','X','-','-','-','-','-'},
            {'-','-','O','-','-','-','-'},
            {'-','-','-','X','-','-','-'},
            {'-','-','-','-','X','-','-'}
        };
        game.setPlateau(jeu5);
        assertFalse(game.winDiagonal2());

        Puissance4 game2 = new Puissance4("j1", 8, 8, 5);
        char[][] jeu6 = {
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-'},
            {'X','X','X','-','-','-','-','-'}
        };
        game2.setPlateau(jeu6);
        assertFalse(game2.winDiagonal2());

        char[][] jeu7 = {
            {'-','-','-','-','-','X','X','X'},
            {'-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'}
        };
        game2.setPlateau(jeu7);
        assertFalse(game2.winDiagonal2());

        Puissance4 game3 = new Puissance4("j1", 12, 12, 6);
        char[][] jeu8 = {
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-','-','-','-','-'},
            {'X','X','X','-','-','-','-','-','-','-','-','-'}
        };
        game3.setPlateau(jeu8);
        assertFalse(game3.winDiagonal2());

        char[][] jeu9 = {
            {'-','-','-','-','-','-','-','-','-','X','X','X'},
            {'-','-','-','-','-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-'}
        };
        game3.setPlateau(jeu9);
        assertFalse(game3.winDiagonal2());

        Puissance4 game4 = new Puissance4("j1", 16, 17, 10);
        char[][] jeu10 = {
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','X','X','X','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','X','X','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','X'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}
        };
        game4.setPlateau(jeu10);
        assertFalse(game4.winDiagonal2());

        char[][] jeu11 = {
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','X','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','X','X','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {'X','X','X','X','-','-','-','-','-','-','-','-','-','-','-','-','-'}
        };
        game4.setPlateau(jeu11);
        assertFalse(game4.winDiagonal2());
    }

    @Test
    void testEquality() {
        Puissance4 game = new Puissance4("gui", 6, 7, 4);
        assertTrue(game.equality(41));
        assertFalse(game.equality(39));

        Puissance4 game2 = new Puissance4("gui", 8, 8, 5);
        assertTrue(game2.equality(63));
        assertFalse(game2.equality(40));

        Puissance4 game3 = new Puissance4("gui", 8, 9, 5);
        assertTrue(game3.equality(71));
        assertFalse(game3.equality(60));

        Puissance4 game4 = new Puissance4("gui", 12, 12, 6);
        assertTrue(game4.equality(143));
        assertFalse(game4.equality(100));

        Puissance4 game5 = new Puissance4("gui", 16, 17, 10);
        assertTrue(game5.equality(271));
        assertFalse(game5.equality(200));

    }

    // @Test
    // void testverificationLevel() {
    //     Puissance4 game = new Puissance4("gui", 6, 7, 4);
    //     Scanner inputLevelAi = new Scanner(System.in);
    //     int input = 1;
    //     InputStream in = new ByteArrayInputStream(input.getBytes());
    //     assertTrue(game.verificationLevel());



    // }
}
