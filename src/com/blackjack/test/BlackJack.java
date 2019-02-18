package com.blackjack.test;
//Author: Lucas Webb
//Date: 12/10/2015
//Assignment: BlackGame Game Semester Project
import com.blackjack.webb.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class BlackJack 
{
    public static void main(String[] args) throws IOException 
    {
        boolean game; // Has to return a value after each turn(So if player busts, the game/loop will end.)
        game = playGame();
    }
    
    public static boolean playGame() throws IOException
    {
        String userInput = "";
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
          
    
        Scanner keyboard = new Scanner(System.in);
        //Scanner sc = new Scanner(new File("/data/cards"));
         
        System.out.println("\t\t\t\t\t" + "Welcome to Lucas' BLACKJACK !!! " + "\n");
        System.out.println("\t\t\t\t\t\t" + "Rules:" + "\n");
        System.out.println("\t\t\t\t\t" + "Each player draws two cards.." + "\n");
        System.out.println("\t\t\t\t\t" + "Depending on card's value, The user is asked to Hit(H) or Stay(S)" + "\n");
        System.out.println("\t\t\t\t\t" + "Card Values are as follows..." + "\n");
        System.out.println("\t\t\t\t\t" + "King,Queen,Jack,10 all value to 10!" + "\n");
        System.out.println("\t\t\t\t\t" + "Ace is a 1, unless your hand value's to 10" + "\n");
        System.out.println("\t\t\t\t\t" + "Suit does not affect the value." + "\n");
          
        System.out.println("Enter player's name: ");
        userInput = keyboard.nextLine();
          
        //Game Initiate!
          
        deck.Shuffle();
        //Rotate card draws
        dealerHand.addCard(deck.DealCard());
          
        playerHand.addCard(deck.DealCard());
          
        dealerHand.addCard(deck.DealCard());
          
        playerHand.addCard(deck.DealCard());
          
        //If automatic Blackjack
        if (dealerHand.getValue()==21) 
        {
              
            System.out.println("Dealer has a " + dealerHand.getCard(0)
                                + " and the " + dealerHand.getCard(1));
            System.out.println("User has a " + playerHand.getCard(0)
                                + " and a " + playerHand.getCard(1) + "\n");
            System.out.println("Dealer has Blackjack.  Dealer wins.");
            return false;
        }
          
        if (playerHand.getValue()==21) 
        {
            System.out.println("Dealer has a " + dealerHand.getCard(0)
                    + " and the " + dealerHand.getCard(1));
            System.out.println("User has a " + playerHand.getCard(0)
                    + " and the " + playerHand.getCard(1) + "\n");
            System.out.println();
            System.out.println(userInput + " has Blackjack." + userInput + " wins.");
            return true;
        }
   
        while (true) 
        {
            System.out.println("Cards in your hand:");
            for (int i=0;i<playerHand.getCardCount();i++)
                System.out.println("---" + playerHand.getCard(i) + "---");
            System.out.println("Total of your hand: " + playerHand.getValue() + "\n");
            System.out.println("Dealer's initial card is " + "\n" + dealerHand.getCard(0) + "\n");
            
            System.out.print("Hit (H) or Stand (S)? ");
            
            char choice;
            do 
            {
                //userAction = Character.toUpperCase( TextIO.getlnChar(0) );
                //userAction = keyboard.nextLine().charAt(0).toUpperCase(); <---- COULD NOT GET .toUpperCase() TO WORK!
                choice = keyboard.nextLine().charAt(0);
                if (choice !='H' && choice !='S')
                {
                    System.out.print("ERROR! Please respond H or S: (Capital)  "); //Validation
                }
            } 
            while (choice !='H' && choice !='S'); //Validation
    
            if (choice=='S') 
            {
                //Player breaks out of switch statement immediately to go to the next part of loop!
                break;
            }
            else 
            {
                Card newCard = deck.DealCard();
                playerHand.addCard(newCard);
                System.out.println("\n" + "You hit" + "\n");
                System.out.println("Your new card is the " + newCard);
                System.out.println("Your total is now " + playerHand.getValue());
                if (playerHand.getValue()>21)
                {
                    System.out.println("Busted! You lost.");
                    //Out of loop! Game over.
                    return false;
                }
            }  
        }
        System.out.println("\n" + "User stands.");
        System.out.println("(Dealer deals a new card)");
        
        System.out.println("Dealer's cards are now:");
        System.out.println("++++ " + dealerHand.getCard(0) + " ++++");
        System.out.println("++++ " + dealerHand.getCard(1) + " ++++");
        while (dealerHand.getValue()<=16) 
        {
            Card newCard = deck.DealCard();
            System.out.println("Dealer hits and gets the " + newCard);
            dealerHand.addCard(newCard);
            if (dealerHand.getValue()>21) 
            {
               System.out.println("Dealer busted by going over 21. YOU WON!");
               return true;
            }
        }
        System.out.println("Dealer's total is " + dealerHand.getValue());
     
        if (dealerHand.getValue() == playerHand.getValue()) 
        {
            System.out.println("\n" + "Dealer wins on a tie.  You lose.");
            return false;
        }
        else if (dealerHand.getValue() > playerHand.getValue()) 
        {
            System.out.println("DEALER WON!" + "\n" + dealerHand.getValue() 
                            + " to " + playerHand.getValue() + ".");
            System.out.println("Better luck next game, " + userInput);
            return false;
        }
        else 
        {
            System.out.println(userInput + ", YOU WIN!" + "\n "+ playerHand.getValue() 
                            + " to " + dealerHand.getValue() + ".");
            return true;
        }
    }
}
