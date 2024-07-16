#include "example.h"
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
int escapes(double cr, double ci, int it) {
  double zr = 0;
  double zi = 0;
  double zrtmp;
  int i;
  
  for(i=0; i<it; i++) {
    // z <- z^2 + c
    zrtmp = zr*zr - zi*zi + cr;
    zi = 2*zr*zi + ci;
    zr = zrtmp;
    if (zr*zr + zi*zi > 4) {
      return 1;
    }
  }
  return 0;
}

int fact(int n) {
    if (n <= 1) return 1;
    else return n*fact(n-1);
}

bool GameOver( char* an){

    for(int i=0; i < strlen(an); i++){
      if(an[i]=='_'){
        return false;
      }
    }
    return true;
}

bool wrongGuess(char* original, char guess){
  for(int i = 0; i< strlen(original); i++){
    if(original[i]==guess){
      return false;
    }
  }
  return true;
}

char* TakeGuess(char* current, char * original, char guess){
    int i = 0;
    for (int j = 0; j < strlen(original); j++){
        if( original[j] == guess){
            current[j] = guess;
        }
    }
    return current;
}
