import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import javax.print.event.PrintEvent;

public  class snake {
    public static class Worm {
        ArrayList<Coordinate> worm = new ArrayList<Coordinate>();
    }
    static boolean check(Worm kerm, int i, int j){
        for(int w = 0; w < kerm.worm.size(); w++){
            if( kerm.worm.get(w).x == i && kerm.worm.get(w).y == j ){
                return true;
            }       
        }
        return false;
    }
    static void kossher(){
        System.out.println("Man injam!");
    }

    static boolean isThereAccident(Worm kerm, int xx, int yy){
        for( int i = 0; i < kerm.worm.size()-1; i++){
            if( kerm.worm.get(i).x == xx &&  kerm.worm.get(i).y == yy){
                return true;
            }
        }
        return false;
    }


    static boolean isInputValid(Worm kerm, char input){
        if(input== 's'){
            if( kerm.worm.get(kerm.worm.size()-1).y == kerm.worm.get(kerm.worm.size()-2).y  && kerm.worm.get(kerm.worm.size()-1).x == kerm.worm.get(kerm.worm.size()-2).x -1 ) {
                return false;
            }
        }
        if(input== 'w'){
            if( kerm.worm.get(kerm.worm.size()-1).y == kerm.worm.get(kerm.worm.size()-2).y  && kerm.worm.get(kerm.worm.size()-1).x == kerm.worm.get(kerm.worm.size()-2).x +1 ) {
                return false;
            }
        }
        if(input== 'd'){
            if( kerm.worm.get(kerm.worm.size()-1).y == kerm.worm.get(kerm.worm.size()-2).y - 1  && kerm.worm.get(kerm.worm.size()-1).x == kerm.worm.get(kerm.worm.size()-2).x ) {
                return false;
            }
        }
        if(input== 'a'){
            if( kerm.worm.get(kerm.worm.size()-1).y == kerm.worm.get(kerm.worm.size()-2).y + 1  && kerm.worm.get(kerm.worm.size()-1).x == kerm.worm.get(kerm.worm.size()-2).x ) {
                return false;
            }
        }
        
        return true; 
    }


    static boolean isGameOver(Worm kerm, char input, int size){
        // if(input== 's' && (kerm.worm.get(kerm.worm.size()-1).x + 1 == size  || isThereAccident(kerm, kerm.worm.get(kerm.worm.size()-1).x + 1 , kerm.worm.get(kerm.worm.size()-1).y))  ){
        //     kossher();
        //     return true;
        // }
        // if(input== 'w' && (kerm.worm.get(kerm.worm.size()-1).x - 1 == -1   || isThereAccident(kerm, kerm.worm.get(kerm.worm.size()-1).x - 1, kerm.worm.get(kerm.worm.size()-1).y)  )  ){
        //     kossher();
        //     return true;
        // }
        // if(input== 'a' && (kerm.worm.get(kerm.worm.size()-1).y - 1 == -1  || isThereAccident(kerm, kerm.worm.get(kerm.worm.size()-1).x , kerm.worm.get(kerm.worm.size()-1).y - 1))){
        //     kossher();
        //     return true;
        // }
        // if(input== 'd' && (kerm.worm.get(kerm.worm.size()-1).y + 1 == size || isThereAccident(kerm, kerm.worm.get(kerm.worm.size()-1).x, kerm.worm.get(kerm.worm.size()-1).y + 1))){
        //     kossher();
        //     return true;
        // }
        for( int i = 0; i < kerm.worm.size()-1; i++){
            if( kerm.worm.get(i).x == kerm.worm.get(kerm.worm.size() - 1).x &&  kerm.worm.get(i).y == kerm.worm.get(kerm.worm.size() - 1).y){
                return true;
            }
        }
        return false;
    }


