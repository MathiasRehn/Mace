package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import com.googlecode.lanterna.terminal.Terminal;

public class Render {
    Terminal terminal;
    Gameboard gameboard;


    public Render(Terminal terminal,Gameboard gameboard) {
        this.terminal=terminal;
        this.gameboard=gameboard;
    }

    public void levelDraw() throws FileNotFoundException {
        Scanner sc=new Scanner(new File("C:\\Academy\\Program\\Mace\\level10.txt"));
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
//
//      for (int x=0; x < gameboard.WIDTH; x++) {
//            for (int Y=0; Y < gameboard.HEIGHT; Y++) {
//                if (gameboard.board[x][Y] != 7) {
//                    gameboard.board[x][Y] = 4;
//                    terminal.moveCursor(x,Y);
//                    terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
//                    terminal.putCharacter('*');
//                    terminal.applyForegroundColor(Terminal.Color.YELLOW);
//
//
//                }
//            }
//        }
    }
}

