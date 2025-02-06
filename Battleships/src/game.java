/******
 Mihir Patel & Nakul Patel
 Date Due: 06/04/2021
 Battle Ships Game
 File Description: This is where the actual 'game' code is written.
 ******/

import java.util.*;
import java.lang.Math;
import java.io.*;

class game {
    static Scanner _input = new Scanner(System.in);
    static String SCORESFILE = "scores.txt";
    static int col;
    static int row;
    static int compTargetRow;
    static int compTargetCol;
    static int compShip4Row = 0;
    static int compShip4Col = 0;
    static int compShip3HRow = 0;
    static int compShip3HCol = 0;
    static int compShip3VRow = 0;
    static int compShip3VCol = 0;
    static int compShip2Row = 0;
    static int compShip2Col = 0;
    static int userShipsSunk = 0;
    static int compShipsSunk = 0;
    static boolean compShip4Sunk = false;
    static boolean compShip3HSunk = false;
    static boolean compShip3VSunk = false;
    static boolean compShip2Sunk = false;
    static boolean userShip4Sunk = false;
    static boolean userShip3HSunk = false;
    static boolean userShip3VSunk = false;
    static boolean userShip2Sunk = false;
    static int ship4 = 0;
    static int ship4col = 0;
    static int ship3H = 0;
    static int ship3Hcol = 0;
    static int ship3V = 0;
    static int ship3Vcol = 0;
    static int ship2V = 0;
    static int ship2Vcol = 0;
    static int compShip4Hits = 0;
    static int compShip3HHits = 0;
    static int compShip3VHits = 0;
    static int compShip2Hits = 0;
    static int userShip4Hits = 0;
    static int userShip3HHits = 0;
    static int userShip3VHits = 0;
    static int userShip2Hits = 0;
    static int shipPlacementCheck = 0;
    static int turnsCounter = 0;
    static int[] scores = {0};
    static String LINEBREAK = "\n``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``";

