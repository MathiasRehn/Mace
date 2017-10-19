package com.company;

public class Player {
    private int x;
    private int y;


    public Player(int x,int y) {
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x == 66) {
            this.x=x;
        } else {
            this.x+=x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y == 9) {
            this.y=y;
        } else {
            this.y+=y;
        }
    }
}