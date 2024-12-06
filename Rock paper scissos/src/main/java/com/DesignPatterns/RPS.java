package com.DesignPatterns;

import java.util.Random;

//backend
public class RPS {

    //all the possible choices for the computer
    private static final String[] computerChoices = {"Rock", "Paper", "Scissors"};

    //store the computer choice so that we can retreive the value and display it to the frontend
    private String computerChoice;

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }


    //store the scores so that we can retreive the value and display it to the frontend
    private int computerScore,playerScore;

    //random number generator for computer's choice'
    private Random random;

    public RPS() {
        random = new Random();
    }

    //call this method to begin playing rock paper scissors
    //playerChoice - is  the choice made by the player (i.e. rock, paper or scissors)
    //this method will return  the result of the game( i.e. computer win, player win, draw)
    public String playRPS( String playerChoice) {
        //generate computer choices
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        //will contain the returning message indicating the result of the game
        String result;
        //evaluate the winner
        if (computerChoice.equals("Rock")){
            if (playerChoice.equals("Paper")){
                result = "Players wins!";
                playerScore++;
            } else if (playerChoice.equals("Scissors")){
                result = "computer wins!";
                computerScore++;
            } else {
                result = "It's a draw!";
            }
        }else if (computerChoice.equals("Paper")){
            if (playerChoice.equals("Scissors")){
                result = "Players wins!";
                playerScore++;
            } else if (playerChoice.equals("Rock")){
                result = "computer wins!";
                computerScore++;
            } else {
                result = "It's a draw!";
            }
        }else{//compputer plays scissors
            if (playerChoice.equals("Rock")){
                result = "Players wins!";
                playerScore++;
            } else if (playerChoice.equals("Paper")){
                result = "computer wins!";
                computerScore++;
            } else {
                result = "It's a draw!";
            }
        }

        return result;

    }
}
