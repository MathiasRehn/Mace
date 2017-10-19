package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;


public class Render {
    Terminal terminal;
    Gameboard gameboard;





    public Render(Terminal terminal,Gameboard gameboard) {
        this.terminal=terminal;
        this.gameboard=gameboard;
    }

    public void levelDraw(int level) throws FileNotFoundException {

        terminal.clearScreen();
        Scanner sc;
        switch (level) {
            case 1:
                sc = new Scanner(new File("C:\\Academy\\Program\\Mace\\level1.txt"));
                break;
            case 2:
                sc = new Scanner(new File("C:\\Academy\\Program\\Mace\\level2.txt"));
                break;
            case 3:
                sc = new Scanner(new File("C:\\Academy\\Program\\Mace\\level4.txt"));
                break;
            case 4:
                sc = new Scanner(new File("C:\\Academy\\Program\\Mace\\level7.txt"));
                break;
            case 5:
                sc = new Scanner(new File("C:\\Academy\\Program\\Mace\\level8.txt"));
                break;
            case 6:
                sc = new Scanner(new File("C:\\Academy\\Program\\Mace\\level9.txt"));
                break;
            case 7:
                sc = new Scanner(new File("C:\\Academy\\Program\\Mace\\level10.txt"));
                break;
            default:
                startScreen();
                return;
        }
        int y=0;
        String s;
        while (sc.hasNext()) {
            s=sc.nextLine();
            for (int i=0; i < s.length(); i++) {
                if (s.charAt(i) == 'X') {
                    gameboard.board[i][y]=7;
                    terminal.moveCursor(i,y);
                    terminal.applyBackgroundColor(255,255,255);
                    terminal.putCharacter(' ');
                }
            }
            y++;
        }
    }
    public void startScreen() throws FileNotFoundException{
        Key key;
        String s;
        int choice =0;
        terminal.clearScreen();
        Scanner sc = new Scanner(new File("C:\\Academy\\Program\\Mace\\startScreen.txt"));

        while (sc.hasNext()) {
            s=sc.nextLine();
            for (int i=0; i < s.length(); i++) {
                terminal.putCharacter(s.charAt(i));
            }
        }
        do {
            key = terminal.readInput();
        }
        while (key == null);
        switch (key.getCharacter()) {
            case '1':
                choice = 1;
                break;
            case '2':
                choice = 2;
                break;
            case '3':
                choice = 3;
                break;
            case '4':
                choice = 4;
                break;
            case '5':
                choice = 5;
                break;
            case '6':
                choice = 6;
                break;
            case '7':
                choice = 7;
                break;
            case 'Q': case 'q':
                System.exit(0);
                break;

        }
        levelDraw(choice);

    }

    public void pinkWon() throws FileNotFoundException{
        terminal.clearScreen();
        Scanner sc = new Scanner(new File("C:\\Academy\\Program\\Mace\\youwonpink.txt"));
        String s;
        Key key;
        while (sc.hasNext()) {
            s=sc.nextLine();
            for (int i=0; i < s.length(); i++) {
                    terminal.putCharacter(s.charAt(i));
            }
        }
        do {
            key = terminal.readInput();
        }
        while (key == null);{
        switch (key.getKind()) {
            case Enter:
                startScreen();
                break;

            }
        }
    }

    public void greenWon() throws FileNotFoundException, InterruptedException {
        terminal.clearScreen();
        Scanner sc = new Scanner(new File("C:\\Academy\\Program\\Mace\\youwongreen.txt"));
        String s;
        Key key;
        while (sc.hasNext()) {
            s=sc.nextLine();
            for (int i=0; i < s.length(); i++) {
                terminal.putCharacter(s.charAt(i));
            }
        }

        }
    }



