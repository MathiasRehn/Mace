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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x +=x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y +=y;
    }

    public void choosePath(int oldDir) {                         // 0=vä, 1=upp, 2=hög, 3=ner Monstermetod :O
        Random r = new Random();
        int newDir;
        if (Gameboard.board[(int) getX()-1][(int) getY()]==7 && Gameboard.board[(int) getX()][(int) getY()+1]!=7 &&                                         // Kurva öppen hög ner
                Gameboard.board[(int) getX()][(int) getY()-1] ==7 && Gameboard.board[(int) getX()+1][(int) getY()] !=7)  {
            newDir = r.nextInt(4);
            while (newDir == oldDir || newDir == 0 || newDir == 1) {
                newDir = r.nextInt(4);
            }
            switch (newDir) {
                case 0:
                    setX(-1);
                    setDir(0);
                    break;
                case 1:
                    setY(-1);
                    setDir(1);
                    break;
                case 2:
                    setX(1);
                    setDir(2);
                    break;
                case 3:
                    setY(1);
                    setDir(3);
                    break;
            }
        }

        else if (Gameboard.board[(int) getX()-1][(int) getY()]!=7 && Gameboard.board[(int) getX()][(int) getY()+1]!=7 &&                                         // Kurva öppen vän ner
                Gameboard.board[(int) getX()][(int) getY()-1] ==7 && Gameboard.board[(int) getX()+1][(int) getY()] ==7)  {

            newDir = r.nextInt(4);
            while (newDir==oldDir || newDir == 2 || newDir == 1) {
                newDir = r.nextInt(4);
            }
            switch (newDir) {
                case 0:
                    setX(-1);
                    setDir(0);
                    break;
                case 1:
                    setY(-1);
                    setDir(1);
                    break;
                case 2:
                    setX(1);
                    setDir(2);
                    break;
                case 3:
                    setY(1);
                    setDir(3);
                    break;
            }
        }

        else if (Gameboard.board[(int) getX()-1][(int) getY()]==7 && Gameboard.board[(int) getX()][(int) getY()+1]==7 &&                                         // Kurva öppen hög upp
                Gameboard.board[(int) getX()][(int) getY()-1] !=7 && Gameboard.board[(int) getX()+1][(int) getY()] !=7)  {
            newDir = r.nextInt(4);
            while (newDir==oldDir || newDir == 0 || newDir == 3) {
                newDir = r.nextInt(4);
            }
            switch (newDir) {
                case 0:
                    setX(-1);
                    setDir(0);
                    break;
                case 1:
                    setY(-1);
                    setDir(1);
                    break;
                case 2:
                    setX(1);
                    setDir(2);
                    break;
                case 3:
                    setY(1);
                    setDir(3);
                    break;
            }
        }

        else if (Gameboard.board[(int) getX()-1][(int) getY()]!=7 && Gameboard.board[(int) getX()][(int) getY()+1]==7 &&                                         // Kurva öppen vän upp
                Gameboard.board[(int) getX()][(int) getY()-1] !=7 && Gameboard.board[(int) getX()+1][(int) getY()] ==7)  {
            newDir = r.nextInt(4);
            while (newDir==oldDir || newDir == 2 || newDir == 1) {
                newDir = r.nextInt(4);
            }
            switch (newDir) {
                case 0:
                    setX(-1);
                    setDir(0);
                    break;
                case 1:
                    setY(-1);
                    setDir(1);
                    break;
                case 2:
                    setX(1);
                    setDir(2);
                    break;
                case 3:
                    setY(1);
                    setDir(3);
                    break;
            }
        }
        else if (Gameboard.board[(int) getX()-1][(int) getY()]!=7 && Gameboard.board[(int) getX()][(int) getY()+1]!=7 &&                                         // t-korsning st. hög
                Gameboard.board[(int) getX()][(int) getY()-1] !=7 && Gameboard.board[(int) getX()+1][(int) getY()] ==7)  {
            newDir = r.nextInt(4);
            while (newDir==oldDir || newDir == 2) {
                newDir = r.nextInt(4);
            }
            switch (newDir) {
                case 0:
                    setX(-1);
                    setDir(0);
                    break;
                case 1:
                    setY(-1);
                    setDir(1);
                    break;
                case 2:
                    setX(1);
                    setDir(2);
                    break;
                case 3:
                    setY(1);
                    setDir(3);
                    break;
            }
        }

        else if (Gameboard.board[(int) getX()-1][(int) getY()] ==7 && Gameboard.board[(int) getX()][(int) getY()+1]!=7 &&                                         // t-korsning st. vän
                Gameboard.board[(int) getX()][(int) getY()-1] !=7 && Gameboard.board[(int) getX()+1][(int) getY()] !=7)  {
            newDir = r.nextInt(4);
            while (newDir==oldDir || newDir == 0) {
                newDir = r.nextInt(4);
            }
            switch (newDir) {
                case 0:
                    setX(-1);
                    setDir(0);
                    break;
                case 1:
                    setY(-1);
                    setDir(1);
                    break;
                case 2:
                    setX(1);
                    setDir(2);
                    break;
                case 3:
                    setY(1);
                    setDir(3);
                    break;
            }
        }

        else if (Gameboard.board[(int) getX()-1][(int) getY()] !=7 && Gameboard.board[(int) getX()][(int) getY()+1]!=7 &&                                         // t-korsning st. upp
                Gameboard.board[(int) getX()][(int) getY()-1] ==7 && Gameboard.board[(int) getX()+1][(int) getY()] !=7)  {
            newDir = r.nextInt(4);
            while (newDir==oldDir || newDir == 1) {
                newDir = r.nextInt(4);
            }
            switch (newDir) {
                case 0:
                    setX(-1);
                    setDir(0);
                    break;
                case 1:
                    setY(-1);
                    setDir(1);
                    break;
                case 2:
                    setX(1);
                    setDir(2);
                    break;
                case 3:
                    setY(1);
                    setDir(3);
                    break;
            }
        }

        else if (Gameboard.board[(int) getX()-1][(int) getY()] !=7 && Gameboard.board[(int) getX()][(int) getY()+1]==7 &&                                         // t-korsning st. ner
                Gameboard.board[(int) getX()][(int) getY()-1] !=7 && Gameboard.board[(int) getX()+1][(int) getY()] !=7)  {
            newDir = r.nextInt(4);
            while (newDir==oldDir || newDir == 3) {
                newDir = r.nextInt(4);
            }
            switch (newDir) {
                case 0:
                    setX(-1);
                    setDir(0);
                    break;
                case 1:
                    setY(-1);
                    setDir(1);
                    break;
                case 2:
                    setX(1);
                    setDir(2);
                    break;
                case 3:
                    setY(1);
                    setDir(3);
                    break;
            }
        }

        else {
            newDir = r.nextInt(4);                                                                                                // KorsningnewDir = r.nextInt(3);
        }
        switch (newDir) {
            case 0:
                setX(-1);
                setDir(0);
                break;
            case 1:
                setY(-1);
                setDir(1);
                break;
            case 2:
                setX(1);
                setDir(2);
                break;
            case 3:
                setY(1);
                setDir(3);
                break;
        }
    }


    public void move() {

        if (getDir() == 0)
            moveLeft();
        else if(getDir() ==1)
            moveUp();
        else if (getDir() ==2)
            moveRight();
        else if (getDir() ==3)
            moveDown();
    }

    public void moveLeft() {
        setDir(0);
        if (Gameboard.board[(int) getX()-1][(int) getY()]!=7 && Gameboard.board[(int) getX()][(int) getY()+1]==7 && Gameboard.board[(int) getX()][(int) getY()-1] ==7) {
            setX(-1);
        }
        else if (Gameboard.board[(int) getX()-1][(int) getY()]==7 && Gameboard.board[(int) getX()][(int) getY()+1]==7 && Gameboard.board[(int) getX()][(int) getY()-1] ==7) {
            moveRight();
        }
        else {
            choosePath(2);
        }
    }

    public void moveUp() {
        setDir(1);
        if (Gameboard.board[(int) getX()-1][(int) getY()]==7 && Gameboard.board[(int) getX()][(int) getY()-1]!=7 && Gameboard.board[(int) getX()+1][(int) getY()] ==7) {
            setY(-1);
        }
        else if (Gameboard.board[(int) getX()-1][(int) getY()]==7 && Gameboard.board[(int) getX()+1][(int) getY()]==7 && Gameboard.board[(int) getX()][(int) getY()-1] ==7) {
            moveDown();
        }
        else {
            choosePath(3);
        }
    }
    public void moveRight() {
        setDir(2);
        if (Gameboard.board[(int) getX()+1][(int) getY()]!=7 && Gameboard.board[(int) getX()][(int) getY()-1]==7 && Gameboard.board[(int) getX()][(int) getY()+1] ==7) {
            setX(1);
        }
        else if (Gameboard.board[(int) getX()+1][(int) getY()]==7 && Gameboard.board[(int) getX()][(int) getY()+1]==7 && Gameboard.board[(int) getX()][(int) getY()-1] ==7) {
            moveLeft();
        }
        else {
            choosePath(0);
        }
    }

    public void moveDown() {
        setDir(3);
        if (Gameboard.board[(int) getX()+1][(int) getY()]==7 && Gameboard.board[(int) getX()][(int) getY()+1]!=7 && Gameboard.board[(int) getX()-1][(int) getY()] ==7) {
            setY(1);
        }
        else if (Gameboard.board[(int) getX()+1][(int) getY()]==7 && Gameboard.board[(int) getX()-1][(int) getY()]==7 && Gameboard.board[(int) getX()][(int) getY()+1] ==7) {
            moveUp();
        }
        else {
            choosePath(1);
        }
    }

}
