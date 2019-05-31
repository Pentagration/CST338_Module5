/* Assignments:
CARDTABLE: Jason / Marcus
GUICARD: Colin / Sergio
CLEANUP EXISTING CARD / HAND / DECK: Adam to start
MAIN: likely we'll add to main as we are coding the others
*/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Random;

public class Phase2
{
   static int NUM_CARDS_PER_HAND = 7;
   static int NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
   
   public static void main(String[] args)
   {
      int k;
      Icon tempIcon;
      
      // establish main frame in which program will run
      CardTable myCardTable 
         = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // show everything to the user
      //myCardTable.setVisible(true);

      // CREATE LABELS ----------------------------------------------------
      //code goes here ...
      JLabel cpuHand = new JLabel("Computer");
      JLabel playerHand = new JLabel("Player");
      JLabel playArea = new JLabel("Table");
  
      // ADD LABELS TO PANELS -----------------------------------------
      //code goes here ...
      myCardTable.pnlComputerHand.add(cpuHand);
      myCardTable.pnlHumanHand.add(playerHand);
      myCardTable.pnlPlayArea.add(playArea);
      
      // and two random cards in the play region (simulating a computer/hum ply)
      //code goes here ...
      Card card1 = generateRandomCard();
      Card card2 = generateRandomCard();

      // show everything to the user
      myCardTable.setVisible(true);
      
      //from Asssign 3 main maybe?
      //static Card generateRandomCard();
      
   }
   
   static Card generateRandomCard()
   {
      Random rand1 = new Random();
      int value = rand1.nextInt(Card.cValue.length);
      
      Random rand2 = new Random();
      int suit = rand2.nextInt(Card.Suit.values().length);
      
      Card temp = new Card(Card.cValue[value], Card.Suit.values()[suit]);
      
      return temp;
   }
}

//START class CardTable
class CardTable extends JFrame
{
   static int MAX_CARDS_PER_HAND = 56;
   static int MAX_PLAYERS = 2;
   
   private int numCardsPerHand;
   private int numPlayers;
   
   //three panels that will appear in the GUI from top to bottom
   public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea, mainPanel;
   
   CardTable(String title, int numCardsPerHand, int numPlayers)
   {
      super(); //references the JFrame parent class objects
   
      this.setTitle(title);
      this.numCardsPerHand = numCardsPerHand;
      this.numPlayers = numPlayers;
      
      //Create play areas for computer (TOP), play area(MID), and human hand (BTM)
      this.mainPanel = new JPanel();
      this.pnlComputerHand = new JPanel();
      this.pnlPlayArea = new JPanel();
      this.pnlHumanHand = new JPanel();
      
      //Create the panel layout
      mainPanel.setLayout(new GridLayout(3,1)); //3 = rows, 1 = columns
      mainPanel.add(pnlComputerHand);
      mainPanel.add(pnlPlayArea);
      mainPanel.add(pnlHumanHand); 
      add(mainPanel);
   }
   
   //START accessors
   public int getnumCardsPerHand()
   {
      return this.numCardsPerHand;
   }
   
   public int getnumPlayers()
   {
      return this.numPlayers;
   }
   //END accessors
}
//END class CardTable

//START class GUICard
class GUICard
{
   //A 2-D array to store cards representation and point values
   //14 = A thru K + X (X = Joker)
   //4 = suits
   private static Icon[][] iconCards = new ImageIcon[14][4];
   private static Icon iconBack;
   static boolean inconsLoaded = false;
   
   static void loadCardIcons()
   {
   }
   
   static public Icon getIcon(Card card)
   {
   }
   
   static public Icon getBackCardIcon()
   {
   }
}   
//END class GUICard

//START class Card
/**
 * The Card class allows for the representation and manipulation of a single 
 * playing card as found in a standard 52 card deck.
 */
class Card
{
   /**
    * A public enum Suit stores the values of clubs, diamonds, hearts, spades;
    */
   public enum Suit
   {
      clubs, diamonds, hearts, spades;
   }
   
   /**
    * A public static final char cValue[] stores the values of each card 1-9 and 
    * T-A.  Ten is represented by 'T', not '10'.  
    */
   public static final char cValue[] = {'X', 'K', 'Q', 'J', 'T', '9', '8', '7', 
         '6', '5', '4', '3', '2', 'A'};
   public static char[] valuRanks = {'A', '2', '3', '4', '5', '6', '7', '8', 
         '9', 'T', 'J', 'Q', 'K', 'X'};
   private char value;
   private Suit suit;
   private boolean errorFlag;
   
   /**
    * There is a default Card constructor Card() that sets the card to
    * 'A', Suit.spades.  
    * 
    * There is a constructor Card(char value, Suit suit) that sets the card
    * according to the parameters.  
    * 
    * @param value = 'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4',
    * '3', '2'
    * 
    * @param suit = clubs, diamonds, hearts, spades
    */
   
   //Default constructor
   public Card()
   {
      this.set('A', Suit.spades);
   }
   
   //Constructor
   public Card(char value, Suit suit)
   {
      this.set(value, suit);
   }
   
