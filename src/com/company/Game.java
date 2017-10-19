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
    Key key;

    public Game() {
        this.terminal=TerminalFacade.createTerminal(System.in,System.out,Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        this.gameboard=new Gameboard();
        this.input=new Input(terminal,gameboard);
        this.render=new Render(terminal,gameboard);
        this.player=new Player(34,9);
        this.player2=new Player(66,20);
        this.monster1=new Monster(50,15,2);
    }

    public void run() throws FileNotFoundException, InterruptedException {
        render.startScreen();
        terminal.moveCursor(49,0);
        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
        terminal.putCharacter('0');
        count=600;
        while (gameRuns) {
            count--;
            input.movePlayer(terminal,player,player2,render,monster1,comp,p1,p2,count);
            comp=0;
            p1=0;
            p2=0;
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
            if (count <= 0) {
                gameRuns=false;
            }
        }
        if (p1 > p2)
            render.pinkWon();
        else
            render.greenWon();

//        do {
//            key=terminal.readInput();
//        }
//        while (key.getCharacter() == '0');
//            switch (key.getCharacter()) {
//                case 'n':
//                    terminal.clearScreen();
//                    Game same=new Game();
//                    same.run();
//                    break;
//                case 'q':case 'Q':
//                   System.exit(0);
//                    break;
//            }


    }
}
