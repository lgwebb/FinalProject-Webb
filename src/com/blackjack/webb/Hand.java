package com.blackjack.webb;
// Author:Lucas Webb
// Description:BlackJack Game
import java.util.ArrayList;
import java.util.Vector; //Did not want to use Vector: Looked up as alternative to Arrays
import java.util.Collections;
public class Hand 
{
    private Vector hand;
    ArrayList<String> hands = new ArrayList<String>();
    ArrayList<String> cards = new ArrayList<String>();
    
   public Hand() 
   {
      hand = new Vector(); //Initialize hand
   }
   
   public void addCard(Card card) 
   {
      
      //     TROUBLE MAKING THIS FROM STRING
      //if(card != null)
      //{
      //    hands.add(hands);
      //}
       
      if (card!=null)
      {
          hand.addElement(card); //Vector's format of adding to Array.
      }
   }
   
   public int getCardCount() 
   {
       return hand.size();
   }
   
   public Card getCard(int position) 
   {
       if (position>=0 && position<hand.size())
           return (Card)hand.elementAt(position);
       else
           return null;
   }
   
   public int getValue()
   {
       boolean ace;
       
       int value;
       int cards;

       value = 0;
       ace = false;
       cards = getCardCount();
       for(int i=0;i<cards;i++) 
       {
           Card card;
           int cardVal;
           card = getCard(i);
           cardVal = card.getValue();
           if (cardVal>10) 
           {
               cardVal=10; //KING, QUEEN, JACK = 10!
           }
           if (cardVal==1)
           {
               ace = true;
           }
           value = value + cardVal;
        }
       
        if(ace==true && value+10<=21)
        {
            value = value + 10; //If there's an ace AND a card that's value is 10, Blackjack is over.
        }
        return value;
    }
}
