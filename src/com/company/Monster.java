package com.company;

import java.util.Random;

public class Monster {
    private int x;
    private int y;
    private int dir;

    public Monster (int x, int y, int dir) {
        this.x=x;
        this.y=y;
        this.dir=dir;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public void setX(double x) {
        this.x +=x;
    }

    public int getY() {
        return y;
    }

    public void setY(double y) {
        this.y +=y;
    }

    public void move() {
        Random r = new Random();
        if ((Gameboard.board[getX() - 1][getY()] != 7 && Gameboard.board[getX() + 1][getY()] == 7 && Gameboard.board[getX()][getY()+1] == 7 && Gameboard.board[getX()][getY()-1] == 7) ||
                (Gameboard.board[getX() - 1][getY()] == 7 && Gameboard.board[getX() + 1][getY()] != 7 && Gameboard.board[getX()][getY()+1] == 7 && Gameboard.board[getX()][getY()-1] == 7) ||  //kollar om det är en återvändsgränd
                (Gameboard.board[getX() - 1][getY()] == 7 && Gameboard.board[getX() + 1][getY()] == 7 && Gameboard.board[getX()][getY()+1] != 7 && Gameboard.board[getX()][getY()-1] == 7) ||
                (Gameboard.board[getX() - 1][getY()] == 7 && Gameboard.board[getX() + 1][getY()] == 7 && Gameboard.board[getX()][getY()+1] == 7 && Gameboard.board[getX()][getY()-1] != 7))
        {
            if (getDir()==0) {
                setDir(2);
                setX(1);
            }
            else if (getDir()==1) {
                setDir(3);
                setY(1);
            }
            else if (getDir()==2) {
                setDir(0);
                setX(-1);
            }
            else if (getDir()==3) {
                setDir(1);
                setY(-1);
            }
            return;
        }
        while (true){
            int newDir = r.nextInt(4);
            if (newDir == 0) {
                if (Gameboard.board[getX() - 1][getY()] != 7 && getDir() != 2) {
                    setX(-1);
                    setDir(0);
                    break;
                }
            }
            if (newDir == 1) {
                if (Gameboard.board[getX()][getY()-1] != 7 && getDir() != 3) {
                    setY(-1);
                    setDir(1);
                    break;
                }
            }
            if (newDir == 2) {
                if (Gameboard.board[getX()+1][getY()] != 7 && getDir() != 0) {
                    setX(1);
                    setDir(2);
                    break;
                }
            }
            if (newDir == 3) {
                if (Gameboard.board[getX()][getY()+1] != 7 && getDir() != 1) {
                    setY(1);
                    setDir(3);
                    break;
                }
            }
        }
        return;
    }
}
