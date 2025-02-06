/******
 Mihir Patel & Nakul Patel
 Date Due: 06/04/2021
 Battle Ships Game
 File Description: This is where the main menu, intructions, and scoreboard code is written. Primary user interface.
 ******/

import java.io.*;
import java.util.*;

class Main {
    static String name = null;
    static Scanner _input = new Scanner(System.in);
    static String MENUSCREENFILE = "menuScreen.txt";
    static String SCORESFILE = "scores.txt";
    static String menuInput = null;
    static String[] names = {"Names: "};
    static String LINEBREAK = "\n``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``";
    static int back;

    /*********************
     This is the main function which is the very first thing that will print in the console. It will print out a text file which is like the homepage of the code. It will also ask the user for their name which will help store their score in the future.
     *********************/

  /*
  Written By: Nakul
  Started Writing Date: March 25th 2021
  */

    public static void main(String[] args) {
        String menuScreenData = null;
        String nameOutput = null;

        try {
            BufferedReader _BR = new BufferedReader(new FileReader(MENUSCREENFILE));

            BufferedWriter _BW = new BufferedWriter(new FileWriter(SCORESFILE, true));

            menuScreenData = _BR.readLine();
            System.out.println(menuScreenData);

            while (menuScreenData!=null) {
                System.out.println(menuScreenData);
                menuScreenData = _BR.readLine();
            }

            while (name == null) {
                System.out.print("\nWhat's Your Name? ");
                name = _input.nextLine();
                System.out.println("\nHello " + name + "!!! Let's Begin!");
            }

            names = Arrays.copyOf(names, names.length+1);
            names[names.length - 1] = name;
            nameOutput = names[names.length-1];
            _BW.write("\n"+nameOutput);

            _BR.close();
            _BW.close();

        } catch (IOException iox) {
            System.out.println("Error: " + iox);
        };
        menuInput();
    }

    /*********************
     This is the menu input function where it will ask the user for their input and take them to which ever page they want to go.
     *********************/

  /*
  Written By: Nakul
  Started Writing Date: March 25th 2021
  */

    static void menuInput() {
        do {
            try {
                System.out.print("\nWaiting for Input ... ");
                menuInput = _input.nextLine();

                if (menuInput.equals("1")) { // the actual game
                    System.out.println(LINEBREAK);
                    System.out.println("\nIt's Time For Battle Ships!");
                    String[] args = {};
                    game.main(args);
                }
                else if (menuInput.equals("2")) { // instructions page
                    System.out.println(LINEBREAK);
                    instructions();
                }
                else if (menuInput.equals("3")) { // scoreboard page
                    System.out.println(LINEBREAK);
                    leaderBoard();
                }
                else if (menuInput.equals("4")) { // exit the program
                    recordIncomplete();
                    System.out.println(LINEBREAK);
                    System.out.println("\nThanks For Playing " + name + "! Have A Wonderful Day!");
                    System.exit(0);
                }
                else
                    System.out.println("\nNot A Proper Entry. Please Try Again.\n");

            } catch (InputMismatchException IME) {
                System.out.println("\nError Is: " + IME);
            }
        } while ((!menuInput.equals("1"))||(!menuInput.equals("2"))||(!menuInput.equals("3"))||(!menuInput.equals("4")));
    }

    /*********************
     This is the main screen function where it will display all the menu options to navigate through.
     *********************/

  /*
  Written By: Nakul
  Started Writing Date: March 26th 2021
  */

    static void mainScreen() {
        System.out.println(LINEBREAK);
        System.out.println("\nWhat Would You Like To Do (Type In The Number And Press Enter)?\n");
        System.out.println("1: Play Game");
        System.out.println("2: Instructions");
        System.out.println("3: Score Board");
        System.out.println("4: Quit");
        menuInput();
    }

    /*********************
     This is the instructions function where it will print out the objective of the game and the basic instructions. Helpful to those who haven't played battle ships before.
     *********************/

  /*
  Written By: Nakul
  Started Writing Date: March 30th 2021
  */

    static void instructions() {
        System.out.println("\nHow To Play Battle Ship!\n");
        System.out.println("OBJECTIVE\n---------");
        System.out.println("1. The objective of the game is to destroy the computers ships before the computer can destroy yours.\n2. You must do this by figuring out where the computer has placed it's ships and then target those areas on the board.\n3. There are 4 ships in total that you must have to destroy.\n\t- Ship one is four spaces horizontal.\n\t- Ship two is three spaces horizontal.\n\t- Ship three is three spaces vertical.\n\t- Ship four is two spaces vertical.");
        System.out.println("\nCONTROLS\n--------");
        System.out.println("1. Once you start to play the game, you will be told to type in your ship placements.\n2. After the four ships are placed onto the board, the computer will randomize it's ship placements.\n3. Next, you will be told to type in the row and column number that you want to target on the computer's board.\n\t- If it is a HIT, it will print 'X'.\n\t- If it is a MISS, it will print 'O'.\n4. You will be notified when you sink a ship or when your ship sinks.");

        // exit the instructions page
        System.out.print("\nPress 1 and Enter to Go Back To The Main Screen!\n");

        do {
            System.out.print("\nWaiting for Input... ");
            back = _input.nextInt();
            if (back == 1) {
                System.out.println(LINEBREAK);
                mainScreen();
            } else
                System.out.println("\nNot A Proper Entry. Please Try Again.");
        } while(back != 1);
    }

    /*********************
     This is the scoreboard function where it will print out all the users that have played the game and their scores. When you first start playing the game, it will automatically add your name onto the scoreboard.
     *********************/

  /*
  Written By: Nakul
  Started Writing Date: April 2nd 2021
  */

    static void leaderBoard() {
        System.out.println("\nSCOREBOARD");
        System.out.println("----------\n");
        try {
            BufferedReader _BR2 = new BufferedReader(new FileReader(SCORESFILE));
            String line = null;
            line = _BR2.readLine();
            while(line != null) {
                System.out.println(line);
                line = _BR2.readLine();
            }
            _BR2.close();
        } catch (IOException iox) {
            System.out.println("\nError Is: " + iox);
        };

        // exit the scoreboard page
        System.out.print("\nPress 1 and Enter to Go Back To The Home Screen!\n");

        do {
            System.out.print("\nWaiting for Input... ");
            back = _input.nextInt();
            if (back == 1) {
                System.out.println(LINEBREAK);
                mainScreen();
            } else
                System.out.println("\nNot A Proper Entry. Please Try Again.");
        } while (back != 1);
    }

  /*
  Written By: Mihir
  Date: April 3rd 2021
  */

    static void recordIncomplete() {
        try{
            BufferedWriter _BWIncomplete = new BufferedWriter(new FileWriter(SCORESFILE, true));

            _BWIncomplete.write(", Exited");

            _BWIncomplete.close();

        } catch(IOException iox) {
        };
    }
}