    static boolean inputHandler(Worm kerm, char input, int size, Coordinate food){
        // for(int i=0; i< kerm.worm.size() -1; i++){
        //      kerm.worm.get(i).x =  kerm.worm.get(i+1).x;
        //      kerm.worm.get(i).y =  kerm.worm.get(i+1).y;
        // }
        // if(kerm.worm.size() == (size-1)*(size-1) ){
        //     return false;
        // }
        if(input== 's'){
            if( kerm.worm.get(kerm.worm.size()-1).x + 1 == food.x &&  kerm.worm.get(kerm.worm.size()-1).y == food.y){
                kerm.worm.add(food);
                //kerm.worm.get(kerm.worm.size()-1).x = kerm.worm.get(kerm.worm.size()-1).x + 1; 
                return true;
            }
            for(int i=0; i< kerm.worm.size() -1; i++){
                kerm.worm.get(i).x =  kerm.worm.get(i+1).x;
                kerm.worm.get(i).y =  kerm.worm.get(i+1).y;
            }
            kerm.worm.get(kerm.worm.size()-1).x = kerm.worm.get(kerm.worm.size()-1).x + 1;   
        }
        if(input== 'w'){
            if( kerm.worm.get(kerm.worm.size()-1).x - 1 == food.x && kerm.worm.get(kerm.worm.size()-1).y == food.y){
                kerm.worm.add(food);
                //kerm.worm.get(kerm.worm.size()-1).x = kerm.worm.get(kerm.worm.size()-1).x - 1;
                return true;
            }
            for(int i=0; i< kerm.worm.size() -1; i++){
                kerm.worm.get(i).x =  kerm.worm.get(i+1).x;
                kerm.worm.get(i).y =  kerm.worm.get(i+1).y;
            }
            kerm.worm.get(kerm.worm.size()-1).x = kerm.worm.get(kerm.worm.size()-1).x - 1;
        }
        if(input== 'a'){
            if( kerm.worm.get(kerm.worm.size()-1).y - 1 == food.y && kerm.worm.get(kerm.worm.size()-1).x == food.x){
                kerm.worm.add(food);
                //kerm.worm.get(kerm.worm.size()-1).y = kerm.worm.get(kerm.worm.size()-1).y - 1;
                return true;
            }
            for(int i=0; i< kerm.worm.size() -1; i++){
                kerm.worm.get(i).x =  kerm.worm.get(i+1).x;
                kerm.worm.get(i).y =  kerm.worm.get(i+1).y;
            }
            kerm.worm.get(kerm.worm.size()-1).y = kerm.worm.get(kerm.worm.size()-1).y - 1;
        }
        if(input== 'd'){
            if( kerm.worm.get(kerm.worm.size()-1).y + 1 == food.y && kerm.worm.get(kerm.worm.size()-1).x == food.x ){
                kerm.worm.add(food);
                //kerm.worm.get(kerm.worm.size()-1).y = kerm.worm.get(kerm.worm.size()-1).y + 1;
                return true;
            }
            for(int i=0; i< kerm.worm.size() -1; i++){
                kerm.worm.get(i).x =  kerm.worm.get(i+1).x;
                kerm.worm.get(i).y =  kerm.worm.get(i+1).y;
            }
            kerm.worm.get(kerm.worm.size()-1).y = kerm.worm.get(kerm.worm.size()-1).y + 1;
        }
        return false;
    }




    static Coordinate distributeFood(int size, Worm kerm){
        Random random = new Random();
        int X = 0;
        int Y = 0;
        while ( (X==0 || Y==0) || check(kerm, X,Y)){
            Y = random.nextInt(size-1);
            X = random.nextInt(size-1);
        }
        Coordinate res= new Coordinate(X,Y);
        // System.out.println(X);   
        // System.out.println(Y);   
        return res;
   
    }
    static void  displayField (char[][] f,int size, Worm kerm, Coordinate ghaza){
        //System.out.println(kerm.worm.size());
        int kir = 0;
        for(int i=0; i<size; i++){
            System.out.println();
            for(int j=0; j< size;j++){
                if (check(kerm, i, j)){
                    kir = kir +1;
                    System.out.print('O');
                }
                else if(ghaza.x == i && ghaza.y == j){
                    System.out.print('@');
                }
                else {
                    System.out.print(f[i][j]);
                }
            }
        }
        //System.out.println(kir);
        // for(int m = 0; m<kerm.worm.size(); m++){
        //     System.out.println(kerm.worm.get(m).x);
        //     System.out.println(kerm.worm.get(m).y);
        // }
    }
    public static void main(String[] args) {
        int size = 0;
        // Prints "Hello, World" to the terminal window.
        //System.out.println("Hello, World");
        try {
            File myObj = new File("diff.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String difficulty = myReader.nextLine();
              System.out.println(difficulty);
              if(difficulty.equals("easy") ){
                size = 10;
              }
              else if (difficulty.equals("medium")){
                  size = 15;
              }
              else{
                  size = 18;
              }
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          
          Worm player = new Worm();
          Coordinate tail = new Coordinate(1, 1);
          Coordinate mid = new Coordinate(1, 2);
          Coordinate head = new Coordinate(1, 3);
          player.worm.add(tail);
          player.worm.add(mid);
          player.worm.add(head);
          char [][] field = new char[size][size] ; 
          for (int i = 0; i < size; i++){
              for(int j = 0; j < size; j++ ){
                  if( i==0 || i==(size-1) || j==0 || j==(size-1)){
                      field[i][j] = '#';
                  }
                  else{
                    field[i][j] = ' ';
                  }
              }
          }
          Coordinate food = distributeFood(size,player);
          displayField(field, size, player, food);
          inputHandler(player, 's',size,food);
          displayField(field, size, player, food);
          // System.out.println(player.worm.get(0).x);
          
          while (true){
            System.out.println("\nEnter move[w/a/s/d]");
            Scanner inp= new Scanner(System.in); 
            // try{
            //     Thread.sleep(2000);
            //     Thread threadA1 = new Thread(runA, "A");
            //     threadA1.start();
            // }
            // catch (InterruptedException x){

            // }
            char move = inp.next().charAt(0);
            if(move == 'z'){break;}
            if(!isInputValid(player, move)){
               // System.out.println("kir 2 in shans");
                break;
            }
            if (inputHandler(player, move,size,food)){
                food = distributeFood(size, player);
            }

            displayField(field, size, player, food);
            if(isGameOver(player, move,size)){
                break;
            }
          }
    }

}