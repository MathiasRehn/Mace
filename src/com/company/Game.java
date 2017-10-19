package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.Key;

import java.io.FileNotFoundException;
import java.nio.charset.Charset;

public class Game {
    Terminal terminal;
    Gameboard gameboard;
    Input input;
    Render render;
    Player player;
    Player player2;
    Monster monster1;
    Boolean gameRuns=true;
    String s;
    int comp;
    int p1 = 0;
    int p2 = 0;
    int count;

    public Game() {
        this.terminal=TerminalFacade.createTerminal(System.in,System.out,Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        this.gameboard=new Gameboard();
        this.input=new Input(terminal,gameboard);
        this.render=new Render(terminal,gameboard);
        this.player=new Player(34,9);
        this.player2=new Player(66,9);
        this.monster1=new Monster(4,5,2);
    }

    public void run() throws FileNotFoundException, InterruptedException {
        render.levelDraw();
        terminal.moveCursor(49,0);
        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
        terminal.putCharacter('0');

        while (gameRuns) {

            count++;
            comp = 0;
            p1 = 0;
            p2 = 0;
            for (int x=0; x < gameboard.WIDTH; x++) {
                for (int Y=0; Y < gameboard.HEIGHT; Y++) {
                    if (gameboard.board[x][Y] == 0) {
                        comp++;
                    } else if (gameboard.board[x][Y] == 1) {
                        p1++;
                    } else if (gameboard.board[x][Y] == 2) {
                        p2++;
                    }
                }
            }

            terminal.moveCursor(20,0);
            s="Plaver 1: " + Integer.toString(p1);
            for (int i=0; i < s.length(); i++) {
                terminal.putCharacter(s.charAt(i));
            }

            terminal.moveCursor(70,0);
            s="Player 2: " + Integer.toString(p2);
            for (int i=0; i < s.length(); i++) {
                terminal.putCharacter(s.charAt(i));
            }

            terminal.moveCursor(43,30);
            s="Computer: " + Integer.toString(comp);
            for (int i=0; i < s.length(); i++) {
                terminal.putCharacter(s.charAt(i));
            }

            terminal.moveCursor(49,0);
            s=Integer.toString(count);
            for (int i=0; i < s.length(); i++) {
                terminal.putCharacter(s.charAt(i));
            }

            input.movePlayer(terminal,player,player2,render,monster1);

            if (count >= 100) {
                gameRuns=false;
            }

                }
        System.out.println(comp+" "+p1+" "+p2);
    }
}
