// Your First C++ Program

#include <iostream>
#include <string>
#include "snake.hpp"

std::string TakeGuessReturnString(std::string  current, std::string original, char guess) {
    if (original.find(guess) == std::string::npos) {
        return current;
    }
    for (int i = 0; i < original.length(); i++){
        if(original[i] == guess){
            current[i] = guess;
        }
    }
    return current; //
}

bool GameOver(std::string current){
    if (current.find('_') != std::string::npos) {
        return true;
    }
    return false;
}

// int main() {
//     std::string koon = "koon";
//     char g = 'o';
//     std::string empt = "____";
//     empt = TakeGuessReturnString(empt, koon, g);
    
//     std::cout << empt;
//     return 0;
// }