   //START mutators
   /**
    * public boolean set(char value, Suit suit) checks that a valid card is 
    * being set.
    * 
    * @param value 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2', 'A'
    * @param suit clubs, diamonds, hearts, spades
    * @return this.errorflag true = error / bad card value
    */
   public boolean set(char value, Suit suit)
   {
      if(isValid(value, suit))
      {
         this.value = value;
         this.suit = suit;
         this.errorFlag = false;
      }
      else
      {
         this.errorFlag = true;
      }
      
      return this.errorFlag;
   }
   //END mutators

   //START accessors
   /**
    * There are three accessors in the Card class getSuit(), getValue(), and 
    * getErrorFlag().
    * @return this.suit, this.value, or this.errorFlag
    */
   public Suit getSuit()
   {
      return this.suit;
   }
   
   public char getValue()
   {
      return this.value;
   }
   
   public boolean getErrorFlag()
   {
      return this.errorFlag;
   }
   //END accessors
   
   /**
    * public boolean equals(Card card) returns true if all the fields are
    * identical and false otherwise.
    * 
    * @param card
    * @return true or false
    */
   public boolean equals(Card card)
   {
      boolean isEqual = false;
      
      if (this.getValue() == card.getValue() && this.getSuit() == card.getSuit()
            && this.getErrorFlag() == card.getErrorFlag())
      {
         isEqual = true;
      }
      return isEqual;
   }
   //END accessors
   
   /**
    * priate boolean isValid(char value, Suit suit) returns true if value is a
    * valid card value and false otherwise.
    * 
    * @param value
    * @param suit
    * @return true or false
    */
   private boolean isValid(char value, Suit suit)
   {
      boolean isValid = false;
      
      for (char index : cValue)
      {
         if (Character.toUpperCase(value) == index)
         {
            isValid = true;
         }
      }
      return isValid;
   }
   
   /** 
    * toString() concatenates the A thru 2 card value and the card suit into a
    * single string "value of suit" example: "A of clubs"
    * 
    * @param none
    * @return Returns a string
    */
   public String toString()
   {
      if(errorFlag == true)
      {
         return "[invalid]";
      }
      else
      {
         String card = Character.toUpperCase(value) + " of " + suit;
      return card;
      }
    } 
   
   static void arraySort(Card[] cArray, int arraySize)
   {
      int tempVal1 = 0;
      int tempVal2 = 0;
      
      for (int i = 0; i < arraySize - 1; i++)
      {
         for (int j = 0; j < arraySize - i - 1; j++)
         {
            for (int x = 0; x < valuRanks.length; x++)
            {
               if(valuRanks[x] == cArray[j].getValue())
               {
                  tempVal1 = x;
                  break;
               }
            }
            
            for (int y = 0; y < valuRanks.length; y++)
            {
               if(valuRanks[y] == cArray[j + 1].getValue())
               {
                  tempVal2 = y;
                  break;
               }
            }
            
            // should this be >= ?  If we have 887 for example, 8 !> 8, so 
            // nothing happens, but we would want to bubble up higher right?
            if (tempVal1 > tempVal2) 
            {
               Card temp = cArray[j];
               cArray[j] = cArray[j+1];
               cArray[j+1] = temp;
            }
         }
      }
   }
}
//END class Card

//START class Hand
/**
 * The Hand class represents the cards held by a single player
 */
class Hand
{
   public static final int MAX_CARDS = 52;
   
   private Card[] myCards;
   private int numCards;
   
   //Default constructor
   /**
    * There is a default Hand() constructor that creates an empty hand.  A hand
    * can hold no more than 52 cards, and the number of cards in the hand after
    * construction is 0.
    */
   public Hand()
   {
      this.myCards = new Card[MAX_CARDS];
      this.numCards = 0;
   }
   
   /**
    * public void resetHand() resets an existing hand to 0 cards.
    */
   public void resetHand()
   {
      this.numCards = 0;
   }
   
   /**
    * public boolean takeCard(Card card) puts a new card in the players hand
    * and also checks that taking a new card would not violate the MAX_CARDS
    * allowed in the hand, which is set to MAX_CARDS = 52 by the Hand constructor.
    * @param card
    * @return true or false
    */
   public boolean takeCard(Card card)
   {
      boolean newCard = false;
      
      //checking if hand size plus card drawn will put us over max size
      if (numCards + 1 <= MAX_CARDS) 
      {
         myCards[numCards] = new Card(card.getValue(), card.getSuit());
         this.numCards++;
         newCard = true;
      }     
      return newCard;
   }
   
   /**
    * public Card playCard() returns and removes the card in the top occupied 
    * position of the hand array.
    * @return a representation of the top card from the players hand
    */
   public Card playCard(int cardIndex)
   {
      if ( numCards == 0 ) //error
      {
         //Creates a card that does not work
         return new Card('M', Card.Suit.spades);
      }
      //Decreases numCards.
      Card card = myCards[cardIndex];
      
      numCards--;
      for(int i = cardIndex; i < numCards; i++)
      {
         myCards[i] = myCards[i+1];
      }
      
      myCards[numCards] = null;
      
      return card;
    }
   
