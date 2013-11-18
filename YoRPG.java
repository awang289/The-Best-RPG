//Andreas Wang, Kyle Oleksiuk, Cardi Wei
//Pd 8
//HW 26
//2013-11-18

/*=============================================
class YoRPG -- Driver file for Ye Olde Role Playing Game.
Simulates monster encounters of a wandering adventurer.
Required classes: Warrior, Monster
=============================================*/

import java.io.*;
import java.util.*;

public class YoRPG {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated
    private Character pat; //Is it man or woman?
    private Character smaug; //Friendly generic monster name, eh?

    private int moveCount;
    private boolean gameOver;
    private int difficulty;
    private int isSleep = 0;
    private int sleepy = 1;
    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
        moveCount = 0;
        gameOver = false;
        isr = new InputStreamReader( System.in );
        in = new BufferedReader( isr );
        newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
void newGame() -- facilitates info gathering to begin a new game
pre:
post: according to user input, modifies instance var for difficulty
and instantiates a Warrior
=============================================*/
    public void newGame() {

        String s;
        String name = "";
        String a;
        String class2 = "";
        s = "Welcome to Ye Olde RPG!\n";

        s += "\nChoose your difficulty: \n";
        s += "\t1: Easy\n";
        s += "\t2: Not so easy\n";
        s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
        s += "Selection: ";
        System.out.print( s );

        try {
         difficulty = Integer.parseInt( in.readLine() );
        }
        catch ( IOException e ) { }

        s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
        System.out.print( s );

        try {
         name = in.readLine();
        }
        catch ( IOException e ) { }

        //Warrior john = new Warrior("j");

        //System.out.println(john.about());

        a = name + ", what specie of adventurer be ye? (State your class):  Classes: Warrior, Mage, Stuyvesant Student, Rogue, Cyborg \n";
        System.out.print( a );

        try {
            class2 = in.readLine();
        }
        catch ( IOException e ) { }

        if (class2.equals("Warrior")){
            pat = new Warrior( name );
            System.out.println("Ah, a Warrior be Ye!");
        }
        else if(class2.equals("Stuyvesant Student")){
            pat = new Stuyvesant( name );
            System.out.println("Ah, a Stuyvesant Student be Ye!");
            isSleep = 1;
        }
        else if (class2.equals("Mage")){
            pat = new Mage( name );
            System.out.println("Ah, a Mage be Ye!");
        }
        else if(class2.equals("Rogue")){
            pat = new Rogue( name );
            System.out.println("Ah, a Rogue be Ye!");
        }
        else if(class2.equals("Cyborg")){
            pat = new Cyborg( name );
            System.out.println("Ah, a Cyborg be Ye!");
        }
        else {
            pat = new Warrior( name );
            System.out.println("Thy statement wast incomprehensible; as ye intelligence seems low, we find ye to be a Warrior!");
        }

      //  System.out.println(pat.getName()); TEST STUFF HERE

        System.out.println("==========CLASS SPECS==========");
        System.out.println(pat.about());
        System.out.println("===============================");

    }//end newGame()


    /*=============================================
boolean playTurn -- simulates a round of combat
pre: Warrior pat has been initialized
post: Returns true if player wins (monster dies).
Returns false if monster wins (player dies).
=============================================*/
    public boolean playTurn() {

        int i = 1;
        int d1, d2;

        if ( Math.random() >= ( difficulty / 3.0 ) )
         System.out.println( "Nothing to see here. Move along!" );

        else {
	    int k = (int) (Math.random() * 3);
	    if (k == 1)
	        smaug = new Monster();
	    else if (k == 2)
		 smaug = new Chimera();
	    else 
		 smaug = new Gorgon();
	    System.out.println( "Lo, yonder " + smaug.getName() + "  approacheth!" );
	
       

         while( smaug.isAlive() && pat.isAlive()) {

                // Give user the option of using a special attack:
                // If you land a hit, you incur greater damage,
                // ...but if you get hit, you take more damage.
                try {
                 System.out.println( "What do you want to do?" );
                 System.out.println( "\t1: Normal Attack.\n\t2: Special Attack! \n\t3: Heal" );
                 i = Integer.parseInt( in.readLine() );
                }
                catch ( IOException e ) { }
				    
		String crit = "";
		
		double critRoll = Math.random();
		if (i == 3) {
		    System.out.println (pat.getName() + " healed for " + pat.heal() + " HP."); }
                else {
		    if ( i == 2 )
			pat.specialize(); 
		    else
			pat.normalize();




		    ///// if is stuvesant and sleepy, sleep, if not dont
		    if (isSleep != 1 || (sleepy % 2 == 0)){

			if (critRoll >= pat.getCrt()) { 

			    d1 = pat.attack( smaug ) ; 
			}
		    
			else {

			    d1 = pat.crtAttack( smaug ) ; 

			    crit =  pat.getName() + " gottest the most critical of hits! ";

			}
			System.out.print(crit);
			System.out.println( pat.getName() + " dealt " + d1 +
					    " points of damage.");
		    }

		    else { 
			System.out.println(pat.getName() + " is sleeping this turn.");
			d1 = 0;

		    }
		
                sleepy += 1;
		}
                String crit2 = "";
                double critRoll2 = Math.random();
                if (critRoll2 >= smaug.getCrt()) { 
                    
                    d2 = smaug.attack( pat ) ; 
                }

                else {
                    d2 = smaug.crtAttack( pat );
                    crit2 =  "Ye Olde Monster gottest the most critical of hits! ";
                }



                System.out.print(crit2);
                System.out.println( "Ye Olde Monster hit back for " + d2 +
                                 " points of damage.");
         }//end while

         //option 1: you & the monster perish
         if ( !smaug.isAlive() && !pat.isAlive() ) {
                System.out.println( "'Twas an epic battle, to be sure... " +
                                 "You cut ye olde monster down, but " +
                                 "with its dying breath ye olde monster " +
                                 "laid a fatal blow upon thy skull." );
                return false;
         }
         //option 2: you slay the beast
         else if ( !smaug.isAlive() ) {
                System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
                return true;
         }
         //option 3: the beast slays you
         else if ( !pat.isAlive() ) {
                System.out.println( "Ye olde self hath expired. You got dead." );
                return false;
         }
    }//end else

        return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {

        //As usual, move the begin-comment bar down as you progressively
        //test each new bit of functionality...


        //loading...
        YoRPG game = new YoRPG();

        int encounters = 0;

        while( encounters < MAX_ENCOUNTERS ) {
         if ( !game.playTurn() )
                break;
         encounters++;
         System.out.println();
        }

        System.out.println( "Thy game doth be over." );

    }//end main

}//end class YoRPG

