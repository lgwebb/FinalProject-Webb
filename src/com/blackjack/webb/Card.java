package com.blackjack.webb;
// Author:Lucas Webb
// Description:BlackJack Game
public class Card 
{
    public final static int s = 0, h = 1, d = 2, c = 3;                      
    public final static int ace = 1, jack = 11, queen = 12, king = 13;  
    private final int valueOfCard;
    private final int suit;
                             
    public Card(int val, int s) 
    {
        valueOfCard = val;
        suit = s;
    }
        
    public int getSuit() 
    {
        return suit;
    }
    
    public int getValue() 
    {
        return valueOfCard;
    }
    
    public String getSuitToString() 
    {
        switch(suit) 
        {
            case s:   
                return "Spades";
            case h:  
                return "Hearts";
            case d: 
                return "Diamonds";
            case c:    
                return "Clubs";
        }
        return null;
    }
    
    public String getValueToString() 
    {
        switch(valueOfCard) 
        {
           case 1:   
               return "Ace";
           case 2:   
               return "2";
           case 3:   
               return "3";
           case 4:   
               return "4";
           case 5:   
               return "5";
           case 6:   
               return "6";
           case 7:   
               return "7";
           case 8:   
               return "8";
           case 9:   
               return "9";
           case 10:  
               return "10";
           case 11:  
               return "Jack";
           case 12:  
               return "Queen";
           case 13:  
               return "King";
        }
        return null;
    }
    
    public String toString() 
    {
        return getValueToString() + " of " + getSuitToString();
    }
}