   /**
    * toString() concatenates the cards in the hand into a single string.
    * 
    * @param none
    * @return Returns a string
    */
   public String toString()
   {
      int cardCounter = 0;
      int handCards = 0;
      StringBuilder hand = new StringBuilder("Hand = (");

      if (this.numCards > 0)
      {
         for (Card card:myCards)
         {
            if (card == null) 
            {
               break;
            }
            hand.append(card.toString());
            if(handCards < this.numCards - 1) 
            {
               hand.append(", ");
            }
            cardCounter++;
            handCards++;
            
            //if statement below formats the output onto multiple lines
            if (cardCounter % 5 == 0 && handCards != this.numCards)
            {
               hand.append("\n");
               cardCounter = 0;
            }
         }
      }      
      hand.append(")\n");
      return hand.toString();
   }
   
   /**
    * Getter getNumCards returns the number of cards currently in the hand
    * @return number of cards
    */
   public int getNumCards()
   {
      return this.numCards;
   }
   
   /**
   * inspectCard accesses individual card (k).
   * @param k an integer
   * @return card
   */
   public Card inspectCard(int k)
   {
      if (this.myCards[k] != null)
      {
         return this.myCards[k];
      }
      else
      {
         Card tempCard = new Card('z', Card.Suit.clubs);
         return tempCard;
      }
   }
   
   public void sort()
   {
      Card.arraySort(this.myCards, this.numCards);
   }
}
//END class Hand   

//START class Deck
/**
*Deck class holds all available cards for distribution to hands.
*/
class Deck
{
   public static final int MAX_CARDS = 6 * 56;
   
   private static Card[] masterPack = new Card[56];
   Card[] cards;
   int topCard;

   /**
   * Default Constructor 
   * Allocates Master pack and initializes one deck. 
   */
   public Deck()
   {
      allocateMasterPack();
      init(1);
   }

   /**
   * Secondary Constructor
   * Initializes set number of decks
   */
   public Deck(int numPacks)
   {
      allocateMasterPack();
      init(numPacks);
   }

   /**
   * init member function 
   * Initializes deck with correct number of instantiated cards. 
   * 
   * @param numPacks number of decks in integer form to use
   */
   public void init(int numPacks)
   {
      cards = new Card[numPacks * 52];
      for (int i = 0; i < numPacks; i++)
      {
         System.arraycopy(masterPack, 0, this.cards, i * masterPack.length,
            masterPack.length);
      }
      if ((numPacks * 52) > MAX_CARDS)
         topCard = MAX_CARDS - 1;
      else
         topCard = (numPacks * 52) - 1;
   }
   /**
   * shuffle method 
   * randomizes indices of existing cards in deck
   */
   public void shuffle() 
   {
      Random shuffle = new Random();
      
      for (int i=0; i < cards.length; i++) 
      {
         int randomIndex = i + shuffle.nextInt(cards.length - i);
         Card swap = cards[randomIndex];
         cards[randomIndex] = cards[i];
         cards[i] = swap;
      }
   }
   
   /**
   * dealCard returns a card while topCard is not negative, otherwise return 
   * null
   * @return a Card object
   */
   public Card dealCard()
   {
      if (topCard != -1) //since a card is stored at 0, deck is empty at -1
         return cards[topCard--];
      return null;
   }

   /**
   * getTopCard returns topCard integer
   * @return topCard in integer form
   */
   public int getTopCard()
   {
      return topCard;
   }
   /**
   * method inspectCard
   * @param k
   * @return a card with errorFlag = true if k is out of bounds
   * return card otherwise.
   */
   public Card inspectCard(int k)
   {
      if (k <= topCard)
         return cards[k];
      return new Card('X', Card.Suit.clubs);
   }

   /**
   * allocateMasterPack generates proper card values for the pack
   */
   private static void allocateMasterPack()
   {
      int k = 0; //for deck array number
      
      if (masterPack[0] != null)
         return;
      
      for (int i = 0; i < Card.Suit.values().length; i++)
      {
         for (int j = 0; j < Card.cValue.length; j++)
         {
            masterPack[k++] = new Card(Card.cValue[j], Card.Suit.values()[i]);
         }
      }
   }
   
   public boolean addCard(Card card)
   {
      //make sure that there are not too many instances of the card in the 
      //deck if you add it.  Return false if there will be too many.  It should 
      //put the card on the top of the deck.
   }
   
   public boolean removeCard(Card card)
   {
      //you are looking to remove a specific card from the deck.  Put the 
      //current top card into its place.  Be sure the card you need is actually 
      //still in the deck, if not return false.
   }
   
   public void sort()
   {
      //put all of the cards in the deck back into the right order according to 
      //their values.  Is there another method somewhere that already does this 
      //that you could refer to?
      
      Card.arraySort(this.cards, this.getNumCards());
   }
   
   public int getNumCards()
   {
      //return the number of cards remaining in the deck.
      return (topCard + 1);
   }
}
//END class Deck
