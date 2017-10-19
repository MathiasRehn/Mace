package com.company;

import com.googlecode.lanterna.gui.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.Key;

import java.io.FileNotFoundException;

public class Input {
    Terminal terminal;
    Gameboard gameboard;

    public Input(Terminal terminal,Gameboard gameboard) {
        this.terminal=terminal;
        this.gameboard=gameboard;
    }


    public void movePlayer(Terminal terminal,Player player,Player player2,Render render,Monster monster) throws InterruptedException, FileNotFoundException {
        Key key;

       int player1Color = 210;
       int player2Color = 155;

//        terminal.moveCursor(player.getX(),player.getY());
//        terminal.putCharacter('C');
//        terminal.moveCursor(player2.getX(),player2.getY());
//        terminal.putCharacter('Y');
//        terminal.moveCursor((int) monster.getX(),(int) monster.getY());
//        terminal.putCharacter('\u15E3');


            do {
                Thread.sleep(40);
//                monster.move();
//                terminal.moveCursor((int) monster.getX(),(int) monster.getY());
//                terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
//                if (gameboard.board[(int) monster.getX()][(int) monster.getY()] == 4) {
//                    terminal.putCharacter('*');
//                } else terminal.putCharacter(' ');
//                terminal.moveCursor((int) monster.getX(),(int) monster.getY());
//                terminal.putCharacter('\u15E3');
                terminal.moveCursor(player.getX(),player.getY());
                terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
                terminal.putCharacter('C');
                terminal.moveCursor(player2.getX(),player2.getY());
                terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
                terminal.putCharacter('Y');
                key=terminal.readInput();

            } while (key == null);

            switch (key.getCharacter()) {
                case 'S': case 's':
                    if (gameboard.board[player.getX()][player.getY()+1] != 7) {
                        terminal.moveCursor(player.getX(),player.getY());
                        terminal.applyBackgroundColor(player1Color);
                        terminal.putCharacter(' ');
                        gameboard.board[player.getX()][player.getY()]=1;
                        player.setY(+1);
                        for (int i=0;gameboard.board[player.getX()][player.getY()+i] != 7 ; i++) {
                            terminal.moveCursor(player.getX(),player.getY()+i);
                            terminal.applyBackgroundColor(player1Color);
                            gameboard.board[player.getX()][player.getY()+i]=1;
                            terminal.putCharacter(' ');
                        }
                    }break;
                case 'W': case 'w':
                    if (gameboard.board[player.getX()][player.getY()-1] != 7) {
                        terminal.moveCursor(player.getX(),player.getY());
                        terminal.applyBackgroundColor(player1Color);
                        gameboard.board[player.getX()][player.getY()]=1;
                        terminal.putCharacter(' ');
                        player.setY(-1);
                        for (int i=0;gameboard.board[player.getX()][player.getY()-i] != 7 ; i++) {
                            terminal.moveCursor(player.getX(),player.getY()-i);
                            terminal.moveCursor(player.getX(),player.getY()-i);
                            terminal.applyBackgroundColor(player1Color);
                            gameboard.board[player.getX()][player.getY()-i]=1;
                            terminal.putCharacter(' ');
                            if (gameboard.board[player.getX()][player.getY()-i] == 2) ;
                            {
                                player2.setX(66);
                                player2.setY(9);
                            }
                        }
                    }break;
                case 'A':case 'a':
                    if (gameboard.board[player.getX()-1][player.getY()] != 7) {
                        terminal.moveCursor(player.getX(),player.getY());
                        terminal.applyBackgroundColor(player1Color);
                        gameboard.board[player.getX()][player.getY()]=1;
                        terminal.putCharacter(' ');
                        player.setX(-1);
                        for (int i=0;gameboard.board[player.getX()-i][player.getY()] != 7 ; i++) {
                            terminal.moveCursor(player.getX()-i,player.getY());
                            terminal.applyBackgroundColor(player1Color);
                            gameboard.board[player.getX()-i][player.getY()]=1;
                            terminal.putCharacter(' '); }
                    }break;
                case 'D': case 'd':
                    if (gameboard.board[player.getX()+1][player.getY()] != 7) {
                        terminal.moveCursor(player.getX(),player.getY());
                        terminal.applyBackgroundColor(player1Color);
                        gameboard.board[player.getX()][player.getY()]=1;
                        terminal.putCharacter(' ');
                        player.setX(+1);
                        for (int i=0;gameboard.board[player.getX()+i][player.getY()] != 7 ; i++){
                            terminal.moveCursor(player.getX()+i,player.getY());
                            terminal.applyBackgroundColor(player1Color);
                            gameboard.board[player.getX()+i][player.getY()]=1;
                            terminal.putCharacter(' ');
                        }
                    }break;
                case 'I': case 'i':
                    if (gameboard.board[player2.getX()][player2.getY()-1] != 7) {
                        terminal.moveCursor(player2.getX(),player2.getY());
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()][player2.getY()]=2;
                        terminal.putCharacter(' ');
                        player2.setY(-1);
                    }for (int i=0;gameboard.board[player2.getX()][player2.getY()-i] != 7 ; i++) {
                        terminal.moveCursor(player2.getX(),player2.getY()-i);
                        terminal.moveCursor(player2.getX(),player2.getY()-i);
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()][player2.getY()-i]=2;
                        terminal.putCharacter(' ');
                    }break;
                case 'K': case 'k':
                    if (gameboard.board[player2.getX()][player2.getY()+1] != 7) {
                        terminal.moveCursor(player2.getX(),player2.getY());
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()][player2.getY()]=2;
                        terminal.putCharacter(' ');
                        player2.setY(+1);
                    }for (int i=0;gameboard.board[player2.getX()][player2.getY()+i] != 7 ; i++) {
                        terminal.moveCursor(player2.getX(),player2.getY()+i);
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()][player2.getY()+i]=2;
                        terminal.putCharacter(' ');
                    }
                        break;
                case 'J': case 'j':
                    if (gameboard.board[player2.getX()-1][player2.getY()] != 7) {
                        terminal.moveCursor(player2.getX(),player2.getY());
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()][player2.getY()]=2;
                        terminal.putCharacter(' ');
                        player2.setX(-1);
                    }
                    for (int i=0;gameboard.board[player2.getX()-i][player2.getY()] != 7 ; i++) {
                        terminal.moveCursor(player2.getX()-i,player2.getY());
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()-i][player2.getY()]=2;
                        terminal.putCharacter(' '); }

                    break;
                case 'L':case 'l':
                    if (gameboard.board[player2.getX()+1][player2.getY()] != 7) {
                        terminal.moveCursor(player2.getX(),player2.getY());
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()][player2.getY()]=2;
                        terminal.putCharacter(' ');
                        player2.setX(+1);
                    }
                    for (int i=0;gameboard.board[player2.getX()+i][player2.getY()] != 7 ; i++){
                        terminal.moveCursor(player2.getX()+i,player2.getY());
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()+i][player2.getY()]=2;
                        terminal.putCharacter(' '); }
                    break;
            case 'Q':case 'q':
                    System.exit(0);
                    break;
            }

            terminal.moveCursor(player.getX(),player.getY());
            terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
            terminal.putCharacter('C');
            terminal.moveCursor(player2.getX(),player2.getY());
            terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
            terminal.putCharacter('Y');
//            terminal.moveCursor((int) monster.getX(),(int) monster.getY());
//            terminal.putCharacter('\u15E3');

        }
    }




