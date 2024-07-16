
This project is a game aplication that takes a user input, which is used to provide a game for the useer. The games are Hangman and the Snake game. The languages integraded in the project are Python, C, Java. C is used to implement the necessary functions for the Hangman, and Java is used for implementing the Snake game. Python is used to take user input, and also used for writing the difficulty of the Snake game into a temporary file. Swig has been used for communication between C and Python. Python was used to write the difficulty of the Snake game into a temporary file, and then Java was used to read from that temporary file and store the difficulty. 

When inside the swig-demo run th e following commands in order:

swig -python -py3 example.i
gcc -fPIC -c example.c example_wrap.c -I/usr/include/python3.8
ld -shared example.o example_wrap.o -o _example.so
python3 Application.py

and when the difficulty is given in python the following commands should be typed in order:
javac snake.java
java snake  

The snake game can be played in 3 different grid sizes depending on the difficulty.   