    // User's Board Where They Choose Thir Ships
    static String[][] userShipBoard = {
            {"    ","1 ","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10 "},
            {"1   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"2   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"3   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"4   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"5   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"6   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"7   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"8   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"9   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"10  ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"}
    };

    // User's Target Board, Where They Target The Computer's Ship
    static String[][] userTargetBoard = {
            {"    ","1 ","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10 "},
            {"1   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"2   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"3   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"4   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"5   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"6   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"7   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"8   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"9   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"10  ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"}
    };

    //This Is The Computers Ship Board, Where Randomized Ships Are
    static String[][] compShipBoard = {
            {"    ","1 ","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10 "},
            {"1   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"2   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"3   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"4   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"5   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"6   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"7   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"8   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"9   ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"},
            {"10  ","- ","- ","- ","- ","- ","- ","- ","- ","- ","-"}
    };

    /*********************
     This is the main function
     *********************/

  /*
  Written By: Mihir and Nakul
  Started Writing Date: March 24th 2021
  */

    public static void main(String[] args) {
        clearUserShipBoard(userShipBoard);
        clearUserTargetBoard(userTargetBoard);
        clearCompShipBoard(compShipBoard);
        System.out.println("\n");

        shipPlacement();

        do {
            shipPlacementCheck = 0;
            compShipPlacement();
        } while(shipPlacementCheck != 12);

        do {
            System.out.println("\nYour Target Board (This Is Where You Can Target The Computer's Ship - 'X' = HIT and 'O' = MISS):\n ");
            for (int x = 0; x < 11; x++) {
                for (int y = 0; y < 11; y++) {
                    System.out.print(userTargetBoard[x][y]);
                }
                System.out.println();
            }

            usersTurn();
            compsTurn();
            userShipSunkCheck(userShipsSunk);
            compShipSunkCheck(compShipsSunk);
            turnsCounter++;

        } while(compShipsSunk!=4 && userShipsSunk!=4);

        recordScore();

        if(compShipsSunk == 4) {
            System.out.println(LINEBREAK);
            System.out.println("\nCongratulations! You Have Won The Game By Sinking All The Computer's Ships! You will now be taken to the mainscreen.");
            Main.mainScreen();
        } else {
            System.out.println(LINEBREAK);
            System.out.println("\nOh No! You Have Lost The Game Since The Computer Has Sunk All Your Ships! You will now be taken to the mainscreen.");
            Main.mainScreen();
        }
    }

    /*********************
     This is the users turn function where it runs all the code for when its the users turn to play . They would be targeting the computer's ships here by inputing the row and column number. You would also be notified if you sink the computer's ship.
     *********************/

  /*
  Written By: Mihir & Nakul
  Started Writing Date: March 30th 2021
  */

    static void usersTurn() {
        System.out.println("\nWhere Would You Like To Target?");
        try {
            do {
                System.out.print("\nRow: ");
                if(_input.hasNextInt())
                    row = _input.nextInt();
                else{
                    _input.next();
                    continue;
                }
                System.out.print("Column: ");
                if(_input.hasNextInt())
                    col = _input.nextInt();
                else{
                    _input.next();
                    continue;
                }
                if(row == 0 || col == 0 || row > 10 || col > 10) {
                    System.out.println("\nThat Move Is Not On The Board! Try Again!");
                }
            } while(row == 0 || col == 0 || row > 10 || col > 10);
        } catch(InputMismatchException IME2){
            System.out.println("Please Enter A Proper Value.");
            _input.next();
            usersTurn();
        }

        // This Is Where The It Checks If The Target The Users Chooses Hits Any Ship On The Computer's Ship Board

        if(compShipBoard[row][col] == "X " || compShipBoard[row][col] == "O ") {
            System.out.println("\nYou Have Already Targetted This Spot! Please Choose A New Spot!");
            usersTurn();
        }

        else if(compShipBoard[row][col] == "+ ") {
            System.out.println("\nHIT!\n");
            userTargetBoard[row][col] = "X ";
            compShipBoard[row][col] = "X ";

            if(compShip4Sunk==false) {
                for(int y = 0; y < 4; y++) {
                    if(compShipBoard[compShip4Row][compShip4Col + y] == "X ")
                        compShip4Hits++;
                    else
                        compShip4Hits = 0;
                }

                if(compShip4Hits >= 4) {
                    compShipsSunk++;
                    System.out.println("You have the sunk the computer's ship of 4.");
                    compShip4Sunk = true;
                }
            }

            if(compShip3HSunk==false) {
                for(int y = 0; y < 3; y++) {
                    if(compShipBoard[compShip3HRow][compShip3HCol + y] == "X ")
                        compShip3HHits++;
                    else
                        compShip3HHits = 0;
                }

                if(compShip3HHits >=  3) {
                    compShipsSunk++;
                    System.out.println("You have sunk the computers ship of 3 Horizontal.");
                    compShip3HSunk=true;
                }
            }

            if(compShip3VSunk==false){
                for(int y = 0; y < 3; y++) {
                    if(compShipBoard[compShip3VRow + y][compShip3VCol] == "X ")
                        compShip3VHits++;
                    else
                        compShip3VHits = 0;
                }

                if(compShip3VHits >= 3) {
                    compShipsSunk++;
                    System.out.println("You have sunk the computers ship of 3 Vertical.");
                    compShip3VSunk=true;
                }
            }

            if(compShip2Sunk=false) {
                for(int y = 0; y < 2; y++) {
                    if(compShipBoard[compShip2Row + y][compShip2Col] == "X ")
                        compShip2Hits++;
                    else
                        compShip2Hits = 0;
                }

                if(compShip2Hits >= 2) {
                    compShipsSunk++;
                    System.out.println("You have sunk the computers ship of 2.");
                    compShip2Sunk=true;
                }
            }
        }
        else {
            System.out.println("\nMISS!\n");
            userTargetBoard[row][col] = "O ";
            compShipBoard[row][col] = "O ";
        }

        System.out.println();
    }

    /*********************
     This is the computers turn function where it runs all the code for when its the computer's/AI's turn to play. The computer would be targeting the your ships here by randomzing the row and column number. You would also be notified if the computer sinks your ship.
     *********************/

  /*
  Written By: Mihir & Nakul
  Started Writing Date: March 31st 2021
  */

    static void compsTurn() {
        System.out.println("User's Ship Board\n");
        do {
            compTargetRow = (int)(Math.random() * 10) + 1;
            compTargetCol = (int)(Math.random() * 10) + 1;
        } while(userShipBoard[compTargetRow][compTargetCol] == "X " || userShipBoard[compTargetRow][compTargetCol] == "O ");

        if(userShipBoard[compTargetRow][compTargetCol] == "+ ")
            userShipBoard[compTargetRow][compTargetCol] = "X ";
        else
            userShipBoard[compTargetRow][compTargetCol] = "O ";

        if(userShip4Sunk==false) {
            for(int y = 0; y < 4; y++) {
                if(userShipBoard[ship4][ship4col + y] == "X ")
                    userShip4Hits++;
                else
                    userShip4Hits = 0;
            }

            if(userShip4Hits == 4) {
                userShipsSunk++;
                System.out.println("Your Ship Of 4 Horizontal Has Been Destroyed! That's Too Bad!");
                userShip4Sunk=true;
            }
        }

        if(userShip3HSunk==false) {
            for(int y = 0; y < 3; y++) {
                if(userShipBoard[ship3H][ship3Hcol + y] == "X ")
                    userShip3HHits++;
                else
                    userShip3HHits = 0;
            }

            if(userShip3HHits == 3) {
                userShipsSunk++;
                System.out.println("Your Ship Of 3 Horizontal Has Been Destroyed! That's Too Bad!");
                userShip3HSunk=true;
            }
        }

        if(userShip3VSunk==false) {
            for(int y = 0; y < 3; y++) {
                if(userShipBoard[ship3V + y][ship3Vcol]=="X ")
                    userShip3VHits++;
                else
                    userShip3VHits = 0;
            }

            if(userShip3VHits == 3) {
                userShipsSunk++;
                System.out.println("Your Ship Of 3 Vertical Has Been Destroyed! That's Too Bad!");
                userShip3VSunk=true;
            }
        }

        if(userShip2Sunk==false) {
            for(int y = 0; y < 2; y++) {
                if(userShipBoard[ship2V + y][ship2Vcol]=="X ")
                    userShip2Hits++;
                else
                    userShip2Hits = 0;
            }

            if(userShip2Hits == 2) {
                userShipsSunk++;
                System.out.println("Your Ship Of 2 Vertical Has Been Destroyed! That's Too Bad!");
                userShip2Sunk=true;
            }
        }

        for (int u = 0; u < 11; u++) {
            for(int w = 0; w < 11; w++) {
                System.out.print(userShipBoard[u][w]);
            }
            System.out.println();
        }


/*********************
 THE CODE BELOW LETS YOU SEE THE COMPUTERS SHIP BOARD SO IT IS EASIER TO BEAT OR LOSE THE GAME TO CHECK THE OUTPUTS. CURRENTLY IT IS COMMENTED OUT SO IT HAS TO BE PLAYED PROPERLY BUT REMOVING THE COMMENTS WILL MAKE THE GAME QUICKER TO PLAY AND CHECK.
 *********************/

    /* System.out.println("\nComputer's Ship Board\n");
    
    for (int u = 0; u < 11; u++) {
      for(int w = 0; w < 11; w++) {
        System.out.print(compShipBoard[u][w]);
      }
      System.out.println();
    } */
    }

    /*********************
     This is the ship placement of the user's function. Here the code is ran once where the user gets to place their ships. A board will be printed each time a ship is created to make it easier for the user to understand.
     *********************/

  /*
  Written By: Nakul
  Started Writing Date: March 26th 2021
  */

    static void shipPlacement() {
        try {
            do {

                for (int x = 0; x < 11; x++) {
                    for (int y = 0; y < 11; y++) {
                        System.out.print(userShipBoard[x][y]);
                    }
                    System.out.println();
                }

                //SHIP 4 HORIZONTAL
                System.out.print("\nChoose The Row Location For Your First Horizontal Ship (This Ship Will Be 4 Spots): ");
                if(_input.hasNextInt())
                    ship4 = _input.nextInt();
                else{
                    _input.next();
                    continue;
                }

                System.out.print("\nChoose The Column Location For Your First Horizontal Ship (This Ship Will Be 4 Spots): ");

                if(_input.hasNextInt())
                    ship4col = _input.nextInt();
                else{
                    _input.next();
                    continue;
                }
                // CHECKING IF ANY SHIPS GO OFF THE BOARD
                if((ship4 > 0 && ship4 < 11) && (ship4col > 0 && ship4col <= 7)) {
                    for(int y = 0; y < 4; y++) {
                        userShipBoard[ship4][ship4col + y] = "+ ";
                    }
                } else if ((ship4 <= 0 || ship4 > 10) || (ship4col <= 0 || ship4col > 7))
                    System.out.println("\nYou Can't Place Ships Outside The 10 By 10 Grid!");

                //SHIP PLACEMENT AFTER SETTING SPOT FOR THE FIRST SHIP
                System.out.println("\nYour Ship Placement Board:\n ");
                for (int x = 0; x < 11; x++) {
                    for (int y = 0; y < 11; y++) {
                        System.out.print(userShipBoard[x][y]);
                    }
                    System.out.println();
                }

                //SHIP 3 HORIZONTAL
                System.out.print("\nChoose The Row Location For Your Second Horizontal Ship (This Ship Will Be 3 Spots): ");
                if(_input.hasNextInt())
                    ship3H = _input.nextInt();
                else{
                    _input.next();
                    continue;
                }

                System.out.print("\nChoose The Column Location For Your Second Horizontal Ship (This Ship Will Be 3 Spots): ");

                if(_input.hasNextInt())
                    ship3Hcol = _input.nextInt();
                else{
                    _input.next();
                    continue;
                }

                // CHECKING IF ANY SHIPS GO OFF THE BOARD
                if((ship3H > 0 && ship3H < 11) && (ship3Hcol > 0 && ship3Hcol <= 8)) {
                    for(int y = 0; y < 3; y++) {
                        if(userShipBoard[ship3H][ship3Hcol + y]=="+ ")
                            shipOnBoard();
                        else
                            userShipBoard[ship3H][ship3Hcol + y] = "+ ";
                    }
                } else if ((ship3H <= 0 || ship3H > 10) || (ship3Hcol <= 0 || ship3Hcol > 8))
                    System.out.println("\nYou Can't Place Ships Outside The 10 By 10 Grid!");

                //SHIP PLACEMENT AFTER SETTING SPOT FOR THE SECOND SHIP
                System.out.println("\nYour Ship Placement Board:\n ");
                for (int x = 0; x < 11; x++) {
                    for (int y = 0; y < 11; y++) {
                        System.out.print(userShipBoard[x][y]);
                    }
                    System.out.println();
                }

                //SHIP 3 VERTICAL
                System.out.print("\nChoose The Row Location For Your First Vertical Ship (This Ship Will Be 3 Spots): ");
                if(_input.hasNextInt())
                    ship3V = _input.nextInt();
                else{
                    _input.next();
                    continue;
                }

                System.out.print("\nChoose The Column Location For Your First Vertical Ship (This Ship Will Be 3 Spots): ");

                if(_input.hasNextInt())
                    ship3Vcol = _input.nextInt();
                else{
                    _input.next();
                    continue;
                }

                if((ship3V > 0 && ship3V <=8 ) && (ship3Vcol > 0 && ship3Vcol <= 10)) {
                    for(int y = 0; y < 3; y++) {
                        if(userShipBoard[ship3V + y][ship3Vcol] == "+ ")
                            shipOnBoard();
                        else
                            userShipBoard[ship3V + y][ship3Vcol] = "+ ";
                    }
                } else if ((ship3V <= 0 || ship3V > 8) || (ship3Vcol <= 0 || ship3Vcol >= 10))
                    System.out.println("\nYou Can't Place Ships Outside The 10 By 10 Grid!");

                //SHIP PLACEMENT AFTER SETTING SPOT FOR THE THIRD SHIP
                System.out.println("\nYour Ship Placement Board:\n ");
                for (int x = 0; x < 11; x++) {
                    for (int y = 0; y < 11; y++) {
                        System.out.print(userShipBoard[x][y]);
                    }
                    System.out.println();
                }

                //SHIP 2 VERTICAL
                System.out.print("\nChoose The Row Location For Your Second Vertical Ship (This Ship Will Be 2 Spots): ");
                if(_input.hasNextInt())
                    ship2V = _input.nextInt();
                else{
                    _input.next();
                    continue;
                }

                System.out.print("\nChoose The Column Location For Your First Vertical Ship (This Ship Will Be 2 Spots): ");

                if(_input.hasNextInt())
                    ship2Vcol = _input.nextInt();
                else{
                    _input.next();
                    continue;
                }

                if((ship2V > 0 && ship2V <= 9) && (ship2Vcol > 0 && ship2Vcol <= 10)) {
                    for(int y = 0; y < 2; y++) {
                        if(userShipBoard[ship2V + y][ship2Vcol]=="+ ")
                            shipOnBoard();
                        else
                            userShipBoard[ship2V + y][ship2Vcol] = "+ ";
                    }
                } else if ((ship2V <= 0 || ship2V > 9) || (ship2Vcol <= 0 || ship2Vcol >= 10))
                    System.out.println("\nYou Can't Place Ships Outside The 10 By 10 Grid!");

                /* HERE IF THE USER PUTS A VALUE THAT WOULD MAKE THE SHIP BE CREATED OUTSIDE THE GRID, THE USER WILL BE TOLD THIS MESSAGE THAT THEY HAVE TO RESTART THE PLACEMENT AGAIN AND THE SHIP BOARD WILL BE CLEARED. */
                if(ship2V <= 0 || ship2V > 9 || ship2Vcol <= 0 || ship2Vcol >= 10||ship3V <= 0 || ship3V > 8 || ship3Vcol <= 0 || ship3Vcol >= 10||ship3H <= 0 || ship3H > 10 || ship3Hcol <= 0 || ship3Hcol > 8||ship4 <= 0 || ship4 > 10 || ship4col <= 0 || ship4col > 7){
                    System.out.println(LINEBREAK);
                    System.out.println("\nOne or more of your ships were placed outside the grid. You will be asked to place all the ships again.\n");
                    clearUserShipBoard(userShipBoard);
                }

                /* The while loop below contains many checks to see if any rows or columns the user enters is outside the grid or have the ship end up outside the grid. */
            } while(ship2V <= 0 || ship2V > 9 || ship2Vcol <= 0 || ship2Vcol >= 10||ship3V <= 0 || ship3V > 8 || ship3Vcol <= 0 || ship3Vcol >= 10||ship3H <= 0 || ship3H > 10 || ship3Hcol <= 0 || ship3Hcol > 8||ship4 <= 0 || ship4 > 10 || ship4col <= 0 || ship4col > 7);

        } catch(InputMismatchException IME) {
            // Here if the user enters a value other than an int, they will be told that the value enter is not acceptable and will have to keep putting the value until he matches the data type required.
            System.out.println("Please Enter A Proper Value.");
            _input.next();
            shipPlacement();
        }

        // SHIP PLACEMENTS OF ALL THE BOATS
        System.out.println("\nYour Ship Placement Board:\n ");
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                System.out.print(userShipBoard[x][y]);
            }
            System.out.println();
        }
    }

