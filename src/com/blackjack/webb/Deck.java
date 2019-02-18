package com.blackjack.webb;
// Author:Lucas Webb
// Description:BlackJack Game
import java.util.Random;
public class Deck 
{
    private Card[] deck = new Card[52]; // Beginning array with 52 cards
    private int used;
    
    //No-args constructor
    public Deck()
    {
       int count = 0;
       for(int suit=0;suit<= 3;suit++) 
       {
          for(int value=1;value<= 13;value++) 
          {
             deck[count] = new Card(value,suit);
             count++;
          }
       }
       used = 0;
    }
    //Constructor tha shuffles the deck
    public void Shuffle() 
    {
        for(int i=51;i>0;i--) 
        {
            Random rando = new Random();
            int rn = (int)(Math.random()*(i+1)); // Use Math. here.
            //rando = (int)((51)+i);
            Card BackToDeck = deck[i];
            deck[i] = deck[rn];
            deck[rn] = BackToDeck;
        }
        used = 0;
    }
    
    public Card DealCard() 
    {
        if (used==52)
        {
            Shuffle();
        }
        used++;
        return deck[used-1];
    }
}
