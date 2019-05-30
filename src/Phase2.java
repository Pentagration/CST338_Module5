import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class Phase2
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
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
      myCardTable.setVisible(true);

      // CREATE LABELS ----------------------------------------------------
      code goes here ...
  
      // ADD LABELS TO PANELS -----------------------------------------
      code goes here ...
      
      // and two random cards in the play region (simulating a computer/hum ply)
      code goes here ...

      // show everything to the user
      myCardTable.setVisible(true);
   }
}

public class CardTable extends JFrame
{
   static int MAX_CARDS_PER_HAND = 56;
   static int MAX_PLAYERS = 2;
   
   private int numCardsPerHand;
   private int numPlayers;
   
   //three panels that will appear in the GUI from top to bottom
   public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;
   
   /*I INTERPRET THE INSTRUCTIONS TO MEAN WE DON'T NEED A DEFAULT CONSTRUCTOR
   CardTable()
   {
      
   }
   */
   
   CardTable(String title, int numCardsPerHand, int numPlayers)
   {
      
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

