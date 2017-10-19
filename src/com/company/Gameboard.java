package com.company;

public class Gameboard {
    public static int HEIGHT=30;
    public static int WIDTH=100;
    public static int[][] board;

    public Gameboard() {
        board=new int[WIDTH][HEIGHT];
    }

    /*public void moveMonsterCloserToPlayer(Player player,Monster monster)
            throws InterruptedException {

        if (Math.abs(monster.getX()-player.getX()) > Math.abs(monster.getY()-player.getY())) {
            if (monster.getX() < player.getX()) {
                monster.setX(+0.1);

            } else if (monster.getX() > player.getX()) {
                monster.setX(-0.1);
            }
        }
        else {
             if (monster.getY() < player.getY()) {
            monster.setY(+0.1);

        }   else if (monster.getY() > player.getY()) {
            monster.setY(-0.1);
             }
        }


        if (monster.getX() == player.getX() && monster.getY() == player.getY()) {

        }


    }*/
}

