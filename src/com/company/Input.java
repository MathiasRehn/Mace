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


    public void movePlayer(Terminal terminal,Player player,Player player2,Render render,Monster monster,int comp,int p1,int p2,int count) throws InterruptedException, FileNotFoundException {
        Key key;
        String s;
        int player1Color=210;
        int player2Color=155;

        do {
            Thread.sleep(30);
            monster.move();

            terminal.moveCursor(monster.getX(),monster.getY());
            gameboard.board[monster.getX()][monster.getY()]=0;
            terminal.putCharacter(' ');
            terminal.applyBackgroundColor(Terminal.Color.DEFAULT);

            terminal.moveCursor(player.getX(),player.getY());
            terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
            terminal.putCharacter('C');
            gameboard.board[player.getX()][player.getY()] = 3;


            terminal.moveCursor(player2.getX(),player2.getY());
            gameboard.board[player2.getX()][player2.getY()] = 4;
            terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
            terminal.putCharacter('Y');



            key=terminal.readInput();
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

            terminal.moveCursor(20,0);
            s="Plaver 1: "+Integer.toString(p1);
            for (int i=0; i < s.length(); i++) {
                terminal.putCharacter(s.charAt(i));
            }
            terminal.putCharacter(' ');

            terminal.moveCursor(70,0);
            s="Player 2: "+Integer.toString(p2);
            for (int i=0; i < s.length(); i++) {
                terminal.putCharacter(s.charAt(i));
            }
            terminal.putCharacter(' ');

            terminal.moveCursor(43,30);
            s="Computer: "+Integer.toString(comp);
            for (int i=0; i < s.length(); i++) {
                terminal.putCharacter(s.charAt(i));
            }
            terminal.putCharacter(' ');

            terminal.moveCursor(49,0);
            s=Integer.toString(count);
            for (int i=0; i < s.length(); i++) {
                terminal.putCharacter(s.charAt(i));
            }
            terminal.putCharacter(' ');


        } while (key == null);

        switch (key.getCharacter()) {
            case 'S':
            case 's':
                if (gameboard.board[player.getX()][player.getY()+1] != 7) {
                    terminal.moveCursor(player.getX(),player.getY());
                    terminal.applyBackgroundColor(player1Color);
                    terminal.putCharacter(' ');
                    gameboard.board[player.getX()][player.getY()]=1;
                    player.setY(+1);
                    for (int i=0; gameboard.board[player.getX()][player.getY()+i] != 7; i++) {
                        terminal.moveCursor(player.getX(),player.getY()+i);
                        if (gameboard.board[player.getX()][player.getY()+i] == 4) {
                            gameboard.board[player2.getX()][player2.getY()]=1;
                            terminal.moveCursor(player2.getX(),player2.getY());
                            terminal.putCharacter(' ');
                            player2.setX(66);
                            player2.setY(20);
                        } else {
                            terminal.applyBackgroundColor(player1Color);
                            gameboard.board[player.getX()][player.getY()+i]=1;
                            terminal.putCharacter(' ');
                        }
                    }
                }
                break;
            case 'W':
            case 'w':
                if (gameboard.board[player.getX()][player.getY()-1] != 7) {
                    terminal.moveCursor(player.getX(),player.getY());
                    terminal.applyBackgroundColor(player1Color);
                    gameboard.board[player.getX()][player.getY()]=1;
                    terminal.putCharacter(' ');
                    player.setY(-1);
                    for (int i=0; gameboard.board[player.getX()][player.getY()-i] != 7; i++) {
                        terminal.moveCursor(player.getX(),player.getY()-i);
                        if (gameboard.board[player.getX()][player.getY()-i] == 4) {
                            gameboard.board[player2.getX()][player2.getY()]=1;
                            terminal.moveCursor(player2.getX(),player2.getY());
                            terminal.putCharacter(' ');
                            player2.setX(66);
                            player2.setY(20);
                        } else {
                            terminal.applyBackgroundColor(player1Color);
                            gameboard.board[player.getX()][player.getY()-i]=1;
                            terminal.putCharacter(' ');
                        }
                    }
                }
                break;
            case 'A':
            case 'a':
                if (gameboard.board[player.getX()-1][player.getY()] != 7) {
                    terminal.moveCursor(player.getX(),player.getY());
                    terminal.applyBackgroundColor(player1Color);
                    gameboard.board[player.getX()][player.getY()]=1;
                    terminal.putCharacter(' ');
                    player.setX(-1);
                    for (int i=0; gameboard.board[player.getX()-i][player.getY()] != 7; i++) {
                        terminal.moveCursor(player.getX()-i,player.getY());
                        if (gameboard.board[player.getX()-i][player.getY()] == 4) {
                            gameboard.board[player2.getX()][player2.getY()]=1;
                            terminal.moveCursor(player2.getX(),player2.getY());
                            terminal.putCharacter(' ');
                            player2.setX(66);
                            player2.setY(20);
                        } else {
                            terminal.applyBackgroundColor(player1Color);
                            gameboard.board[player.getX()-i][player.getY()]=1;
                            terminal.putCharacter(' ');
                        }
                    }
                }
                break;
            case 'D':
            case 'd':
                if (gameboard.board[player.getX()+1][player.getY()] != 7) {
                    terminal.moveCursor(player.getX(),player.getY());
                    terminal.applyBackgroundColor(player1Color);
                    gameboard.board[player.getX()][player.getY()]=1;
                    terminal.putCharacter(' ');
                    player.setX(+1);
                    for (int i=0; gameboard.board[player.getX()+i][player.getY()] != 7; i++) {
                        terminal.moveCursor(player.getX()+i,player.getY());
                        if (gameboard.board[player.getX()+i][player.getY()] == 4) {
                            gameboard.board[player2.getX()][player2.getY()]=1;
                            terminal.moveCursor(player2.getX(),player2.getY());
                            terminal.putCharacter(' ');
                            player2.setX(66);
                            player2.setY(20);
                        } else {
                            terminal.applyBackgroundColor(player1Color);
                            gameboard.board[player.getX()+i][player.getY()]=1;
                            terminal.putCharacter(' ');
                        }
                    }
                }
                break;
            case 'I':
            case 'i':
                if (gameboard.board[player2.getX()][player2.getY()-1] != 7) {
                    terminal.moveCursor(player2.getX(),player2.getY());
                    terminal.applyBackgroundColor(player2Color);
                    gameboard.board[player2.getX()][player2.getY()]=2;
                    terminal.putCharacter(' ');
                    player2.setY(-1);
                }
                for (int i=0; gameboard.board[player2.getX()][player2.getY()-i] != 7; i++) {
                    terminal.moveCursor(player2.getX(),player2.getY()-i);
                    if (gameboard.board[player2.getX()][player2.getY()-i] == 3) {
                        gameboard.board[player.getX()][player.getY()]=2;
                        terminal.moveCursor(player.getX(),player.getY());
                        terminal.putCharacter(' ');
                        player.setX(34);
                        player.setY(9);
                    } else {
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()][player2.getY()-i]=2;
                        terminal.putCharacter(' ');
                    }
                }
                break;
            case 'K':
            case 'k':
                if (gameboard.board[player2.getX()][player2.getY()+1] != 7) {
                    terminal.moveCursor(player2.getX(),player2.getY());
                    terminal.applyBackgroundColor(player2Color);
                    gameboard.board[player2.getX()][player2.getY()]=2;
                    terminal.putCharacter(' ');
                    player2.setY(+1);
                }
                for (int i=0; gameboard.board[player2.getX()][player2.getY()+i] != 7; i++) {
                    terminal.moveCursor(player2.getX(),player2.getY()+i);
                    if (gameboard.board[player2.getX()][player2.getY()+i] == 3) {
                        gameboard.board[player.getX()][player.getY()]=2;
                        terminal.moveCursor(player.getX(),player.getY());
                        terminal.putCharacter(' ');
                        player.setX(34);
                        player.setY(9);

                    } else {
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()][player2.getY()+i]=2;
                        terminal.putCharacter(' ');
                    }
                }
                break;
            case 'J':
            case 'j':
                if (gameboard.board[player2.getX()-1][player2.getY()] != 7) {
                    terminal.moveCursor(player2.getX(),player2.getY());
                    terminal.applyBackgroundColor(player2Color);
                    gameboard.board[player2.getX()][player2.getY()]=2;
                    terminal.putCharacter(' ');
                    player2.setX(-1);

                }
                for (int i=0; gameboard.board[player2.getX()-i][player2.getY()] != 7; i++) {
                    terminal.moveCursor(player2.getX()-i,player2.getY());
                    if (gameboard.board[player2.getX()-i][player2.getY()] == 3) {
                        gameboard.board[player.getX()][player.getY()]=2;
                        terminal.moveCursor(player.getX(),player.getY());
                        terminal.putCharacter(' ');
                        player.setX(34);
                        player.setY(9);
                    } else {
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()-i][player2.getY()]=2;
                        terminal.putCharacter(' ');
                    }
                }

                break;
            case 'L':
            case 'l':
                if (gameboard.board[player2.getX()+1][player2.getY()] != 7) {
                    terminal.moveCursor(player2.getX(),player2.getY());
                    terminal.applyBackgroundColor(player2Color);
                    gameboard.board[player2.getX()][player2.getY()]=2;
                    terminal.putCharacter(' ');
                    player2.setX(+1);
                }
                for (int i=0; gameboard.board[player2.getX()+i][player2.getY()] != 7; i++) {
                    terminal.moveCursor(player2.getX()+i,player2.getY());
                    if (gameboard.board[player2.getX()+i][player2.getY()] == 3) {
                        gameboard.board[player.getX()][player.getY()]=2;
                        terminal.moveCursor(player.getX(),player.getY());
                        terminal.putCharacter(' ');
                        player.setX(34);
                        player.setY(9);

                    } else {
                        terminal.applyBackgroundColor(player2Color);
                        gameboard.board[player2.getX()+i][player2.getY()]=2;
                        terminal.putCharacter(' ');
                    }
                }
                break;
            case 'Q':
            case 'q':
                System.exit(0);
                break;
        }

        terminal.moveCursor(player.getX(),player.getY());
        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
//        gameboard.board[player2.getX()][player2.getY()] = 3;
        terminal.putCharacter('C');

        terminal.moveCursor(player2.getX(),player2.getY());
//        gameboard.board[player2.getX()][player2.getY()] = 4;
        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
        terminal.putCharacter('Y');

        terminal.moveCursor(monster.getX(),monster.getY());
        gameboard.board[monster.getX()][monster.getY()]=0;
        terminal.putCharacter(' ');
        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
//            terminal.putCharacter('\u15E3');

    }
}