    /*********************
     This is where the computer randomly places the ships on its board.
     *********************/

  /*
  Written By: Mihir 
  Started Writing Date: March 26th 2021
  */

    static void compShipPlacement() {
        // This Is The Code Where The Computer Auto Generates Ship Placements
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                if(compShipBoard[x][y] == "+ ")
                    compShipBoard[x][y] = "- ";
            }
        }

        compShip4Row = (int)(Math.random() * 10) + 1;
        compShip4Col = (int)(Math.random() * 7) + 1;

        compShip3HRow = (int)(Math.random() * 10) + 1;
        compShip3HCol = (int)(Math.random() * 8) + 1;

        compShip3VRow = (int)(Math.random() * 8) + 1;
        compShip3VCol = (int)(Math.random() * 10) + 1;

        compShip2Row = (int)(Math.random() * 9) + 1;
        compShip2Col = (int)(Math.random() * 10) + 1;

        for(int y = 0; y < 4; y++) {
            compShipBoard[compShip4Row][compShip4Col + y] = "+ ";
        }
        for(int y = 0; y < 3; y++) {
            compShipBoard[compShip3HRow][compShip3HCol + y] = "+ ";
        }
        for(int y = 0; y < 3; y++) {
            compShipBoard[compShip3VRow + y][compShip3VCol] = "+ ";
        }
        for(int y = 0; y < 2; y++) {
            compShipBoard[compShip2Row + y][compShip2Col] = "+ ";
        }

        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                if(compShipBoard[x][y] == "+ ")
                    shipPlacementCheck++;
            }
        }
    }

    /*********************
     This is an error check function where it is only ran if the ship the user is placing is overlapping with a ship already placed. If it does overlap, it will clear the whole board and ask you to re-deploy the ships.
     *********************/

  /*
  Written By: Mihir
  Started Writing Date: March 30th 2021
  */

    static void shipOnBoard() {
        System.out.println("\nThe Ship You Are Trying To Place Overlaps With Another Ship! The Board Will Remove All The Boats And You Must Start The Placement Again!\n");
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                if(userShipBoard[x][y] == "+ ")
                    userShipBoard[x][y] = "- ";
                System.out.print(userShipBoard[x][y]);
            }
            System.out.println();
        }
        shipPlacement();
    }

    /*********************
     This is where the number of moves a user makes is recorded. It is the main marking method for the user which will be displayed in the scoreboard. It will be recorded in a text file which is read in the Main.
     *********************/

  /*
  Written By: Nakul
  Started Writing Date: April 1st 2021
  */

    static void recordScore() {

        int scoreOutput = 0;

        try {
            BufferedWriter BW = new BufferedWriter(new FileWriter(SCORESFILE, true));
            if(compShipsSunk>=4){
                scores = Arrays.copyOf(scores, scores.length+1);
                scores[scores.length - 1] = turnsCounter;
                scoreOutput = scores[scores.length-1];
                BW.write(", " + scoreOutput);
            }
            else if(userShipsSunk>=4)
                BW.write(", LOSE");

            BW.close();
        } catch(IOException ioe) {
            System.out.println("\nError Is: " + ioe);
        };
    }

  /*
  Next Three Functions Written By: Mihir
  Started Writing Date: April 2nd 2021
  */

    static String[][] clearUserShipBoard(String[][] userShip) {
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                if(userShip[x][y] == "O "||userShip[x][y] == "X "||userShip[x][y] == "+ ")
                    userShip[x][y] = "- ";
            }
        }
        return userShipBoard = userShip;
    }

    static String[][] clearUserTargetBoard(String[][] userTarget) {
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                if(userTarget[x][y] == "O "||userTarget[x][y] == "X "||userTarget[x][y] == "+ ")
                    userTarget[x][y] = "- ";
            }
        }
        return userTargetBoard = userTarget;
    }

    static String[][] clearCompShipBoard(String[][] compShip){
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                if(compShip[x][y] == "O "||compShip[x][y] == "X "||compShip[x][y] == "+ ")
                    compShip[x][y] = "- ";
            }
        }
        return compShipBoard = compShip;
    }

  /*
  Written By: Mihir
  Started Writing Date: April 3rd 2021
  */

    static int userShipSunkCheck(int w) {
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                if(userShipBoard[x][y] == "X ")
                    w++;
            }
        }
        if(w >= 12){
            System.out.println(LINEBREAK);
            System.out.println("If you recieve this measage then a problem has occured when calculating your score. Nevertheless, your ships have all sunk and have lost the game!");
            return userShipsSunk = 4;
        }
        else
            return userShipsSunk = 0;
    }

  /*
  Written By: Mihir
  Started Writing Date: April 3rd
  */

    static int compShipSunkCheck(int z) {
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                if(compShipBoard[x][y] == "X ")
                    z++;
            }
        }
        if(z >= 12){
            System.out.println(LINEBREAK);
            System.out.println("If you recieve this measage then a problem has occured when calculating your score. Nevertheless, you have sunk all the ships and have won the game!");
            return compShipsSunk = 4;
        }
        else
            return compShipsSunk = 0;
    }
}