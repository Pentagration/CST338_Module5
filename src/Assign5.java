import javax.swing.*;
import java.awt.*;

public class Assign5 
{  
   //52 standard playing cards + 4 jokers + 1 back-of-card image = 57
   static final int NUM_CARD_IMAGES = 57; 
   static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];

   static void loadCardIcons()
   {
      // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
      int count = 0;

      for (int suit = 0; suit < 4; suit++)
      {
         for (int value = 0; value < 14; value++)
         {
            icon[count] = new ImageIcon("images/" + turnIntIntoCardValue(value)
               + turnIntIntoCardSuit(suit) + ".gif");
            count++;
         }
      }
      icon[count] = new ImageIcon("images/BK.gif");
   }

   // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
   static String turnIntIntoCardValue(int value)
   {
      String cardValues[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", 
            "T", "J", "Q", "K", "X"};   
      return cardValues[value];
   }

   // turns 0 - 3 into "C", "D", "H", "S"
   static String turnIntIntoCardSuit(int suit)
   {
      String cardSuits[] = {"C", "D", "H", "S"};
      return cardSuits[suit];
   }

   // a simple main to throw all the JLabels out there for the world to see
   public static void main(String[] args)
   {
      int k;

      // prepare the image icon array
      loadCardIcons();

      // establish main frame in which program will run
      JFrame frmMyWindow = new JFrame("Card Room");
      frmMyWindow.setSize(1150, 650);
      frmMyWindow.setLocationRelativeTo(null);
      frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // set up layout which will control placement of buttons, etc.
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);   
      frmMyWindow.setLayout(layout);

      // prepare the image label array
      JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         labels[k] = new JLabel(icon[k]);

      // place your 3 controls into frame
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         frmMyWindow.add(labels[k]);

      // show everything to the user
      frmMyWindow.setVisible(true);
   }
}