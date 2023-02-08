

import java.util.Scanner;
//import java.util.Random;

@SuppressWarnings("ALL")

public class Console {

static NodeMap map;
static Scanner io;

public Console(NodeMap map) {


    io = new Scanner(System.in);
    PlayerStats playerStats = new PlayerStats();
    
//Keeps the program running until it runs out of nodes or reaches the end.
    while(map.currentNode() != null){

        Boolean canPassOptionOne = true;
        Boolean canPassOptionTwo = true;

        //Adds points gained from current node if points are to be gained.
        playerStats.addCoolnessPoints(map.currentNode().getCoolnessGained());

        print(map.currentNode().getDescription());
        print(map.currentNode().getOptionOneText());
        print(map.currentNode().getOptionTwoText());


        print(playerStats.toString());

//If statement will allow looping once the user reaches the end of the game.
        if (map.currentNode().getOptionTwoText().equals("-")) {

            map.decision(fromConsoleGetInt("Select Option 1 to restart", canPassOptionOne, canPassOptionTwo));
            playerStats.resetStats();

        } 
        
        else {

            canPassOptionOne = map.canPassOptionOne(map, playerStats);
            canPassOptionTwo = map.canPassOptionTwo(map, playerStats);

            print("Can pass option One: " + canPassOptionOne);
            print("Can pass option Two: " + canPassOptionTwo);

            map.decision(fromConsoleGetInt("Enter either option 1 or 2", canPassOptionOne, canPassOptionTwo));

        }
        
    }
    
}

//Obtains the numerical input and returns the decision.
public int fromConsoleGetInt(String prompt, Boolean canPassOptionOne, Boolean canPassOptionTwo){

    print(prompt);
    int returnValue = 0;

    if(canPassOptionOne == false | canPassOptionTwo == false){

        print("You do not have the stats required.");

        if(canPassOptionOne == false){
            while (returnValue != 2){

                returnValue = io.nextInt();

            }
        }

        else if (canPassOptionTwo == false){
            while (returnValue != 1){

                returnValue = io.nextInt();

            }
        }
        

    }

    else{

    returnValue = io.nextInt();
    //int returnValue = randNumber();
    
    }

    
    return returnValue;

}

//Allows the user to press enter to continue.
public  void pressEnterToContinue(){
    
    print("Press the Enter key to continue...");
    try {System.in.read();}
    catch(Exception e) {}

}

public void print(String info){System.out.println(info);}

//private int randNumber(){
//
//    Random rand = new Random();
//    int randomInteger = rand.nextInt((2 - 1) + 1) + 1;
//    return randomInteger;
//
//}


}