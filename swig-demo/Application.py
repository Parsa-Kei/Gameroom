import example
import random
import os
# print(example.fact(10))
# s = "koon"
# curr = "____"
# print(example.GameOver(s))
# curr = example.TakeGuess(curr, s, 'o')
# print(curr)
option = 1
while option != 3:
    print("Please choose an option:")
    print("1: Hangman")
    print("2: Snake Game")
    option = input("3: Exit\n")

    if option == "1":
        numOfWrongGuesses = 0
        f = open("commonWords.txt", "r")
        word = ""
        n = random.randint(0,19911)
        for x in range(n):
            word = f.readline()
        #print(word)
        blank = ""
        for i in range(len(word)-1):
            blank = blank + '_'
        while( (not example.GameOver(blank)) and numOfWrongGuesses < 8):
            g = input("enter your guess:")
            if(example.wrongGuess(word,g[0])):
                numOfWrongGuesses = numOfWrongGuesses +1
            blank = example.TakeGuess(blank, word, g[0])
            print(blank)  
            print("Number of wrong guesses: "+ str(numOfWrongGuesses))
            print("8 wrong guesses and you are elimanated!")
        if (numOfWrongGuesses > 7):
            print("you lost HAHAHAHAHHAHA")
            print("this was the word " + word + "HAHAHAHAHAHAHAHA\n")
        else:
            print("Holy! how did you get so smart?\n")
        

    if option == "2":
        print("choose a difficulty from the following options type them exactly like they appear:")
        difficulty = input("easy/medium/hard:\n")
        # if os.path.isfile('diff.txt'):
        #     #open('diff.txt', 'w').close()
        #     f = open("sample.txt", "w")
        #     f.write(difficulty)
        #     f.close()
        # else:
        #     f = open("diff.txt", "x")
        #     f.write(difficulty)
        #     f.close()
        f = open("diff.txt", "w")
        f.write(difficulty)
        f.close()
        quit()
    if option == "3":
        print("chow")
        quit()
    

