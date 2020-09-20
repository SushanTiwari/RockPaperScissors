# RockPaperScissors
Project Description: 
To design a program that simulates players in a Rock Paper Scissors game using multiple threads of execution.
This game is a hand game played by 2 players. The hand formation determines the rock paper scissor on actual game
and winner is determined by the rule which is Scissor beats paper, paper beats rock and rock beats scissors.
We generate random value for each object and create a java program for the game. This program runs for 2 players 
and for as many rounds as user wants. This program requires multi threading to use threads to represent players 
and the use of synchronized, wait, and notify/notifyAll keywords to keep threads on organized.
A graph showing result statistics is displayed too. 

Class Listings:

RunGame: Contains main of the program where user can give input to number of players and rounds

Round: Determines the win or lose or draw of individual player and prints result

Player: Random selection of Rock, Paper or Scissors by player

BarGraph: Java applet for the bar chart for no of times of Rock, Paper, Scissors or Draws occurrence


Function Listing and Descriptions

getPlayers(): An int function that returns number of players

getRounds():An int function that returns returns number of rounds

getRock(): An int function that returns no of time rock wins game

getDraw():An int function that returns no of time game is drawn

getScissors():An int function that returns no of time Scissors wins game

getPaper(): An int function that returns no of time Paper wins game

roundDraw():A boolean function to check whether the present is a draw

printMove(String s): A void function function to print output of rounds

FindWinner(int playerId,int id): A void function for winner decision

printResult(): A void function to print the results

finalInfo():A void function to print the summary and stats

getOption(): A string to retrieve the option of player
