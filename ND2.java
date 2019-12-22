/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savaite1;

/**
 *
 * @author Bronius
 */
public class ND2 {
    public static void spausdintiLauka(int[][] board) {
        for (int y = 0; y < board.length; y++) {
            int[] line = board[y];
            for (int x = 0; x < line.length; x++) {
//                System.out.print(line[x]);
                    if(line[x]== 1) {
                        System.out.print("x");
                    }else{
                        System.out.print(".");
                    }
            }
            System.out.println();
        }
    }
    
    //metodas kitai lentelei
    public static void nextGeneration(int nextBoard[][], int c, int b){
        int[][] future = new int[c][b];
    //ciklas kiekvienam langeliui    
        for(int i=1; i<c-1; i++) {
            for(int t=1; t<b-1; t++) {
    //ieskomi gyvi kaimynai
                int aliveNeighboards = 0;
                for(int x=-1; x<=1; x++){
                    for(int y=-1; y<=1; y++){
                        aliveNeighboards += nextBoard[i+x][t+y];
//                        System.out.println("is viso " + aliveNeighboards);
                    }
                }
    //minusuojami gyvi kaimynai, kurie buvo prisumuoti jau nors neturejo buti
                aliveNeighboards -= nextBoard[i][t];
//                System.out.println("atimti " + aliveNeighboards);
                
    //Taisykles gyvenimui
                //Vienisas mirsta
                if((nextBoard[i][t] == 1) && (aliveNeighboards < 2)) {
                    future[i][t] = 0;
                //Mirsta, nes per didele populiacija
                }else if((nextBoard[i][t] == 1) && (aliveNeighboards > 3)) {
                    future[i][t] = 0;
                //naujas gyventojas gimsta
                }else if((nextBoard[i][t] == 0) && (aliveNeighboards == 3)) {
                    future[i][t] = 1;
                //visais kitais atvejais
                }else{
                    future[i][t] = nextBoard[i][t];
                }
            }       
        }
        System.out.println("Next Generation");
        for(int i=0; i<c; i++) {
            for(int t=0; t<b; t++) {
                if (future[i][t] == 0) {
                    System.out.print("."); 
                }else{
                    System.out.print("x");
                }
            } 
            System.out.println(); 
            }
        nextGeneration(future, c, b);
        }      
    
    public static void main(String[] args) {
        int dimension = 50;
        int[][] initBoard = new int[dimension][dimension];
        for (int y = 0; y < dimension; y++) {
            for (int x = 0; x < dimension; x++) {
                initBoard[y][x] = (Math.random() < 0.21) ? 1 : 0;
            }
        }


        spausdintiLauka(initBoard);
        System.out.println("-----------------------");
        nextGeneration(initBoard, dimension, dimension);
    }

}
